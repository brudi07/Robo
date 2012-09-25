package items;

/**
 *
 * @author Ben Rudi
 */
public final class Armor extends Equipment {
    private int armor;
    
    public Armor() {}
    
    public Armor(String name, int price, int armor) {
        super(name,price);
        setArmor(armor);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armorArmor) {
        armor = armorArmor;
    }
}
