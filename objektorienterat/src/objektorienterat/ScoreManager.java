package src.objektorienterat;

import java.util.Map;
/*
 * Ansvaret för scoreManager är att hantera uppdateringen av poängräkning. 
 * author: William voong
 * Ver: 1.0
 * 
 */

public class ScoreManager {
    Player currentUser;
    Stats stats;
    ScoreManager(Player player, Stats stats){
        this.currentUser=player;
        this.stats=stats;
    }
    public void updateScoreStats(){
        if(stats.PlayerExists(currentUser.getUsername())){
        	stats.findUser(currentUser.getUsername()).cloneScore(currentUser);; 
        }
        else {
        	stats.put(currentUser.clone()); 
        }
    }
    public Stats receiveStats(){
    	return stats; 
    }
    
    /*
     * hittar spelaren i statsen, och clonar poängräkning från statsen
     * 
     */
    public void updateScorePlayer(){
    	 if(stats.PlayerExists(currentUser.getUsername())){
    		 Player currentScoreData= stats.findUser(currentUser.getUsername()); 
    		 currentUser.cloneScore(currentScoreData);
    	 }
    }
    
}
