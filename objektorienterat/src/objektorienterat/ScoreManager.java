package src.objektorienterat;

import java.util.Map;
/*
 * Ansvaret f�r scoreManager �r att hantera uppdateringen av po�ngr�kning. 
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
     * hittar spelaren i statsen, och clonar po�ngr�kning fr�n statsen
     * 
     */
    public void updateScorePlayer(){
    	 if(stats.PlayerExists(currentUser.getUsername())){
    		 Player currentScoreData= stats.findUser(currentUser.getUsername()); 
    		 currentUser.cloneScore(currentScoreData);
    	 }
    }
    
}
