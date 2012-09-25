package items;

/**
 *
 * @author Ben Rudi
 */
public final class Weapon extends Equipment{
    
    private int damage;
    
    public Weapon() {}
    
    public Weapon(String name, int price, int damage) {
        super(name,price);
        setDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int weaponDamage) {
        damage = weaponDamage;
    }
}
