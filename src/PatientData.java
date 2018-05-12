/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.SELECT;
/**
 *
 * @author Jens
 */
public class PatientData {
    int age;
    
    PatientData(){
    }


    protected void addpatient(String name, String surname, String sex, String birthdate) {
        Connection conn = null;
        PreparedStatement pst = null;
        PreparedStatement r_out = null;
        Statement stat = null;
        ResultSet res = null;
        Date date = new Date();
        String dateString = null;
        
        SimpleDateFormat data = new SimpleDateFormat("dd.MM.yyyy");
        String date_form = data.format(date);
        
        String[] act = date_form.split("\\.");
        String[] birth = birthdate.split("\\.");
        
        int month = (Integer.parseInt(act[1]) - Integer.parseInt(birth[1]));
        if (month > 0){
            int act_int = Integer.parseInt(act[2]);
            int birth_int = Integer.parseInt(birth[2]);
            age = (act_int - birth_int -1);
        }
        else if (month == 0){
             int day = (Integer.parseInt(act[0]) - Integer.parseInt(birth[0]));
             if (day > 0){
                int act_int = Integer.parseInt(act[2]);
                int birth_int = Integer.parseInt(birth[2]);
                age = (act_int - birth_int -1);
             }
             else {
                 age = (Integer.parseInt(act[2]) - Integer.parseInt(birth[2]));
             }
        }
        else if (month < 0){
            age = (Integer.parseInt(act[2]) - Integer.parseInt(birth[2]));
        }
        
       try{
            //Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/Patient", "Menodar","Student311");
            stat = conn.createStatement();
            ResultSet last_ID = stat.executeQuery("SELECT * FROM Patients");
    
            pst = conn.prepareStatement("insert into Patient values (?,?,?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, sex);
            pst.setString(4, birthdate);
            pst.setInt(5, age);
            pst.setInt(6, 8);
            int i = pst.executeUpdate();
            if (i < 0){
                JOptionPane.showMessageDialog(null, "Patient saved");
            }
            else{
                JOptionPane.showMessageDialog(null, "Patient saving failed");
            }
       }
       catch(Exception e){
           JOptionPane.showMessageDialog(null, "Patient saving failed");
       }
    }
}
