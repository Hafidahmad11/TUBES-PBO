/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DbHelp.ManageMejaDb;
import Model.ManageMejaModel;
import Model.AdminModel;
import View.LoginView;
import View.ProductAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
/**
 *
 * @author asus
 */
public class ManageMejaController {
    private final ManageMejaModel model;
    private final ProductAdmin view;
    
    public ManageMejaController(ManageMejaModel m, ProductAdmin v){
        model = m;
        view = v;
        initView();
    }
    
    public void initView(){
        view.setVisible(true);
    }
    
    public void initController(){
        view.ManageButtonListener(new ButtonListener());
    }
    
    public class ButtonListener implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
            System.out.println(e.getActionCommand());
            switch(e.getActionCommand()){
                case"Add":
                    addMeja();
                    break;
                case "Edit":
                    UpdateMeja();
                    break;
                case "Delete":
                    DeleteMeja();
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
        view.getLblTableID().setText("");
        view.getLblMejName().setText("");
        view.getLblQuantity().setText("");
        view.getLblPrice().setText("");
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
    
    public void addMeja(){
        model.setTableID(Integer.parseInt(view.getLblTableID().getText()));
        model.setMejName(view.getLblMejName().getText());
        model.setQuantity(Integer.parseInt(view.getLblQuantity().getText()));
        model.setPrice(view.getLblPrice().getText());
        
        int TableID     = model.getTableID();
        String MejName  = model.getMejName();
        int Quantity    = model.getQuantity();
        String Price    = model.getPrice();
        
        if(new ManageMejaDb().add(TableID, MejName, Quantity, Price)){
            JOptionPane.showMessageDialog(null,"Insert Meja Successfull");
            
            ClearFields();
            view.DataTable();
        }else{
            System.out.println("Add data Error");
            JOptionPane.showMessageDialog(null, "Insert Meja Failed");
        }
    }
    
    public void DeleteMeja(){
        String[] options = {"Yes", "No"};
        int answer = JOptionPane.showOptionDialog(null, "Anda Yakin Untuk Menghapus Meja ?", "Delete Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
        
        if ( answer == 0){
            int index       = view.getTableList().getSelectedRow();
            String TableID  = view.getTableList().getValueAt(index, 0).toString();
            
            if(new ManageMejaDb().Delete(TableID)){
                JOptionPane.showMessageDialog(null, "Delete Berhasil");
                
                ClearFields();
                RefreshMeja();
            }else{
                JOptionPane.showMessageDialog(null,"Delete Gagal");
            }
        }
    }
    
    public void UpdateMeja(){
        int index = view.getTableList().getSelectedRow();
        String TableID = view.getTableList().getValueAt(index, 0).toString();
        
        model.setTableID(Integer.parseInt(TableID));
        model.setMejName(view.getLblMejName().getText());
        model.setQuantity(Integer.parseInt(view.getLblQuantity().getText()));
        model.setPrice(view.getLblPrice().getText());
        
        String MejName = model.getMejName();
        int Quantity = model.getQuantity();
        String Price = model.getPrice();
        
        if (new ManageMejaDb().Update(TableID, MejName, Quantity, Price)){
            JOptionPane.showMessageDialog(null, "Successfully Updated");
            
            ClearFields();
            RefreshMeja();
        }else{
            JOptionPane.showMessageDialog(null, "Updated Failed");
        }
    }
    
    public void RefreshMeja(){
        view.DataTable();
    }
    
 
    
}
