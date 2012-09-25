package battle;

import enemy.Enemy;
import gui.BattlePanel;
import gui.MenuPanel;
import player.Player;
import robot.Ability;
import robot.Robot;
import util.RNG;

/**
 *
 * @author Ben Rudi
 */
public class Battle {

	Ability abilities = new Ability();
	private Boolean myTurn;

	public void Battle( Player player, Enemy enemy ) {
		
		BattlePanel.battleText.append( player.getStats() );
		BattlePanel.battleText.append( enemy.getStats() );

		// Determine who goes first
		isFirst( player, enemy );

		while( player.getHealth() > 0 && enemy.getHealth() > 0 ){
			// TODO
			if( myTurn ){
				BattlePanel.battleText.append( player.getName() + " attacks " + enemy.getName() + ".\n" );
				BattlePanel.battleText.append( player.getName() + " used " + Ability.scratch.getName() + "\n" );
				enemy.setHealth( enemy.getHealth() - damageDone( player, enemy, Ability.scratch ) );
				BattlePanel.battleText.append( enemy.getName() + " is at " + enemy.getHealth() + "\n\n" );
				myTurn = false;
			}
                        else {
				BattlePanel.battleText.append( enemy.getName() + " attacks " + player.getName() + ".\n" );
				BattlePanel.battleText.append( enemy.getName() + " used " + Ability.scratch.getName() + "\n" );
				player.setHealth( player.getHealth() - damageDone( enemy, player, Ability.scratch ) );
				BattlePanel.battleText.append( player.getName() + " is at " + player.getHealth() + "\n\n" );
				myTurn = true;
			}
		}

		if( player.getHealth() <= 0 ){
			BattlePanel.battleText.append( player.getName() + " faints...\n\n" );
		}
		else{
			BattlePanel.battleText.append( player.getName() + " wins!\n\n" );
                        player.levelUp();
		}
	}

	public Boolean isFirst( Player player, Enemy enemy ) {
		if( player.getModSpeed() > enemy.getModSpeed() ){
			myTurn = true;
			BattlePanel.battleText.append( "Player goes first!\n" );
		}
		else if( enemy.getModSpeed() > player.getModSpeed() ){
			myTurn = false;
			BattlePanel.battleText.append( "Enemy goes first!\n" );
		}
		else{
			myTurn = true;
			BattlePanel.battleText.append( "Player goes first!\n" );
		}
		return myTurn;
	}

	public int damageDone( Robot source, Robot target, Ability ability ) {
		int damage = ability.getBasePower();

		boolean crit = RNG.proc( ability.getCritChance() );
		
		if( crit ){
			BattlePanel.battleText.append( "CRIT!\n" );
			damage += source.getModAttack( ability.getDamageType() );
		}
		damage += source.getModAttack( ability.getDamageType() );
		damage -= target.getModDefense( ability.getDamageType() );

		return damage;
	}
}
