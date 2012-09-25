package items;

/**
 *
 * @author Ben Rudi
 */
public final class Item extends Equipment{

    public void Item() {

    }
    
    public Item(String itemName, int itemPrice) {
        setName(itemName);
        setPrice(itemPrice);
    }

}
