package src.objektorienterat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Stats {
	Map<String, Player> players;
	static final int SORTBYGAMESPLAYED =	0x1000;
	static final int SORTBYGAMESWON =		0x1001;
	static final int SORTBYGAMESLOST =		0x1002;
	static final int SORTBYGAMESDRAWN =		0x1003;

	public Stats() {
		this.players = new HashMap<>();
	}
	
	public Player getPlayer(String username) {
		return this.players.get(username);
	}

	public Map<String, Player> getPlayers() {
		return this.players;
	}

	public void put(Player p) {
		this.players.put(p.getUsername(), p);
	}

	public LinkedHashMap<String, Player> getPlayersSort(int sortCode) {
		if(!(	sortCode == Stats.SORTBYGAMESPLAYED	||
				sortCode == Stats.SORTBYGAMESWON	||
				sortCode == Stats.SORTBYGAMESLOST	||
				sortCode == Stats.SORTBYGAMESDRAWN	))
		{
			return null;
		}
		Comparator<Map.Entry<String, Player>> gamesWonComparator = new Comparator<Map.Entry<String, Player>>() {
			@Override
			public int compare(Map.Entry<String, Player> me1, Map.Entry<String, Player> me2) {
				Player p1 = me1.getValue();
				Player p2 = me2.getValue();
				if(sortCode == Stats.SORTBYGAMESPLAYED) {
					return p2.getGamesPlayed() - p1.getGamesPlayed();
				} else if(sortCode == Stats.SORTBYGAMESWON) {
					return p2.getGamesWon() - p1.getGamesWon();
				} else if(sortCode == Stats.SORTBYGAMESLOST) {
					return p2.getGamesLost() - p1.getGamesLost();
				} else {
					return p2.getGamesDrawn() - p1.getGamesDrawn();
				}
			}
		};
		List<Map.Entry<String, Player>> listOfEntries = new ArrayList<>(this.players.entrySet());
		Collections.sort(listOfEntries, gamesWonComparator);
		LinkedHashMap<String, Player> sortedByGamesWon = new LinkedHashMap<String, Player>(listOfEntries.size());
		for(Map.Entry<String, Player> entry : listOfEntries) {
			sortedByGamesWon.put(entry.getKey(), entry.getValue());
		}
		return sortedByGamesWon;
	}

	public Player findUser(String username){
		     return players.get(username);
	}
	public boolean PlayerExists(String username) {
		return players.get(username)!=null; 
	}

}