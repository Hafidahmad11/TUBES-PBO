/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Driver;
import Controller.*;
import Model.*;
import View.*;
/**
 *
 * @author asus
 */
public class MainDriver {
    public static void main(String[] args){
        AdminModel Um = new AdminModel("","");
        LoginView Lv = new LoginView();
        LoginController Lc = new LoginController(Um, Lv);
        Lc.initController();
    }
}
