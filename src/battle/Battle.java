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

    public void Battle(Player player, Enemy enemy) throws IOException {

        //  open up standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
                input = br.readLine();

                // Check that input is a number between 1-4
                while (!isInteger(input) || Integer.parseInt(input) > player.getAbilities().size() || Integer.parseInt(input) < 1) {
                    System.out.print("Please enter a valid number: ");
                    input = br.readLine();
                }

                // Assign value to ability
                int value = Integer.parseInt(input) - 1;
                Ability ability = player.getAbilities().get(value);
                // Do battle stuff
                combatAction(player, enemy, ability);
                myTurn = false;
            } else {
                // Enemy turn
                int value = util.RNG.rand(0, enemy.getAbilities().size() - 1);
                Ability ability = enemy.getAbilities().get(value);
                combatAction(enemy, player, ability);
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
            System.out.println(player.getName() + " goes first!\n");
        } else if (enemy.getModSpeed() > player.getModSpeed()) {
            myTurn = false;
            System.out.println(enemy.getName() + " goes first!\n");
        } else {
            myTurn = true;
            System.out.println(player.getName() + " goes first!\n");
        }
        return myTurn;
    }

    public void combatAction(Robot source, Robot target, Ability ability) {
        int power = ability.getBasePower();
        boolean crit = RNG.proc(ability.getCritChance());
        boolean hit = RNG.proc(ability.getHitChance());

        System.out.println(source.getName() + " used " + ability.getName() + "");
        if (ability.isTargetEnemy()) {
            if (hit) {
                if (crit) {
                    System.out.println("CRIT!");
                    power += source.getBasePhysAttack();
                }

                if (ability.isPhysical()) {
                    power += source.getBasePhysAttack();
                    power -= target.getBasePhysDefense();
                } else {
                    power += source.getBaseSpecAttack();
                    power -= target.getBaseSpecDefense();
                }

                if (target.getShield() > 0) {
                    target.setShield(target.getShield() - power);
                } else {
                    target.setHealth(target.getHealth() - power);
                }
                System.out.println(target.getName() + " shield is at " + target.getShield());
                System.out.println(target.getName() + " health is at " + target.getHealth() + "\n");
            } else {
                System.out.println("MISS!\n");
                power = 0;
            }
        } else {
            if (hit) {
                if (crit) {
                    power += ability.getBasePower();
                }
                source.setHealth(source.getHealth() + power);
                System.out.println(source.getName() + " health is at " + source.getHealth() + "\n");
            } else {
                System.out.println(ability.getName() + " does nothing...\n");
            }
        }
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
