package Client;

import Control.UserManager;
import Dao.Initializer;

/**
 *
 * @author All
 * 
 */
public class TARUMT_Intern {

    public static void main(String[] args) {
        
        UserManager userManager = new UserManager();
        
        Initializer.initialize();
        userManager.login();
    }
    
}
