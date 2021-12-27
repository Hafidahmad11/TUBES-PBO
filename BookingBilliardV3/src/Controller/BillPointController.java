/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.BillPointModel;
import Model.AdminModel;
import View.BillPointView;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class BillPointController {
    private final BillPointView view;
    private final BillPointModel model;
    
    public BillPointController(BillPointModel m, BillPointView v){
        model = m;
        view = v;
        initView();
    }
    
    public void initView(){
        view.setVisible(true);
    }
    
    public void initController(){
        view.BillPointButtonListener(new ButtonListener());
    }
    
    public class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand());
            switch(e.getActionCommand()){
                case "Clear":
                    ClearFields();
                    break;
                case "Logout":
                    logout();
                    break;
                default:
                    break;
            }
        }
    }
    
    public void ClearFields(){
        view.getLabelID().setText("");
        view.getLabelMejName().setText("");
        view.getLabelQuantity().setText("");
        view.getLabelPrice().setText("");
    }
    
    public void logout(){
        int a  = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Keluar?");
        
        if(a == JOptionPane.YES_OPTION){
            view.dispose();
            AdminModel Um = new AdminModel("","");
            LoginView Lv = new LoginView();
            LoginController Lc = new LoginController(Um, Lv);
            Lc.initController();
        }
    }
    
}
