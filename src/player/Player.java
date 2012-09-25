package player;

import robot.Robot;

/**
 * @author Ben Rudi
 */
public class Player extends Robot {

    private int experience;
    private int gold;

    public Player() {
        experience = 0;
        gold = 0;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getStats() {
        return ("Name: " + getName() + "\n"
                + "Level: " + getLevel() + "\n"
                + "Experience: " + getExperience() + "\n"
                + "Health: " + getHealth() + "/" + getBaseMaxHealth() + "\n"
                + "Physical Attack: " + getBasePhysAttack() + "\n"
                + "Special Attack: " + getBaseSpecAttack() + "\n"
                + "Physical Defense: " + getBasePhysDefense() + "\n"
                + "Special Defense: " + getBaseSpecDefense() + "\n"
                + "Speed: " + getBaseSpeed() + "\n"
                + "Gold: " + getGold() + "\n\n");
    }
}
