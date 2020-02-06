package src.objektorienterat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    
    public void getData(List<Player> stats) {
    	try {
    		Statement s = conn.createStatement();
    		ResultSet rs = s.executeQuery("SELECT * FROM StatsView");
    		while(rs.next()) {
    			stats.add(
    					new Player(
    							rs.getString("username"),
    							rs.getInt("gamesPlayed"),
    							rs.getInt("gamesWon"),
    							rs.getInt("gamesLost"),
    							rs.getInt("gamesDrawn")));
    		}
    	} catch(SQLException e) {
            System.out.println(e);
    	}
    	
    }
    
    public void sendData(Player p) {
    	try {
    		Statement s = conn.createStatement();
        	s.executeUpdate("INSERT INTO Stats VALUES ('"
        						+	  p.getUsername()
        						+"',"+ Integer.toString(p.getGamesPlayed())
        						+","+ Integer.toString(p.getGamesWon())
        						+","+ Integer.toString(p.getGamesLost())
        						+","+ Integer.toString(p.getGamesDrawn())
        						+")");
    	} catch(SQLException e) {
    		System.out.println(e);
    	}
    }
}
