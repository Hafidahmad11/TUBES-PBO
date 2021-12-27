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
public class BillPointModel {
    private int ID;
    private String MejName;
    private String Price;
    private int Quantity;
    
    public BillPointModel(int ID, String MejName, String Price, int Quantity){
        this.ID = ID;
        this.MejName = MejName;
        this.Price = Price;
        this.Quantity = Quantity;
    }
    
    public BillPointModel(){};

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setMejName(String MejName) {
        this.MejName = MejName;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int getID() {
        return ID;
    }

    public String getMejName() {
        return MejName;
    }

    public String getPrice() {
        return Price;
    }

    public int getQuantity() {
        return Quantity;
    }
    
    
}
