package cu.edu.cujae.structbd;
import com.formdev.flatlaf.intellijthemes.FlatLightFlatIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneLightIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatLightOwlIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import cu.edu.cujae.structbd.visual.user.LoginUI;

import java.sql.SQLException;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args)  {
        try
        {
            UIManager.setLookAndFeel(new FlatGitHubContrastIJTheme());
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