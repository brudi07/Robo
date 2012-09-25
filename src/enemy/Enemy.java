package enemy;

import robot.Robot;

/**
 *
 * @author Ben Rudi
 */
public final class Enemy extends Robot{

    // Variables for monster
    private int xpGiven;
    private int goldGiven;

    public Enemy() {
        xpGiven = 1;
        goldGiven = 1;
    }

    public Enemy(String eName, int eHealth, int ePhysAttack, int eSpecAttack,
            int ePhysDefense, int eSpecDefense, int eSpeed, int eExperience, int eGold) {

        setName(eName);
        setHealth(eHealth);
        setPhysAttack(ePhysAttack);
        setSpecAttack(eSpecAttack);
        setPhysDefense(ePhysDefense);
        setSpecDefense(eSpecDefense);
        setSpeed(eSpeed);
        setXpGiven(eExperience);
        setGoldGiven(eGold);
    }

    public int getGoldGiven() {
        return goldGiven;
    }

    public void setGoldGiven(int goldGiven) {
        this.goldGiven = goldGiven;
    }

    public int getXpGiven() {
        return xpGiven;
    }

    public void setXpGiven(int xpGiven) {
        this.xpGiven = xpGiven;
    }

    public String getStats() {
        return ("Name: " + getName() + "\n"
                + "Health: " + getHealth() + "\n"
                + "Physical Attack: " + getBasePhysAttack() + "\n"
                + "Special Attack: " + getBaseSpecAttack() + "\n"
                + "Physical Defense: " + getBasePhysDefense() + "\n"
                + "Special Defense: " + getBaseSpecDefense() + "\n"
                + "Speed: " + getBaseSpeed() + "\n\n");
    }
}
