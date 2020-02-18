package src.objektorienterat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class NetWork {
    private Connection conn;
    
    public NetWork() {
    	Properties props = new Properties();
    	try {
			InputStream inStream = new FileInputStream("database.config");
			props.load(inStream);
			props.list(System.out);
			conn = DriverManager.getConnection(
					props.getProperty("url"),
					props.getProperty("username"),
					props.getProperty("password"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			try {
				OutputStream out = new FileOutputStream("database.config");
				props.setProperty("url", "enter_url_here");
				props.setProperty("username", "enter_username_here");
				props.setProperty("password", "enter_password_here");
				props.store(out, "     :)");
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			} catch (IOException e3) {
				e3.printStackTrace();
			}
		} catch(IOException e4) {
			e4.printStackTrace();
		} catch(SQLException e5) {
			System.out.println(e5);
		}
    }
    
    public void getData(Stats stats) {
    	try {
    		Statement s = this.conn.createStatement();
    		ResultSet rs = s.executeQuery("SELECT * FROM Stats");
    		while(rs.next()) {
    			stats.put(
    					new Player(
    							rs.getString("username"),
    							rs.getInt("gamesWon"),
    							rs.getInt("gamesLost"),
    							rs.getInt("gamesDrawn")));
    		}
    	} catch(SQLException e) {
            System.out.println(e);
    	}
    }
    
    public void putData(Stats stats) {
		List<Map.Entry<String, Player>> listOfEntries = new ArrayList<>(stats.getPlayers().entrySet());
		for(Map.Entry<String, Player> entry : listOfEntries) {
			putPlayer(entry.getValue());
		}
    }
    
	public void putPlayer(Player p) {
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
    		}
    	} catch(SQLException e) {
    		System.out.println(e);
    	}
    }
}
