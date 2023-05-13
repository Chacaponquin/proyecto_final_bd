package cu.edu.cujae.structbd;
import cu.edu.cujae.structbd.visual.user.LoginUI;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args)  {
        try {
            initApp();
        }
        catch(Exception exception){
            exception.printStackTrace();
        }
    }

    private static void initApp() throws SQLException, ClassNotFoundException {
          LoginUI login = new LoginUI();
          login.setLocationRelativeTo(null);
          login.setVisible(true);
    }
}