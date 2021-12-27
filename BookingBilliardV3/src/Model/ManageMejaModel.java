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
public class ManageMejaModel {
    private int TableID;
    private String MejName;
    private int Quantity;
    private String Price;
    
    public ManageMejaModel(int TableID, String MejName, int Quantity, String Price){
        this.TableID = TableID;
        this.MejName = MejName;
        this.Quantity = Quantity;
        this.Price = Price;
    }
    
    public ManageMejaModel(){};
    
    public int getTableID(){
        return TableID;
    }
    
    public void setTableID(int TableID){
        this.TableID = TableID;
    }
    
    public String getMejName(){
        return MejName;
    }
 
    public void setMejName(String MejName){
        this.MejName = MejName;
    }
    
    public int getQuantity(){
        return Quantity;
    }
    
    public void setQuantity(int Quantity){
        this.Quantity = Quantity;
    }
    
    public String getPrice(){
        return Price;
    }
    
    public void setPrice(String Price){
        this.Price = Price;
    }
}
