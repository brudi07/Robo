package robot;

import java.util.ArrayList;
import robot.Ability.DamageType;

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
    private ArrayList<Ability> abilities = new ArrayList();
    private Boolean headEquipped;
    private Part head;
    private Boolean chipEquipped;
    private Part chip;
    private Boolean legsEquipped;
    private Part legs;
    private Boolean rArmEquipped;
    private Part rArm;
    private Boolean lArmEquipped;
    private Part lArm;
    private Boolean chasisEquipped;
    private Part chasis;

    public Robot() {
        name = "Bot";
        setLevel(1);
        setMaxHealth(10);
        setHealth(10);
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
        if (health > maxHealth){
            this.health = maxHealth;
        }else if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    // Max Health
    public int getBaseMaxHealth() {
        return maxHealth;
    }

    public int getModMaxHealth() {
        return getBaseMaxHealth();//TODO check equipment and active abilities
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    // Shield
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        if (shield < 0) {
            this.shield = 0;
        } else {
            this.shield = shield;
        }
    }

    // Max Shield
    public int getBaseMaxShield() {
        return maxShield;
    }

    public int getModMaxShield() {
        return getBaseMaxShield();//TODO check equipment and active abilities
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
    }

    // Phys Attack
    public int getBasePhysAttack() {
        return physAttack;
    }

    public int getModPhysAttack() {
        return getBasePhysAttack();//TODO check equipment and active abilities
    }

    public void setPhysAttack(int physAttack) {
        this.physAttack = physAttack;
    }

    // Phys Defense
    public int getBasePhysDefense() {
        return physDefense;
    }

    public int getModPhysDefense() {
        return getBasePhysDefense();//TODO check equipment and active abilities
    }

    public void setPhysDefense(int physDefense) {
        this.physDefense = physDefense;
    }

    // Spec Attack
    public int getBaseSpecAttack() {
        return specAttack;
    }

    public int getModSpecAttack() {
        return getBaseSpecAttack();//TODO check equipment and active abilities
    }

    public void setSpecAttack(int specAttack) {
        this.specAttack = specAttack;
    }

    // Spec Defense
    public int getBaseSpecDefense() {
        return specDefense;
    }

    public int getModSpecDefense() {
        return getBaseSpecDefense();//TODO check equipment and active abilities
    }

    public void setSpecDefense(int specDefense) {
        this.specDefense = specDefense;
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
        this.speed = speed;
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

    public void equipHead(Part head) {
        if (head.isHead()) {
            this.head = head;
            headEquipped = true;
        } else {
            headEquipped = false;
            System.out.println("Cannot equip: Not a head part.");
        }
    }

    public void equipChip(Part chip) {
        if (chip.isChip()) {
            this.chip = chip;
            chipEquipped = true;
        } else {
            chipEquipped = false;
            System.out.println("Cannot equip: Not a chip part.");
        }
    }

    public void equipLegs(Part legs) {
        if (legs.isLegs()) {
            this.legs = legs;
            legsEquipped = true;
        } else {
            legsEquipped = false;
            System.out.println("Cannot equip: Not a legs part.");
        }
    }

    public void equipRArm(Part rArm) {
        if (rArm.isRightArm()) {
            this.rArm = rArm;
            rArmEquipped = true;
        } else {
            rArmEquipped = false;
            System.out.println("Cannot equip: Not a right arm part.");
        }
    }

    public void equipLArm(Part lArm) {
        if (lArm.isLeftArm()) {
            this.lArm = lArm;
            lArmEquipped = true;
        } else {
            lArmEquipped = false;
            System.out.println("Cannot equip: Not a left arm part.");
        }
    }

    public void equipChasis(Part chasis) {
        if (chasis.isChasis()) {
            this.chasis = chasis;
            chasisEquipped = true;
        } else {
            chasisEquipped = false;
            System.out.println("Cannot equip: Not a chasis part.");
        }
    }

    public void checkParts() {
        if (headEquipped) {
            setMaxHealth(maxHealth + head.getModMaxHealth());
            setMaxShield(maxShield + head.getModMaxShield());
            setPhysAttack(physAttack + head.getModPhysAttack());
            setPhysDefense(physDefense + head.getModPhysDefense());
            setSpecAttack(specAttack + head.getModSpecAttack());
            setSpecDefense(specDefense + head.getModSpecDefense());
            setSpeed(speed + head.getModSpeed());
            if (!abilities.contains(head.getAbility())) {
                addAbility(head.getAbility());
            }
        }
        if (chipEquipped) {
            setMaxHealth(maxHealth + chip.getModMaxHealth());
            setMaxShield(maxShield + chip.getModMaxShield());
            setPhysAttack(physAttack + chip.getModPhysAttack());
            setPhysDefense(physDefense + chip.getModPhysDefense());
            setSpecAttack(specAttack + chip.getModSpecAttack());
            setSpecDefense(specDefense + chip.getModSpecDefense());
            setSpeed(speed + chip.getModSpeed());
            if (!abilities.contains(chip.getAbility())) {
                addAbility(chip.getAbility());
            }
        }
        if (legsEquipped) {
            setMaxHealth(maxHealth + legs.getModMaxHealth());
            setMaxShield(maxShield + legs.getModMaxShield());
            setPhysAttack(physAttack + legs.getModPhysAttack());
            setPhysDefense(physDefense + legs.getModPhysDefense());
            setSpecAttack(specAttack + legs.getModSpecAttack());
            setSpecDefense(specDefense + legs.getModSpecDefense());
            setSpeed(speed + legs.getModSpeed());
            if (!abilities.contains(legs.getAbility())) {
                addAbility(legs.getAbility());
            }
        }
        if (rArmEquipped) {
            setMaxHealth(maxHealth + rArm.getModMaxHealth());
            setMaxShield(maxShield + rArm.getModMaxShield());
            setPhysAttack(physAttack + rArm.getModPhysAttack());
            setPhysDefense(physDefense + rArm.getModPhysDefense());
            setSpecAttack(specAttack + rArm.getModSpecAttack());
            setSpecDefense(specDefense + rArm.getModSpecDefense());
            setSpeed(speed + rArm.getModSpeed());
            if (!abilities.contains(rArm.getAbility())) {
                addAbility(rArm.getAbility());
            }
        }
        if (lArmEquipped) {
            setMaxHealth(maxHealth + lArm.getModMaxHealth());
            setMaxShield(maxShield + lArm.getModMaxShield());
            setPhysAttack(physAttack + lArm.getModPhysAttack());
            setPhysDefense(physDefense + lArm.getModPhysDefense());
            setSpecAttack(specAttack + lArm.getModSpecAttack());
            setSpecDefense(specDefense + lArm.getModSpecDefense());
            setSpeed(speed + lArm.getModSpeed());
            if (!abilities.contains(lArm.getAbility())) {
                addAbility(lArm.getAbility());
            }
        }
        if (chasisEquipped) {
            setMaxHealth(maxHealth + chasis.getModMaxHealth());
            setMaxShield(maxShield + chasis.getModMaxShield());
            setPhysAttack(physAttack + chasis.getModPhysAttack());
            setPhysDefense(physDefense + chasis.getModPhysDefense());
            setSpecAttack(specAttack + chasis.getModSpecAttack());
            setSpecDefense(specDefense + chasis.getModSpecDefense());
            setSpeed(speed + chasis.getModSpeed());
            if (!abilities.contains(chasis.getAbility())) {
                addAbility(chasis.getAbility());
            }
        }
    }

    public void heal() {
        health = maxHealth;
        shield = maxShield;
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
