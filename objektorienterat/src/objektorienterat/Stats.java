package src.objektorienterat;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stats {
	List<Player> players;
	
	public Stats() {
		this.players = new ArrayList<>();
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public void addPlayer(Player p) {
		this.players.add(p);
	}
	
	public void sort(Comparator<Player> c) {
		this.players.sort(c);
	}
	
	/*
	 * OBS! Följande finns bara här tillfälligt för att man ska kunna
	 * klippa och klistra snabba lambda statements om man använder sort-funktionen
	 */
	
	/*
	new Comparator<Player>() {
		@Override
		public int compare(Player o1, Player o2) {
			return o2.getGamesPlayed() - o1.getGamesPlayed();
		}
	}
	
	new Comparator<Player>() {
		@Override
		public int compare(Player o1, Player o2) {
			return o2.getGamesWon() - o1.getGamesWon();
		}
	}
	
	new Comparator<Player>() {
		@Override
		public int compare(Player o1, Player o2) {
			return o2.getGamesLost() - o1.getGamesLost();
		}
	}
	
	new Comparator<Player>() {
		@Override
		public int compare(Player o1, Player o2) {
			return o2.getGamesDrawn() - o1.getGamesDrawn();
		}
	}
	*/
	
}
