/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jurado_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Ken
 */
public class DBHelper1 {
    Connection con = null;
    Statement stmt = null;
    
    public void connectDB() throws Exception{
        con = DriverManager.getConnection("jdbc:derby://localhost:1527/dbDogeDogFoodStoreInformationSystem", "doge", "doge");
        System.out.println("Connected to the database");
    }
    
    public boolean insertRecord(int cust_id, int dogfood_id, String brand, String flavor){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO tbldogfood values ("+dogfood_id+",'"+brand+"', '"+flavor+"', "+cust_id+")";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;

        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean insertRegister(int cust_id, String firstname, String lastname, String mobile_num, String email, String password){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO tblcustomer values ("+cust_id+",'"+firstname+"', '"+lastname+"', '"+mobile_num+"', '"+email+"', '"+password+"')";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;

        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean insertRecordType(int type_id, int dogfood_id, String typeofpackage, int kilogram, int price){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO tbltype values ("+type_id+", "+dogfood_id+",'"+typeofpackage+"', "+kilogram+", "+price+")";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;

        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean DogeDelivery(int delivery_id, int cust_id, int dogfood_id, String deliveryboolean){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO tbldelivery values ("+delivery_id+", "+cust_id+", '"+deliveryboolean+"', "+dogfood_id+")";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;

        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    
    public boolean dogePayment(int cust_id, int payment_id, int payment){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "INSERT INTO tblpayment values ("+payment_id+", "+payment+", "+cust_id+")";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;

        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public ResultSet dogeDisplayRecords(){
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql =  "SELECT firstname, lastname, mobile_num, brand, flavor, typeofpackage, kilogram, price, deliveryboolean FROM tblcustomer, tbldogfood, tbltype, tbldelivery";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet displayCustomerID(int cust_id){
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql =  "SELECT * FROM tblcustomer where cust_id = "+cust_id+"";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet displayDogfoodID(int dogfood_id){
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql =  "SELECT * FROM tbldogfood where dogfood_id = "+dogfood_id+"";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet displayTypeID(int type_id){
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql =  "SELECT * FROM tbltype where type_id = "+type_id+"";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet displayDeliveryID(int delivery_id){
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql =  "SELECT * FROM tbldelivery where delivery_id = "+delivery_id+"";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet displayPaymentID(int payment_id){
        ResultSet rs = null;
        try {
            stmt = con.createStatement();
            String sql =  "SELECT * FROM tblpayment where payment_id = "+payment_id+"";
            rs = stmt.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public boolean updateRecordCustomer(int cust_id, String firstname, String lastname, String mobile_num){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "Update tblcustomer set firstname = '"+firstname+"', lastname = '"+lastname+"', mobile_num = '"+mobile_num+"' where cust_id = "+cust_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean updateRecordDogfood(int dogfood_id, String brand, String flavor){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "Update tbldogfood set brand = '"+brand+"', flavor = '"+flavor+"' where dogfood_id = "+dogfood_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean updateRecordType(int type_id, String typeofpackage, int kilogram, int price){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "Update tbltype set typeofpackage = '"+typeofpackage+"', kilogram = "+kilogram+", price = "+price+" where type_id = "+type_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean updateRecordDelivery(int delivery_id, String deliveryboolean){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "Update tbldelivery set deliveryboolean = '"+deliveryboolean+"' where delivery_id = "+delivery_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean updateRecordPayment(int payment_id, int payment){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "Update tblpayment set payment = "+payment+" where payment_id = "+payment_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean deleteRecordCustomer(int cust_id){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "DELETE FROM tblcustomer where cust_id = "+cust_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean deleteRecordDogfood(int dogfood_id){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "DELETE FROM tbldogfood where dogfood_id = "+dogfood_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean deleteRecordType(int type_id){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "DELETE FROM tbltype where type_id = "+type_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public boolean deleteRecordDelivery(int delivery_id){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "DELETE FROM tbldelivery where delivery_id = "+delivery_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }

    public boolean deleteRecordPayment(int payment_id){
        boolean flag = false;
        try{
            stmt = con.createStatement();
            String sql = "DELETE FROM tblpayment where payment_id = "+payment_id+"";
            if (stmt.executeUpdate(sql) == 1)
                flag = true;
        } catch (SQLException ex){
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    
    public void disconnectDB(){
            try {
                if (con != null)
                con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper1.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
}
