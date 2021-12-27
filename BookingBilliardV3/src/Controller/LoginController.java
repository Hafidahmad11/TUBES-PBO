/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.AdminModel;
import DbHelp.KoneksiDatabase;
import Model.BillPointModel;
import Model.ManageMejaModel;
import View.LoginView;
import View.ProductAdmin;
import View.BillPointView;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author asus
 */
public final class LoginController {
    private final AdminModel model;
    private final LoginView view;
    
    public LoginController(AdminModel Um, LoginView Lv){
        model = Um;
        view = Lv;
        initView();
    }
    
    public void initView(){
        view.setVisible(true);
        view.getTblUsername().setText(model.getUsername());
        view.getTblPassword().setText(model.getPassword());
    }
    
    public void initController(){
        view.addButtonListener(new ButtonListener());
    }
    
    public class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand());
            switch (e.getActionCommand()){
                case "Login":
                    login();
                    break;
                case "Clear":
                    view.clearFields();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void MenuMeja(){
        view.dispose();
        ProductAdmin Pa = new ProductAdmin();
        ManageMejaModel Mm = new ManageMejaModel();
        ManageMejaController Mc = new ManageMejaController(Mm, Pa);
        Mc.initController();
        Pa.setVisible(true);
    }
    
    public void login(){
        model.setUsername(view.getTblUsername().getText());
        model.setPassword(view.getTblPassword().getText());
        
        String username = model.getUsername();
        String password = model.getPassword();
        
        try{
            Connection conn;
            conn = KoneksiDatabase.getKoneksi();
            
            if(model.isAdmin(username, password)){
                PreparedStatement St;
                St = (PreparedStatement) conn.prepareStatement("Select username, password from admin where username=? and password=?");
                
                St.setString(1, username);
                St.setString(2, password);
                ResultSet Rs = St.executeQuery();
                
                if(Rs.next()){
                    MenuMeja();
                }else{
                   view.loginError(username, password);
                }       
            }else{
                PreparedStatement st;
                st = (PreparedStatement) conn.prepareStatement("Select username, password from managecustomer where username=? and password=?");

                st.setString(1, username);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
               
                if (rs.next()) {
                    BillPointView home = new BillPointView();
                    BillPointModel m = new BillPointModel(); 
                    BillPointController Bpc = new BillPointController(m,home);
                    home.setVisible(true);
                    Bpc.initController();
                    
                    view.dispose();
                } else {
                   view.loginError(username, password);
               }
           
            }
            
        }catch(SQLException e){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
