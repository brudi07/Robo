package run;

import gui.MainMenu;
import javax.swing.UIManager;

/**
 *
 * @author Ben Rudi
 */
public class Run {
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                } catch (Exception ex) {
                    System.out.println("Exception: " + ex);
                }
                
                MainMenu.MainMenu();
            }
        });
    }
}
