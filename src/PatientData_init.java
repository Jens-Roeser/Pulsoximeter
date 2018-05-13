/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.List;
import java.util.ArrayList;
/**
 *
 * @author Jens
 */
public class PatientData_init extends javax.swing.JFrame {

    Display display = new Display();
    Setlimitstartup startup = new Setlimitstartup(display);
    private PatientData pat = new PatientData();
    /**
     * Creates new form PatientData
     */
    public PatientData_init() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Patient_data_heading3 = new javax.swing.JLabel();
        name3 = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        surname_field = new javax.swing.JTextField();
        surname3 = new javax.swing.JLabel();
        sex3 = new javax.swing.JLabel();
        sex_box3 = new javax.swing.JComboBox<>();
        birthdate3 = new javax.swing.JLabel();
        cancel_patient = new javax.swing.JButton();
        savepatient3 = new javax.swing.JButton();
        day = new javax.swing.JComboBox<>();
        day_lab = new javax.swing.JLabel();
        month = new javax.swing.JComboBox<>();
        month_lab = new javax.swing.JLabel();
        year = new javax.swing.JComboBox<>();
        year_lab = new javax.swing.JLabel();
        load = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        Patient_data_heading3.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        Patient_data_heading3.setText("Insert Patient data");

        name3.setText("Patient name:");

        name_field.setText("insert name");
        name_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                name_fieldMouseClicked(evt);
            }
        });

        surname_field.setText("instert surname");
        surname_field.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                surname_fieldMouseClicked(evt);
            }
        });

        surname3.setText("Patient surname:");

        sex3.setText("Patient sex: ");

        sex_box3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "unknown", "male", "female" }));

        birthdate3.setText("Patient birthdate:");

        cancel_patient.setText("cancel");
        cancel_patient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_patientActionPerformed(evt);
            }
        });

        savepatient3.setText("save");
        savepatient3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savepatient3ActionPerformed(evt);
            }
        });

        day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        day_lab.setText("Day");

        month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        month_lab.setText("Month");

        year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1900" }));
        year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearActionPerformed(evt);
            }
        });

        year_lab.setText("Year");

        load.setText("load");
        load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name3)
                            .addComponent(surname3)
                            .addComponent(sex3)
                            .addComponent(birthdate3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(surname_field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sex_box3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(day_lab)
                                        .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(month_lab)
                                            .addGap(18, 18, 18)
                                            .addComponent(year_lab))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(savepatient3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(load, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cancel_patient, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(name_field)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Patient_data_heading3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Patient_data_heading3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name3)
                    .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surname3)
                    .addComponent(surname_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sex3)
                    .addComponent(sex_box3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(birthdate3)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day_lab)
                            .addComponent(month_lab)
                            .addComponent(year_lab))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(day, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(savepatient3)
                    .addComponent(cancel_patient)
                    .addComponent(load))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_name_fieldMouseClicked
        name_field.setText("");
    }//GEN-LAST:event_name_fieldMouseClicked

    private void surname_fieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_surname_fieldMouseClicked
        surname_field.setText("");
    }//GEN-LAST:event_surname_fieldMouseClicked

    private void cancel_patientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_patientActionPerformed
        display.updatepatient("X", "X", "X", "X", 0);
        startup.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancel_patientActionPerformed

    private void savepatient3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savepatient3ActionPerformed
        String name = name_field.getText();
        String surname = surname_field.getText();
        String sex = (String)sex_box3.getSelectedItem();
        String gday = (String)day.getSelectedItem();
        String gmonth = (String)month.getSelectedItem();
        String gyear = (String)year.getSelectedItem();

        String birthdate = gday + "." + gmonth + "." + gyear;
        int age = pat.addpatient(name, surname, sex, birthdate);
        display.updatepatient(name, surname, sex, birthdate, age);
        display.updatelimit("40", "160","80");
        display.setVisible(true); 
        setVisible(false);
    }//GEN-LAST:event_savepatient3ActionPerformed

    private void yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearActionPerformed

    private void loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadActionPerformed
        pat.loadpatient();
    }//GEN-LAST:event_loadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientData_init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientData_init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientData_init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientData_init.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientData_init().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Patient_data_heading3;
    private javax.swing.JLabel birthdate3;
    private javax.swing.JButton cancel_patient;
    private javax.swing.JComboBox<String> day;
    private javax.swing.JLabel day_lab;
    private javax.swing.JButton load;
    private javax.swing.JComboBox<String> month;
    private javax.swing.JLabel month_lab;
    private javax.swing.JLabel name3;
    private javax.swing.JTextField name_field;
    private javax.swing.JButton savepatient3;
    private javax.swing.JLabel sex3;
    private javax.swing.JComboBox<String> sex_box3;
    private javax.swing.JLabel surname3;
    private javax.swing.JTextField surname_field;
    private javax.swing.JComboBox<String> year;
    private javax.swing.JLabel year_lab;
    // End of variables declaration//GEN-END:variables
}
