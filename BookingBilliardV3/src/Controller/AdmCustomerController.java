/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbHelp.CustomerDb;
import Model.AdmCustomerModel;
import Model.AdminModel;
import View.AdmCustomerView;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class AdmCustomerController {
    private final AdmCustomerModel model;
    private final AdmCustomerView view;
    
    public AdmCustomerController(AdmCustomerModel m, AdmCustomerView v){
        model = m;
        view = v;
        initView();
    }
    
    public void initView(){
        view.setVisible(true);
    }
    
    public void initController(){
        view.ManageCsButtonListener(new ButtonListener());
    }
    
    public class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand());
            switch(e.getActionCommand()){
                case "Add":
                    addCs();
                    break;
                case "Edit":
                    UpdateCs();
                    break;
                case "Delete":
                    DeleteCs();
                    break;
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
        view.getLblCustomerID().setText("");
        view.getLblCustomerName().setText("");
        view.getLblPasswordCs().setText("");
    }
    
    public void logout(){
        int a = JOptionPane.showConfirmDialog(null, "Anda yakin ingin keluar?");
        
        if (a == JOptionPane.YES_OPTION){
            view.dispose();
            AdminModel Um = new AdminModel("", "");
            LoginView Lv = new LoginView();
            LoginController Lc = new LoginController(Um, Lv);
            Lc.initController();
        }
    }
    
    public void addCs(){
        model.setCustomerID(Integer.parseInt(view.getLblCustomerID().getText()));
        model.setCustomerName(view.getLblCustomerName().getText());
        model.setPasswordCs(view.getLblPasswordCs().getText());
        
        int CustomerID     = model.getCustomerID();
        String Name  = model.getCustomerName();
        String Password    = model.getPasswordCs();
        
        if(new CustomerDb().add(CustomerID, Name, Password)){
            JOptionPane.showMessageDialog(null,"Insert Customer Successfull");
            
            ClearFields();
            view.DataCs();
        }else{
            System.out.println("Add data Error");
            JOptionPane.showMessageDialog(null, "Insert Customer Failed");
        }
    }
    
    public void DeleteCs(){
        String[] options = {"Yes", "No"};
        int answer = JOptionPane.showOptionDialog(null, "Anda Yakin Untuk Menghapus Customer ?", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        
        if ( answer == 0){
            int index       = view.getTableCustomer().getSelectedRow();
            String CustomerID  = view.getTableCustomer().getValueAt(index, 0).toString();
            
            if(new CustomerDb().Delete(CustomerID)){
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
                
                ClearFields();
                RefreshCs();
            }else{
                JOptionPane.showMessageDialog(null,"Delete Gagal");
            }
        }
    }
    
    public void UpdateCs(){
        int index = view.getTableCustomer().getSelectedRow();
        String CustomerID = view.getTableCustomer().getValueAt(index, 0).toString();
        
        model.setCustomerID(Integer.parseInt(CustomerID));
        model.setCustomerName(view.getLblCustomerName().getText());
        model.setPasswordCs(view.getLblPasswordCs().getText());
        
        String Name = model.getCustomerName();
        String Password = model.getPasswordCs();
        
        if (new CustomerDb().Update(CustomerID, Name, Password)){
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            
            ClearFields();
            RefreshCs();
        }else{
            JOptionPane.showMessageDialog(null, "Updated Failed");
        }
    }
    
    public void RefreshCs(){
        view.DataCs();
    }
}
