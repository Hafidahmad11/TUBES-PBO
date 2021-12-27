/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author asus
 */
public class AdmCustomerModel {
    private int CustomerID;
    private String Username;
    private String Password;
    
    public AdmCustomerModel(int CustomerID, String Username, String Password){
        this.CustomerID = CustomerID;
        this.Username = Username;
        this.Password = Password;
    }
    
    public AdmCustomerModel(){};

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerName(String Username) {
        this.Username = Username;
    }

    public void setPasswordCs(String Password) {
        this.Password = Password;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public String getCustomerName() {
        return Username;
    }

    public String getPasswordCs() {
        return Password;
    }
    
    
}
