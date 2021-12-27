/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
public class KoneksiDatabase {
    private static Connection koneksi;
    
    public static Connection getKoneksi() throws SQLException{
        if (koneksi == null){
            try{
                String URL      = "jdbc:mysql://localhost:3306/bookingbilldb";
                String User     = "root";
                String Password = "";
                
                koneksi = DriverManager.getConnection(URL,User,Password);
                System.out.println("Koneksi Berhasil...");
            }catch(SQLException ex){
                Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE,null,ex);
                System.out.println("Koneksi Gagal");
            }
        }
        return koneksi;
    }
}
