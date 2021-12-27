/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbHelp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author asus
 */
public class ManageMejaDb {
    
    public DefaultTableModel getData(){
        DefaultTableModel Dtm = new DefaultTableModel();
        Dtm.addColumn("TableID");
        Dtm.addColumn("MejName");
        Dtm.addColumn("Quantity");
        Dtm.addColumn("Price");
        
        String sql = "SELECT * FROM managemeja";
        
        try {
            Connection conn = KoneksiDatabase.getKoneksi();
            
            Statement St = conn.prepareStatement(sql);
            ResultSet Rs = St.executeQuery(sql);
            
            while(Rs.next()){
                String TableID  = Rs.getString(1);
                String MejName  = Rs.getString(2);
                String Quantity = Rs.getString(3);
                String Price    = Rs.getString(4);
            
                Dtm.addRow(new String[]{TableID, MejName, Quantity, Price});
         
            }
            
            return Dtm;
        }catch(SQLException e){
            System.out.println("Fetching Data Failed");
            Logger.getLogger(ManageMejaDb.class.getName()).log(Level.SEVERE,null,e);
        }
        return null;
    }
    
    public Boolean add(int TableID, String MejName, int Quantity, String Price){
        String sql = "INSERT INTO managemeja(TableID, MejName, Quantity, Price) VALUES ('"+TableID+"','"+MejName+"', '"+Quantity+"','"+Price+"')";
        
        try{
            
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St = conn.prepareStatement(sql);
            St.execute(sql);
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(ManageMejaDb.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Add Product Failed");
            return false;
        }
        
    }
    
    public Boolean Update(String TableID, String MejName, int Quantity, String Price){
        String sql = "UPDATE managemeja SET `MejName` ='"+MejName+"' , `Quantity` = '"+Quantity+"', `Price` = '"+Price+"' WHERE TableID = '"+TableID+"'";
        
        try{
            
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St = conn.prepareStatement(sql);
            St.execute(sql);
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(ManageMejaDb.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Edit Product Failed");
            return false;
        }
    }
    
    public Boolean Delete(String TableID){
        
        String sql = "DELETE FROM managemeja WHERE TableID = '"+TableID+"'";
        
        try{
            Connection conn = KoneksiDatabase.getKoneksi();
            Statement St = conn.prepareStatement(sql);
            St.execute(sql);
            
            return true;
        }catch(SQLException e){
            Logger.getLogger(ManageMejaDb.class.getName()).log(Level.SEVERE,null,e);
            System.out.println("Delete Product Failed");
            return false;
        }
    }
}
