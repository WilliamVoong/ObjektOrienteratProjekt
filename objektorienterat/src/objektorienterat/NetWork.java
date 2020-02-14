package src.objektorienterat;

import java.sql.*;

public class NetWork {
	static final String DATABASE = "jdbc:postgresql://localhost/portal";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "postgres";
    
    private Connection conn;
    
    public NetWork() {
    	try {
    		conn = DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    public void getData(Stats stats) {
    	try {
    		Statement s = conn.createStatement();
    		ResultSet rs = s.executeQuery("SELECT * FROM StatsView");
    		while(rs.next()) {
    			stats.put(
    					new Player(
    							rs.getString("username"),
    							rs.getInt("gamesWon"),
    							rs.getInt("gamesLost"),
    							rs.getInt("gamesDrawn")));
    		}
    		System.out.println("Fetched.");
    	} catch(SQLException e) {
            System.out.println(e);
    	}
    }
    
	public void putData(Player p) {
    	try {
    		String username = p.getUsername();
    		PreparedStatement psq = conn.prepareStatement("SELECT * "
    				+ "FROM Stats "
    				+ "WHERE username = ?",
    				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    		psq.setString(1, username);
    		ResultSet rs = psq.executeQuery();
    		if(rs.first()) {
    			PreparedStatement psu = conn.prepareStatement("UPDATE Stats SET "
    					+"	gamesPlayed = "+	Integer.toString(p.getGamesPlayed())
    					+",	gamesWon = "+ 		Integer.toString(p.getGamesWon())
    					+",	gamesLost = "+ 		Integer.toString(p.getGamesLost())
    					+",	gamesDrawn = "+ 	Integer.toString(p.getGamesDrawn())
    					+"	WHERE "
    					+"	username = ?");
    			psu.setString(1, username);
    			psu.executeUpdate();
    			System.out.println("Updated.");
    		} else {
    			PreparedStatement psi = conn.prepareStatement("INSERT INTO Stats VALUES ("
    					+ "?"
    					+","+ 	Integer.toString(p.getGamesPlayed())
    					+","+ 	Integer.toString(p.getGamesWon())
    					+","+ 	Integer.toString(p.getGamesLost())
    					+","+ 	Integer.toString(p.getGamesDrawn())
    					+")");
    			psi.setString(1, username);
    			psi.executeUpdate();
    			System.out.println("Inserted.");
    		}
    	} catch(SQLException e) {
    		System.out.println(e);
    	}
    }
}
