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
        
       return age;
    }
    
    protected void changepatient(){
    }
}
