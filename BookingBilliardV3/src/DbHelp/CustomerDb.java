/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbHelp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author asus
 */
public class CustomerDb {
    public DefaultTableModel getData(){
        DefaultTableModel Dtm = new DefaultTableModel();
        Dtm.addColumn("CustomerID");
        Dtm.addColumn("Username");
        Dtm.addColumn("Password");
    
        String sql = "SELECT * FROM managecustomer";
    
        try{
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St    = conn.prepareStatement(sql);
            ResultSet Rs    = St.executeQuery(sql);
    
            while(Rs.next()){
                String CustomerID = Rs.getString(1);
                String Username = Rs.getString(2);
                String Password = Rs.getString(3);
            
                Dtm.addRow(new String[]{CustomerID, Username, Password});
            }
        
            return Dtm;
        
        }catch(SQLException e){
            System.out.println("Fetching Data Failed");
            Logger.getLogger(CustomerDb.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public Boolean add(int CustomerID, String Username, String Password){
        String sql = "INSERT INTO managecustomer(CustomerID, Username, Password) VALUES ('"+CustomerID+"','"+Username+"', '"+Password+"')";
        
        try{
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St = conn.prepareStatement(sql);
            St.execute(sql);
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(CustomerDb.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Add Customer Failed");
            return false;
        }
    }
    
    public Boolean Update(String CustomerID, String Username, String Password){
        String sql = "UPDATE managecustomer SET `Username` = '"+Username+"', `Password` = '"+Password+"' WHERE CustomerID = '"+CustomerID+"'";
        
        
        try{
            
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St = conn.prepareStatement(sql);
            St.execute(sql);
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(CustomerDb.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Edit Customer Failed");
            return false;
        }
    }
    
    public Boolean Delete(String CustomerID){
        String sql = "DELETE FROM managecustomer WHERE CustomerID = '"+CustomerID+"'";
        
        try{
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St    = conn.prepareStatement(sql);
            St.execute(sql);
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(CustomerDb.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Delete Customer Failed");
            return false;
        }
    }
    
}
