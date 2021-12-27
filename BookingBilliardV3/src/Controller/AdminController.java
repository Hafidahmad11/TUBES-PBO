/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.UserModel;
import View.MDLadmin;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class AdminController {
    public final MDLadmin view;
    
    public AdminController(MDLadmin v){
        view = v;
        initView();
    }

    
    public void initView(){
        view.setVisible(true);
    }
    
    public void initController(){
        view.addButtonListener(new ButtonListener());
    }
    
    public class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand());
            switch(e.getActionCommand()){
                case "Logout":
                    logout();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void logout(){
        int a = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar?");
        
        if (a == JOptionPane.YES_OPTION){
            view.dispose();
            UserModel Um = new UserModel("", "");
            LoginView Lv = new LoginView();
            LoginController Lc = new LoginController(Um, Lv);
            Lc.initController();
        }
    }
}
