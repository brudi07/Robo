package robot;

/**
 *
 * @author Ben Rudi
 */
public final class Ability {

	private String name;
	private String element;
	private int basePower;
	private int critChance;
	private DamageType damageType;

	public enum DamageType {
		PHYSICAL,
		SPECIAL
	}

        public Ability() {}
        
	public Ability( String eName, String eElement, DamageType eDamageType, int eBasePower, int eCritChance ) {
		setName( eName );
		setElement( eElement );
		setDamageType( eDamageType );
		setBasePower( eBasePower );
		setCritChance( eCritChance );
	}
	
	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public int getBasePower() {
		return basePower;
	}

	public void setBasePower( int basePower ) {
		this.basePower = basePower;
	}

	public DamageType getDamageType() {
		return damageType;
	}

	public void setDamageType( DamageType damageType ) {
		this.damageType = damageType;
	}

	public int getCritChance() {
		return critChance;
	}

	public void setCritChance( int critChance ) {
		this.critChance = critChance;
	}

	public String getElement() {
		return element;
	}

	public void setElement( String element ) {
		this.element = element;
	}
	
	public boolean isPhysical(){
		return DamageType.PHYSICAL.equals( getDamageType() );
	}
	
	public boolean isSpecial(){
		return DamageType.SPECIAL.equals( getDamageType() );
	}
	
	public static Ability scratch = new Ability("Scratch", "Normal", DamageType.PHYSICAL, 1, 20);
}
