package util;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Matt Bates
 */
public final class RNG {

	/**
	 * can be used to check if a random chance happened or not
	 * @param percentage needs to be in regular human readable format. for example 27.5% proc rate should be sent as 27.5d
	 */
	public static boolean proc( double percentage ) {
		return Math.random() * 100 < percentage;
	}

	/**
	 * Return a random integer between min and max (inclusive) 
	 */
	public static int rand( int min, int max ) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

	/**
	 * simulates the rolling of a single die
	 * 
	 */
	public static int roll( int count, int sides ) {
		Dice dice = new Dice( count, sides );
		return dice.roll();
	}

	/**
	 * represents one single die
	 */
	public static class Die {
		int sides;

		public Die( int sides ) {
			this.sides = sides;
		}

		public int roll() {
			return rand( 1, sides );
		}
	}

	/**
	 * represents a collection of dice which can be rolled as a group
	 */
	public static class Dice {
		Collection<Die> dice;

		public Dice( Collection<Die> dice ) {
			this.dice = dice;
		}

		public Dice( int count, int sides ) {
			dice = new ArrayList<Die>();

			for( int i = 0; i < count; i++ ){
				Die die = new Die( sides );
				dice.add( die );
			}
		}

		public int roll() {
			int total = 0;

			for( Die die : dice ){
				total += die.roll();
			}

			return total;
		}
	}

}
