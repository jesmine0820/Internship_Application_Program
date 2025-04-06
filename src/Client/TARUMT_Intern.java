/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Client;

import Control.UserManager;
import Dao.Initializer;

/**
 *
 * @author User
 * 
 */
public class TARUMT_Intern {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        UserManager userManager = new UserManager();
        
        Initializer.initialize();
        userManager.login();
    }
    
}
