package robot;

import java.util.ArrayList;
import robot.Ability.DamageType;
import util.RNG.Dice;

/**
 *
 * @author Ben Rudi
 */
public class Robot {

    // Variables
    //private ImageIcon sprite;
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    private int shield;
    private int maxShield;
    //private Dice maxHealthRate = new Dice( 1, 3 );
    private int physAttack;
    //private Dice physAttackRate = new Dice( 1, 3 );
    private int specAttack;
    //private Dice specAttackRate = new Dice( 1, 3 );
    private int physDefense;
    //private Dice physDefenseRate = new Dice( 1, 3 );
    private int specDefense;
    //private Dice specDefenseRate = new Dice( 1, 3 );
    private int speed;
    //private Dice speedRate = new Dice( 1, 3 );
    private ArrayList<Ability> abilities;

    public Robot() {
        name = "Bot";
        setLevel(1);
        setHealth(10);
        setMaxHealth(10);
        setShield(10);
        setMaxShield(10);
        setPhysAttack(1);
        setSpecAttack(1);
        setPhysDefense(1);
        setSpecDefense(1);
        setSpeed(1);
    }

    // Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        System.out.println("old health " + this.health);
        this.health = health;
        System.out.println("new health " + this.health);
    }

    // Max Health
    public int getBaseMaxHealth() {
        return maxHealth;
    }

    public int getModMaxHealth() {
        return getBaseMaxHealth();//TODO check equipment and active abilities
    }

    public void setMaxHealth(int maxHealth) {
        System.out.println("old maxHealth " + this.maxHealth);
        this.maxHealth = maxHealth;
        System.out.println("new maxHealth " + this.maxHealth);
    }
    
    // Shield
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        System.out.println("old shield " + this.shield);
        this.shield = shield;
        System.out.println("new shield " + this.shield);
    }
    
    // Max Shield
    public int getBaseMaxShield() {
        return maxShield;
    }

    public int getModMaxShield() {
        return getBaseMaxShield();//TODO check equipment and active abilities
    }

    public void setMaxShield(int maxShield) {
        System.out.println("old maxShield " + this.maxShield);
        this.maxShield = maxShield;
        System.out.println("new maxShield " + this.maxShield);
    }

    // Phys Attack
    public int getBasePhysAttack() {
        return physAttack;
    }

    public int getModPhysAttack() {
        return getBasePhysAttack();//TODO check equipment and active abilities
    }

    public void setPhysAttack(int physAttack) {
        System.out.println("old physAttack " + this.physAttack);
        this.physAttack = physAttack;
        System.out.println("new physAttack " + this.physAttack);
    }

    // Phys Defense
    public int getBasePhysDefense() {
        return physDefense;
    }

    public int getModPhysDefense() {
        return getBasePhysDefense();//TODO check equipment and active abilities
    }

    public void setPhysDefense(int physDefense) {
        System.out.println("old physDefense " + this.physDefense);
        this.physDefense = physDefense;
        System.out.println("new physDefense " + this.physDefense);
    }

    // Spec Attack
    public int getBaseSpecAttack() {
        return specAttack;
    }

    public int getModSpecAttack() {
        return getBaseSpecAttack();//TODO check equipment and active abilities
    }

    public void setSpecAttack(int specAttack) {
        System.out.println("old specAttack " + this.specAttack);
        this.specAttack = specAttack;
        System.out.println("new specAttack " + this.specAttack);
    }

    // Spec Defense
    public int getBaseSpecDefense() {
        return specDefense;
    }

    public int getModSpecDefense() {
        return getBaseSpecDefense();//TODO check equipment and active abilities
    }

    public void setSpecDefense(int specDefense) {
        System.out.println("old specDefense " + this.specDefense);
        this.specDefense = specDefense;
        System.out.println("new specDefense " + this.specDefense);
    }

    // Mod Attack
    public int getModAttack(DamageType type) {
        if (DamageType.PHYSICAL.equals(type)) {
            return getModPhysAttack();
        }
        if (DamageType.SPECIAL.equals(type)) {
            return getModSpecAttack();
        }
        return 0;
    }

    // Mod Defense
    public int getModDefense(DamageType type) {
        if (DamageType.PHYSICAL.equals(type)) {
            return getModPhysDefense();
        }
        if (DamageType.SPECIAL.equals(type)) {
            return getModSpecDefense();
        }
        return 0;
    }

    // Speed
    public int getBaseSpeed() {
        return speed;
    }

    public int getModSpeed() {
        return getBaseSpeed();//TODO check equipment and active abilities
    }

    public void setSpeed(int speed) {
        System.out.println("old speed " + this.speed);
        this.speed = speed;
        System.out.println("new speed " + this.speed);
    }

    // Abilities
    public ArrayList<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<Ability> abilities) {
        this.abilities = abilities;
    }

    public boolean addAbility(Ability ability) {
        if (abilities != null) {
            return abilities.add(ability);
        }
        return false;
    }

    public boolean removeAbility(Ability ability) {
        if (abilities != null) {
            return abilities.remove(ability);
        }
        return false;
    }

    // Level Up
    public void levelUp() {
        adjustLevel(getLevel() + 1);
    }

    public void adjustLevel(int newLevel) {
        int levelDiff = newLevel - getLevel();
        //int multiplyer = levelDiff > 0 ? 1 : -1;

        for (int i = 0; i < Math.abs(levelDiff); i++) {
            setMaxHealth(getBaseMaxHealth() + 5);
            setMaxShield(getBaseMaxShield() + 5);
            setPhysAttack(getBasePhysAttack() + 1);
            setSpecAttack(getBaseSpecAttack() + 1);
            setPhysDefense(getBasePhysDefense() + 1);
            setSpecDefense(getBaseSpecDefense() + 1);
            setSpeed(getBaseSpeed() + 1);
        }

        /*
         * for( int i = 0; i < Math.abs( levelDiff ); i++ ){ setMaxHealth(
         * getBaseMaxHealth() + multiplyer * maxHealthRate.roll() );
         * setPhysAttack( getBasePhysAttack() + multiplyer *
         * physAttackRate.roll() ); setSpecAttack( getBaseSpecAttack() +
         * multiplyer * specAttackRate.roll() ); setPhysDefense(
         * getBasePhysDefense() + multiplyer * physDefenseRate.roll() );
         * setSpecDefense( getBaseSpecDefense() + multiplyer *
         * specDefenseRate.roll() ); setSpeed( getBaseSpeed() + multiplyer *
         * speedRate.roll() ); }
         *
         */

        setLevel(newLevel);
    }
}
