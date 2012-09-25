package items;

public class Equipment {

	private String name;
	private int price;
	
	public Equipment(){}
	
	public Equipment(String name, int price){
		setName( name);
		setPrice(price);
	}

	public String getName() {
	    return name;
	}

	public void setName( String weaponName ) {
	    name = weaponName;
	}

	public int getPrice() {
	    return price;
	}

	public void setPrice( int weaponPrice ) {
	    price = weaponPrice;
	}

}
