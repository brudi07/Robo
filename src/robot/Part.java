package robot;

/**
 *
 * @author Ben Rudi
 */
public final class Part {

    private String partName;
    private int modMaxHealth;
    private int modMaxShield;
    private int modPhysAttack;
    private int modPhysDefense;
    private int modSpecAttack;
    private int modSpecDefense;
    private int modSpeed;
    private Ability ability;
    private PartType partType;

    public enum PartType {
        HEAD,
        BODY,
        LEGS,
        RIGHTARM,
        LEFTARM,
        CHASIS
    }

    public Part() {
    }

    public Part(String ePartName, int eModMaxHealth, int eModMaxShield,
            int eModPhysAttack, int eModPhysDefense,
            int eModSpecAttack, int eModSpecDefense, int eModSpeed,
            Ability eAbility, PartType ePartType) {
        setPartName(ePartName);
        setModMaxHealth(eModMaxHealth);
        setModMaxShield(eModMaxShield);
        setModPhysAttack(eModPhysAttack);
        setModPhysDefense(eModPhysDefense);
        setModSpecAttack(eModSpecAttack);
        setModSpecDefense(eModSpecDefense);
        setModSpeed(eModSpeed);
        setAbility(eAbility);
        setPartType(ePartType);
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public int getModMaxHealth() {
        return modMaxHealth;
    }

    public void setModMaxHealth(int modMaxHealth) {
        this.modMaxHealth = modMaxHealth;
    }

    public int getModMaxShield() {
        return modMaxShield;
    }

    public void setModMaxShield(int modMaxShield) {
        this.modMaxShield = modMaxShield;
    }

    public int getModPhysAttack() {
        return modPhysAttack;
    }

    public void setModPhysAttack(int modPhysAttack) {
        this.modPhysAttack = modPhysAttack;
    }

    public int getModPhysDefense() {
        return modPhysDefense;
    }

    public void setModPhysDefense(int modPhysDefense) {
        this.modPhysDefense = modPhysDefense;
    }

    public int getModSpecAttack() {
        return modSpecAttack;
    }

    public void setModSpecAttack(int modSpecAttack) {
        this.modSpecAttack = modSpecAttack;
    }

    public int getModSpecDefense() {
        return modSpecDefense;
    }

    public void setModSpecDefense(int modSpecDefense) {
        this.modSpecDefense = modSpecDefense;
    }

    public int getModSpeed() {
        return modSpeed;
    }

    public void setModSpeed(int modSpeed) {
        this.modSpeed = modSpeed;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    public boolean isHead() {
        return PartType.HEAD.equals(getPartType());
    }

    public boolean isBody() {
        return PartType.BODY.equals(getPartType());
    }
    
    public boolean isLegs() {
        return PartType.LEGS.equals(getPartType());
    }
    
    public boolean isRightArm() {
        return PartType.RIGHTARM.equals(getPartType());
    }
    
    public boolean isLeftArm() {
        return PartType.LEFTARM.equals(getPartType());
    }
    
    public boolean isChasis() {
        return PartType.CHASIS.equals(getPartType());
    }
    
    public static Part headPart = new Part("Head Part", 1, 1, 0, 0, 0, 0, 0, Ability.headbutt, PartType.HEAD);
}
