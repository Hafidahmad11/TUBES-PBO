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
public class UserModel {
    private String Username;
    private String Password;
    
    public UserModel(String Us, String Ps){
        this.Username = Us;
        this.Password = Ps;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public void setUsername(String username){
        this.Username = Username;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public void setPassword(String password){
        this.Password = Password;
    }
    
    public boolean isAdmin(String Us, String Ps){
        return "admin".equals(Us) && "admin".equals(Ps);
    }
}
