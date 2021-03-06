/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project.attempt.pkg1.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pkgfinal.project.attempt.pkg1.controller.AccountController;

/**
 *
 * @author Enrico
 */
public class AccountModel {
    private final String DB_URL = "jdbc:mysql://localhost/";
    private final String USER = "root";
    private final String PASS = "";

    private Connection conn = null;
    private Statement stmt = null;
    
    private String randomCode = null;

    public String getRandomCode() {
        return randomCode;
    }
    
    public void setRandomCode(String randomCode) {
        this.randomCode = randomCode;
    }
    

    public void establishConnection() {
        try {
            conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = (Statement) conn.createStatement();
            stmt.executeQuery("USE final_project_programming_languages_db");
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error establishing connection to database");
        }
    }
    
    public boolean login(String username, String password){
        try {
            // verifies username and password
            ResultSet rs = stmt.executeQuery("SELECT * FROM Accounts WHERE Username='" + username +
                    "' AND Password = '" + password + "'");
            if (rs.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean signUp(String name,String email,String dateOfBirth,String username,String password,int balance){
        try {
            // add the information to the database
            String query = "INSERT INTO Accounts (`Username`,`Password`,`Name`,`Email`,`DOB`,`Balance`, Type) VALUES (" +
                "'"+ username +"', "+"'"+ password +"', "+"'"+ name+"', "+"'"+email +"', "+"'"+ dateOfBirth +"', "+
                balance+", 'Customer')";
            System.out.println(query);
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(AccountController.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    
    
    public String getFullname(String email) {
        ResultSet rs = null;
        try {
            // gets full name based on the email
            System.out.println(email);
            rs = stmt.executeQuery("SELECT Name FROM Accounts WHERE Email = '" + email +"'");
            System.out.println("ha");
            if (!rs.next()) System.out.println("empty rs");;
            System.out.println(rs.getString("Name"));
            return rs.getString("Name");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public String getType(String username){
        // gets the type of the user
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT Type FROM Accounts WHERE Username = '" + username +"'");
            rs.next();
            return rs.getString("Type");
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public boolean changePassword(String newPassword, String email) {
        //changes the password of the given email
        try{
            String query = "UPDATE Accounts SET Password='"+newPassword+"' WHERE Email ='"+ email +"'";
            if (!(stmt.executeUpdate(query) > 0)) return false;
            return true;
        } catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
}
   
