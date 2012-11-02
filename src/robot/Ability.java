package robot;

/**
 *
 * @author Ben Rudi
 */
public final class Ability {

    private String name;
    private int basePower;
    private int critChance;
    private int hitChance;
    private DamageType damageType;
    private Target target;

    public enum DamageType {

        PHYSICAL,
        SPECIAL
    }

    public enum Target {

        ENEMY,
        SELF
    }

    public Ability() {
    }

    public Ability(String eName, DamageType eDamageType, int eBasePower, int eCritChance, int eHitChance, Target eTarget) {
        setName(eName);
        setDamageType(eDamageType);
        setBasePower(eBasePower);
        setCritChance(eCritChance);
        setHitChance(eHitChance);
        setTarget(eTarget);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public void setDamageType(DamageType damageType) {
        this.damageType = damageType;
    }

    public Target getTarget() {
        return target;
    }

    public void setTarget(Target target) {
        this.target = target;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public int getHitChance() {
        return hitChance;
    }

    public void setHitChance(int hitChance) {
        this.hitChance = hitChance;
    }

    public boolean isPhysical() {
        return DamageType.PHYSICAL.equals(getDamageType());
    }

    public boolean isSpecial() {
        return DamageType.SPECIAL.equals(getDamageType());
    }
    
    public boolean isTargetEnemy() {
        return Target.ENEMY.equals(getTarget());
    }

    public static Ability scratch = new Ability("Scratch", DamageType.PHYSICAL, 1, 20, 100, Target.ENEMY);
    public static Ability punch = new Ability("Punch", DamageType.PHYSICAL, 2, 20, 95, Target.ENEMY);
    public static Ability kick = new Ability("Kick", DamageType.PHYSICAL, 2, 20, 80, Target.ENEMY);
    public static Ability headbutt = new Ability("Headbutt", DamageType.PHYSICAL, 2, 80, 75, Target.ENEMY);
    public static Ability overload = new Ability("Overload", DamageType.PHYSICAL, 5, 5, 25, Target.ENEMY);
    public static Ability heal = new Ability("Heal", DamageType.PHYSICAL, 1, 0, 100, Target.SELF);
}
