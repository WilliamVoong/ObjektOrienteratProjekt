package src.objektorienterat;

import java.io.Serializable;

public class GameAdmin implements ModelListener, Serializable {
	private Player currentUser;
	private GameModel model;
	private GameView view;
	private Playing player1, player2;
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
		if(gameType == GameAdmin.PVC) {
			AI ai = new AI(this.model);
			this.model.setPlayers(
					this.player1 = currentUser,
					this.player2 = ai);
			this.view.addListener(this.currentUser);
			this.model.addListener(ai);
		} else if(gameType == GameAdmin.PVP) {
			Player p2 = new Player("dummy", this.model, this.view);
			this.model.setPlayers(
					this.player1 = this.currentUser,
					this.player2 = p2);
			this.view.addListener(this.currentUser);
			this.view.addListener(p2);
		} else if(gameType == GameAdmin.CVC) {
			AI ai1 = new AI(this.model);
			AI ai2 = new AI(this.model);
			this.model.setPlayers(
					this.player1 = ai1,
					this.player2 = ai2);
			this.model.addListener(ai1);
			this.model.addListener(ai2);
		}
		//this.model.reset();
		this.view.fullUpdate();
		//this.model.gameInit();
	}


	public void setModel(GameModel model) {
		this.model = model;
	}

	public GameModel getModel() {
		return model;
	}

	public GameView getView() {
		return view;
	}

	public Player getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(Player currentUser) {
		this.currentUser = currentUser;
	}

	public Playing getPlayer1() {
		return player1;
	}

	public void setPlayer1(Playing player1) {
		this.player1 = player1;
	}

	public Playing getPlayer2() {
		return player2;
	}

	public void setPlayer2(Playing player2) {
		this.player2 = player2;
	}

	@Override
	public void modelWasUpdated() {
		if(!this.model.isGameOver()) {
			return;
		}
		if(this.model.isWinner()) {
			if(this.model.getCurrentlyPlaying() == this.player2) {
				this.player1.win();
				this.player2.lose();
			} else {
				this.player1.lose();
				this.player2.win();
			}
		} else {
			this.player1.draw();
			this.player2.draw();
		}
	}

}
