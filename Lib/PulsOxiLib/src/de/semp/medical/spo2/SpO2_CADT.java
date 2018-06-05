/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.semp.medical.spo2;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import de.semp.medical.spo2.ISpO2Observer.ErrorState;
import java.io.InputStream;

/**
 * Represents the CADT SpO2 hardware sensor.
 * This sensor is using serial port communication.
 * NOTE: The library jSerialComm-2.0.2.jar is required as run-time library for other projects. This library is included in subdirectory libs.
 * serial port documentation / protocol  http://www.cadt.de
 * @author dubies
 */

public class SpO2_CADT extends SpO2Sensor {

    String[] sPorts;

    public SpO2_CADT() {
        SerialPort[] ports = SerialPort.getCommPorts();
        sPorts = new String[ports.length];
        for (int i = 0; i < ports.length; i++) {
            SerialPort sp = ports[i];
            sPorts[i] = sp.getSystemPortName();
        }
        sp = SerialPort.getCommPorts()[0];
    }

    private SerialPort sp;

    private final byte MarkChar = (byte) 0xFF;
    private final byte QuoteChar = (byte) 0xFE;
    private final byte AckChar = (byte) 0xFD;
    private final byte NakChar = (byte) 0xFC;
    private final byte EventChar = (byte) 0xFB;

    private final char IBOK = 0x00;
    private final char IBSensorDisconnected = 0x01;
    private final char IBNoFingerInProbe = 0x02;
    private final char IBLowPerfusion = 0x03;
    private final char IBSelftestError = 0x45;
    //  private final byte[] cPacket = new byte[128];

    private int dataIndex = 0;
    private int iPhase = 99;
    private short sequenceNr;
    private short checksum;
    private short packetType;
    private short packetSize;
    private char[] packetBuf = new char[127];

    private boolean bQuote = false;

    private ErrorState state = ErrorState.OK;

    @Override
    public void start() {

        sp.openPort();
        sp.setComPortParameters(57600, 8, SerialPort.ONE_STOP_BIT, SerialPort.NO_PARITY);
        run = true;
        sp.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent spe) {
                if (spe.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    return;
                }

                int available = sp.bytesAvailable();
                byte[] newData = new byte[available];
                int numRead = sp.readBytes(newData, newData.length);

                for (int i = 0; i < numRead; i++) {
                    byte b1 = newData[i];

                    if (b1 == MarkChar) {
                        dataIndex = 0;
                        bQuote = false;
                        iPhase = 0;
                    } else if (b1 == QuoteChar) {
                        bQuote = true;
                    } else if (b1 == AckChar) {
                        iPhase = 6;
                    } else if (b1 == NakChar) {
                        iPhase = 8;
                    } else if (b1 == EventChar) {// drop event character
                        iPhase = 99;
                    } else if (iPhase == 0) { // get sequence number
                        sequenceNr = (short) (b1 & 0x07F);

                        //  System.out.println("Sequenznummer: " + sequenceNr);
                        checksum = sequenceNr;
                        iPhase++;
                    } else if (iPhase == 1) {				// get packet type number
                        packetType = (short) (b1 & 0x07F);
                        //  System.out.println("Paket-Typ: " + packetType);
                        checksum += packetType;
                        iPhase++;
                    } else if (iPhase == 2) {
                        packetSize = (short) (b1 & 0x0FF);
                        checksum += packetSize;
                        iPhase++;
                    } else if (iPhase == 3) {
                        if (bQuote) {
                            b1 |= 0x80;
                            bQuote = false;
                        }
                        checksum += b1;

                        packetBuf[dataIndex++] = (char) (b1 & 0xFF);

                        if (dataIndex == packetSize) {

                            if (packetType == 36) {

                                char bInfo = (char) (packetBuf[34] & 0x0FF);

                                ErrorState oldState = state;

                                if (bInfo == IBOK) {
                                    state = ErrorState.OK;
                                } else if (bInfo == IBSensorDisconnected) {
                                    state = ErrorState.SensorDisconnect;
                                } else if (bInfo == IBNoFingerInProbe) {
                                    state = ErrorState.FingerOut;
                                } else if (bInfo == IBLowPerfusion) {
                                    state = ErrorState.LowPerfusion;
                                } else if (bInfo == IBSelftestError) {
                                    state = ErrorState.SensorDisconnect;
                                }

                                if (state != oldState) {
                                    notifyStateChange(state);
                                }

                                short px = (short) ((packetBuf[40] & 0x0FF) + (packetBuf[41] << 8));

                                hr = (int) Math.floor(px * 0.1);

                                short sx = (short) ((packetBuf[46] & 0x0FF) + (packetBuf[47] << 8));
                                spo2 = (int) Math.floor(sx * 0.1);

                                notifyObservers();
                            }
                            iPhase++;
                        }
                    }
                }
            }
        });
        
    }

    @Override
    public void stop() {
        sp.closePort();
    }

    /**
     * Returns all possible com ports.
     * @return Name of all possible com ports in the system.
     */
    public String[] getPossibleComPorts() {
        return sPorts;
    }

    /**
     * Sets the com port to be used for the connection with the sensor.
     * @param port The com port to be used for connection.
     */
    public void setComport(String port) {
        sp = SerialPort.getCommPort(port);
    }
}
