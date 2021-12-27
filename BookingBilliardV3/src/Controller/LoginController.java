/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import Driver.KoneksiDatabase;
import View.LoginView;
import View.MDLadmin;

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
    private final UserModel model;
    private final LoginView view;
    
    public LoginController(UserModel Um, LoginView Lv){
        model = Um;
        view = Lv;
        initView();
    }
    
    public void initView(){
        view.setVisible(true);
        view.getUsernameText().setText(model.getUsername());
        view.getPasswordText().setText(model.getPassword());
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
    
    public void login(){
        model.setUsername(view.getUsernameText().getText());
        model.setPassword(view.getPasswordText().getText());
        
        String Username = model.getUsername();
        String Password = model.getPassword();
        
        try{
            Connection conn;
            conn = KoneksiDatabase.getKoneksi();
            
            if(model.isAdmin(Username, Password)){
                PreparedStatement St;
                St = (PreparedStatement) conn.prepareStatement("Select Username, Password from admin where Username=? and Password=?");
                
                St.setString(1, Username);
                St.setString(2, Password);
                ResultSet Rs = St.executeQuery();
                
                if(Rs.next()){
                    MDLadmin Ma = new MDLadmin();
                    AdminController Ac = new AdminController(Ma);
                    Ac.initController();
                    view.dispose();
                }else{
                    view.loginError(Username, Password);
                }
            }
            
        }catch(SQLException e){
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,e);
        }
    }
}
