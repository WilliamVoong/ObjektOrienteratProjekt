package src.objektorienterat;

import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception{
		System.out.println("helloworld");
		//new MainWindow();
		Stats s = new Stats();
		NetWork n = new NetWork();
		Player p1 = new Player("Bajjan", 2, 3, 0);
		Player p2 = new Player("Lajjan", 23, 17, 0);
		Player p3 = new Player("Krajjan", 18, 18, 0);
		Player p4 = new Player("Viggan", 50, 0, 0);
		System.out.println("Stats, Network and Player initialized. Getting data...");
		n.getData(s);
		Thread.sleep(1000);
		n.putData(p1);
		Thread.sleep(1000);
		n.putData(p2);
		Thread.sleep(1000);
		n.putData(p3);
		Thread.sleep(1000);
		n.putData(p4);
		Thread.sleep(1000);
		n.getData(s);
		Thread.sleep(1000);
		System.out.println("Unsorted: ");
		for(Map.Entry<String, Player> entry : s.getPlayers().entrySet()) {
			System.out.println("User: "+entry.getKey()+" Wins: "+entry.getValue().getGamesWon()+" Losses: "+entry.getValue().getGamesLost());
			Thread.sleep(1000);
		}
		System.out.println("Sorted: ");
		for(Map.Entry<String, Player> entry : s.getPlayersSort(Stats.SORTBYGAMESWON).entrySet()) {
			System.out.println("User: "+entry.getKey()+" Wins: "+entry.getValue().getGamesWon()+" Losses: "+entry.getValue().getGamesLost());
			Thread.sleep(1000);
		}
		
	}
}
