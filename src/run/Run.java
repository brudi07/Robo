package run;

import battle.Battle;
import enemy.Enemy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import player.Player;
import robot.Part;

/**
 *
 * @author Ben Rudi
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {

        System.out.println("Welcome to ROBO.");
        System.out.println("1:Play");
        System.out.println("2:Exit");
        Boolean play = false;
        String input;
        // Get input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        input = br.readLine();

        if (input.equals("1")) {
            play = true;
        }
        System.out.print("\n");

        while (play) {

            Player player = new Player();
            Enemy enemy = new Enemy();
            Battle battle = new Battle();

            player.setName("Player");
            player.setHealth(15);
            player.setMaxHealth(15);
            player.equipHead(Part.headPart);
            player.equipChip(Part.chipPart);
            player.equipLegs(Part.legsPart);
            player.equipRArm(Part.rArmSpecPart);
            player.equipLArm(Part.lArmSpecPart);
            player.equipChasis(Part.chasisPart);
            player.checkParts();
            player.heal();
            enemy.setName("Enemy");
            enemy.equipHead(Part.headPart);
            enemy.equipChip(Part.chipPart);
            enemy.equipLegs(Part.legsPart);
            enemy.equipRArm(Part.rArmPart);
            enemy.equipLArm(Part.lArmPart);
            enemy.equipChasis(Part.chasisPart);
            enemy.checkParts();
            enemy.heal();
            
            System.out.println(player.getStats());
            System.out.println(enemy.getStats());

            battle.Battle(player, enemy);

            System.out.println("1:Play again");
            System.out.println("2:Exit");

            input = br.readLine();

            if (input.equals("1")) {
                play = true;
            } else {
                play = false;
            }
            System.out.print("\n");
        }

        System.out.println("Thanks for playing!");
    }
}
