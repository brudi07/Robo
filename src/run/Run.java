package run;

import battle.Battle;
import enemy.Enemy;
import player.Player;
import robot.Ability;

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
                
                Player player = new Player();
                Enemy enemy = new Enemy();
                Battle battle = new Battle();
                
                player.setHealth(15);
                player.setMaxHealth(15);
                enemy.setName("Enemy");
                
                battle.Battle( player, enemy );
                
            }
        });
    }
}
