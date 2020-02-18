package src.objektorienterat;

public class GameAdmin implements ModelListener {
	private Player currentUser;
	private GameModel model;
	private GameView view;
	private int gameType;
	private Playing player1;
	@SuppressWarnings("unused")
	private Playing player2;
	static final int PVC = 0x1337;
	static final int PVP = 0x1338;
	static final int CVC = 0x1339;
	
	public GameAdmin(Player currentUser, GameModel model, GameView view) {
		this.currentUser = currentUser;
		this.model = model;
		this.model.addListener(this);
		this.view = view;
	}
	
	public void newGame(int gameType) {
		if(!(	gameType == GameAdmin.PVC ||
				gameType == GameAdmin.PVP ||
				gameType == GameAdmin.CVC))
		{
			return;
		}
		this.gameType = gameType;
		if(gameType == GameAdmin.PVC) {
			this.model.setPlayers(
					this.player1 = new HumanPlayer(this.currentUser, this.model, this.view),
					this.player2 = new AI(this.model));
		} else if(gameType == GameAdmin.PVP) {
			this.model.setPlayers(
					this.player1 = new HumanPlayer(this.currentUser, this.model, this.view),
					this.player2 = new HumanPlayer("", this.model, this.view));
		} else if(gameType == GameAdmin.CVC) {
			this.model.setPlayers(
					this.player1 = new AI(this.model),
					this.player2 = new AI(this.model));
		}
		this.model.reset();
		this.view.fullUpdate();
		this.model.gameInit();
	}

	@Override
	public void modelWasUpdated() {
		if(!(this.gameType == GameAdmin.PVC && this.model.isGameOver())) {
			return;
		}
		if(this.model.isWinner()) {
			if(this.model.getCurrentlyPlaying() == this.player1) {
				((HumanPlayer)this.player1).incrementGamesWon();
			} else {
				((HumanPlayer)this.player1).incrementGamesLost();
			}
		} else {
			((HumanPlayer)this.player1).incrementGamesDrawn();
		}
		
	}
	
}
