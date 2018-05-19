/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author Jens
 */
public class PatientData {
    private int age;
    private Connection conn;
    private PreparedStatement pst;
    private PreparedStatement r_out;
    private Statement stat;
    private ResultSet res;
    private Date date = new Date();
    private String dateString;
    private int maxid;
        
    PatientData(){
        this.conn = null;
        this.pst = null;
        this.r_out = null;
        this.stat = null;
        this.res = null;
        dateString = null;
    }


    protected int addpatient(String name, String surname, String sex, String birthdate) {        
        SimpleDateFormat data = new SimpleDateFormat("dd.MM.yyyy");
        String date_form = data.format(date);
        
        String[] act = date_form.split("\\.");
        String[] birth = birthdate.split("\\.");
        
        int month = (Integer.parseInt(act[1]) - Integer.parseInt(birth[1]));
        // month bigger 0 means birthday was already
        if (month > 0){
            int act_int = Integer.parseInt(act[2]);
            int birth_int = Integer.parseInt(birth[2]);
            age = (act_int - birth_int);
        }
        else if (month == 0){
             int day = (Integer.parseInt(act[0]) - Integer.parseInt(birth[0]));
             if (day > 0){
                int act_int = Integer.parseInt(act[2]);
                int birth_int = Integer.parseInt(birth[2]);
                age = (act_int - birth_int);
             }
             //no birthday
             else if (day < 0){
                 age = (Integer.parseInt(act[2]) - Integer.parseInt(birth[2]) - 1);
             }
             // birthday is today 
             else {
                 age = (Integer.parseInt(act[2]) - Integer.parseInt(birth[2]));
             }
        }
        else if (month < 0){
            age = (Integer.parseInt(act[2]) - Integer.parseInt(birth[2]) - 1);
        }
        
       try{    
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Patient", "Menodar", "Student311");
            stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("SELECT MAX(ID) as maxid FROM Patient");
            if(rs.next()) { 
                maxid = rs.getInt("maxid"); 
            }
        
            pst = conn.prepareStatement("insert into Patient values (?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, sex);
            pst.setString(4, birthdate);
            pst.setInt(5, age);
            pst.setInt(6, (maxid +1));
            int i = pst.executeUpdate();
            if (i > 0){
                JOptionPane.showMessageDialog(null, "Patient saved");
            }
            else{
                JOptionPane.showMessageDialog(null, "Patient saving failed");
            }
        }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Patient saving failed");
       }
       return age;
    }
    protected void loadpatient(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Patient", "Menodar", "Student311");
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Patient");
            if(rs.next()) { 
                // TODO: select get all DAta from Table (array List)
                // Return List to COmbobox to select. 
                int id = rs.getInt("ID"); 
                String str1 = rs.getString("second_column_name");
            }
            conn.close();
            
            //stat = conn.createStatement();
            int i = pst.executeUpdate();
            if (i > 0){
                JOptionPane.showMessageDialog(null, "Patient saved");
            }
            else{
                JOptionPane.showMessageDialog(null, "Patient saving failed");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Patient loading failed");
        }
    }
    
    protected void changepatient(){
        
    }
    protected void deletepatient(){
        
    }
}
