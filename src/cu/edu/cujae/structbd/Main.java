package cu.edu.cujae.structbd;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import cu.edu.cujae.structbd.visual.user.LoginUI;

import java.sql.SQLException;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args)  {

        try
        {
            UIManager.setLookAndFeel(new FlatGitHubIJTheme());
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