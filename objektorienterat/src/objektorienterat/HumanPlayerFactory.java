package src.objektorienterat;

public class HumanPlayerFactory {
	private GameView gameView;
	private GameModel gameModel;
	private Stats stats; 
	HumanPlayerFactory(GameView gameView, GameModel gameModel,Stats stats){
		this.stats=stats; 
		this.gameView=gameView;
		this.gameModel=gameModel; 
	}

	 public HumanPlayer create(String username) {
		 Player Player2Play;
		 boolean playerExists= stats.getPlayers().containsKey(username);
		 if(playerExists) {
			Player2Play = stats.getPlayers().get(username);
		}else {
			Player2Play = new Player(username,0,0,0); 
			stats.getPlayers().put(username, new Player(username,0,0,0));
		}		
		return new HumanPlayer(Player2Play, gameModel, gameView);
	 }
}
