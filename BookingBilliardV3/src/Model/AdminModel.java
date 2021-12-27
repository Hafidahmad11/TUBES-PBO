/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controller.User;
/**
 *
 * @author asus
 */
public class AdminModel extends User {
   
    
    public AdminModel(String Us, String Ps){
        this.username = Us;
        this.password = Ps;
    }
    
    public boolean isAdmin(String Us, String Ps){
        return "admin".equals(Us) && "admin".equals(Ps);
    }
    
    
    
}
