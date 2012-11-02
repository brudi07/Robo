package battle;

import enemy.Enemy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import player.Player;
import robot.Ability;
import robot.Robot;
import util.RNG;

/**
 *
 * @author Ben Rudi
 */
public class Battle {

    Ability abilities = new Ability();
    private Boolean myTurn;

    public void Battle(Player player, Enemy enemy) {

        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(player.getStats());
        System.out.println(enemy.getStats());

        // Determine who goes first
        isFirst(player, enemy);

        while (player.getHealth() > 0 && enemy.getHealth() > 0) {
            String input = null;
            // User's turn
            if (myTurn) {
                // List attack's
                System.out.println("Attack list: ");
                for (int i = 0; i < player.getAbilities().size(); i++) {
                    System.out.println(i + 1 + ":" + player.getAbilities().get(i).getName());
                }
                System.out.print("\nEnter value: ");
                // Get input
                try {
                    input = br.readLine();
                } catch (IOException ex) {
                    System.out.println("ReadLine Exception: " + ex);
                }
                // Check that input is a number between 1-4
                while (!isInteger(input) || Integer.parseInt(input) > player.getAbilities().size() || Integer.parseInt(input) < 1) {
                    System.out.print("Please enter a number 1-4: ");
                    try {
                        input = br.readLine();
                    } catch (IOException ex) {
                        System.out.println("ReadLine Exception: " + ex);
                    }
                }

                // Assign value to ability
                int value = Integer.parseInt(input) - 1;
                Ability ability = player.getAbilities().get(value);
                // Do battle stuff
                System.out.println(player.getName() + " used " + ability.getName() + "");
                enemy.setHealth(enemy.getHealth() - damageDone(player, enemy, ability));
                System.out.println(enemy.getName() + " is at " + enemy.getHealth() + "\n");
                myTurn = false;
            } else {
                // Enemy turn
                int value = util.RNG.rand(0, enemy.getAbilities().size()-1);
                Ability ability = enemy.getAbilities().get(value);
                System.out.println(enemy.getName() + " used " + ability.getName() + "");
                player.setHealth(player.getHealth() - damageDone(enemy, player, ability));
                System.out.println(player.getName() + " is at " + player.getHealth() + "\n");
                myTurn = true;
            }
        }

        if (player.getHealth() <= 0) {
            System.out.println(player.getName() + " faints...\n");
        } else {
            System.out.println(player.getName() + " wins!\n");
            //player.levelUp();
        }
    }

    public Boolean isFirst(Player player, Enemy enemy) {
        if (player.getModSpeed() > enemy.getModSpeed()) {
            myTurn = true;
            System.out.println("Player goes first!\n");
        } else if (enemy.getModSpeed() > player.getModSpeed()) {
            myTurn = false;
            System.out.println("Enemy goes first!\n");
        } else {
            myTurn = true;
            System.out.println("Player goes first!\n");
        }
        return myTurn;
    }

    public int damageDone(Robot source, Robot target, Ability ability) {
        int damage = ability.getBasePower();

        boolean crit = RNG.proc(ability.getCritChance());

        if (crit) {
            System.out.println("CRIT!");
            damage += source.getModAttack(ability.getDamageType());
        }
        damage += source.getModAttack(ability.getDamageType());
        damage -= target.getModDefense(ability.getDamageType());

        return damage;
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
