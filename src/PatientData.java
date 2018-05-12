/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static com.sun.org.apache.xpath.internal.XPath.SELECT;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.text.html.HTML.Tag.SELECT;
/**
 *
 * @author Jens
 */
public class PatientData {

    protected static void addpatient(String name, String surname, String sex, String birthdate) {
       Connection conn = null;
       PreparedStatement pst = null;
       try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc.mysql///blahblah");
            pst = conn.prepareStatement("insert into Patients values (?,?,?,?)");
            pst.setString(1, name);
            pst.setString(2, surname);
            pst.setString(3, sex);
            pst.setString(4, birthdate);
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
