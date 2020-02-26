package src.objektorienterat;

import java.util.Map;

public class ScoreManager {
    Player currentUser;
    Stats stats;

    ScoreManager(Player player, Stats stats){
        this.currentUser=player;
        this.stats=stats;
    }

    public void updateScore(){
        Map<String,Player> listOfPlayers=stats.getPlayers();
        if(listOfPlayers.containsKey(currentUser.getUsername())){

        }
    }


}
