package src.objektorienterat;

import java.io.Serializable;

public class GameAdmin implements ModelListener, Serializable {
	private static final long serialVersionUID = 1L;
	private Player currentUser;
	private GameModel model;
	private GameView view;
	private Playing player1, player2;

	public GameAdmin(Player currentUser, GameModel model, GameView view) {
		this.currentUser = currentUser;
		this.model = model;
		this.model.addListener(this);
		this.view = view;
	}
	
	public void newGamePVC(boolean loadGame) {
		AI ai = new AI(this.model);
		this.model.setPlayers(
				this.player1 = currentUser,
				this.player2 = ai);
		this.view.addListener(this.currentUser);
		this.model.addListener(ai);
		this.view.fullUpdate();
		this.model.gameInit(loadGame);
	}
	
	public void newGamePVP(String p2name, boolean loadGame) {
		Player p2 = new Player(p2name, this.model, this.view);
		this.model.setPlayers(
				this.player1 = this.currentUser,
				this.player2 = p2);
		this.view.addListener(this.currentUser);
		this.view.addListener(p2);
		this.view.fullUpdate();
		this.model.gameInit(loadGame);
	}


	public void loadgame(GameModel gameModel)
	{
		model.setMarks(gameModel.getMarks());
		model.setMarkCount(gameModel.getMarkCount());
		model.setLastMove(gameModel.getLastMove());
		if(gameModel.getPlayer2() instanceof  AI )
			newGamePVC(true);
		else
			newGamePVP(((Player)gameModel.getPlayer2()).getUsername(),true);
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
