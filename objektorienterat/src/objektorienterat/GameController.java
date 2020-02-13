package src.objektorienterat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameController implements ModelListener {
	private GameModel model;
	private GameView view;
	private Playing player1;
	private Playing player2;
	private Playing currentlyPlaying;
	private boolean gameOver;
	
	public GameController(GameModel model, GameView view, Playing player1, Playing player2) {
		this.model = model;
		this.model.addListener(this);
		this.view = view;
		this.view.addCellListeners(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Cell c = (Cell)e.getSource();
				if(!gameOver && currentlyPlaying instanceof Player) {
					Player user = (Player)currentlyPlaying;
					user.makeMove(model, c.getCoordinate());
				}
			}
		});
		this.player1 = player1;
		this.player2 = player2;
		this.gameOver = true;
	}
	
	public void modelWasUpdated() {
		if(this.gameOver = this.model.isGameOver()) {
			// garbage below is just for testing - will be implemented properly soon(tm)
			String s = (this.model.getMarkCount() % 2 == 0) ? Mark.O.toString() : Mark.X.toString();
			if(this.model.getMarkCount() > 8 && !this.model.isWinner()) {
				s = "No one";
			}
			System.out.println("Game over! The winner is: "+s+"!");
		} else {
			this.currentlyPlaying = (this.currentlyPlaying == player1) ? player2 : player1;
			notifyAI();
		}
	}
	
	private void notifyAI() {
		if(!this.gameOver && this.currentlyPlaying instanceof AI) {
			AI ai = (AI)this.currentlyPlaying;
			ai.makeMove(this.model);
		}
	}

	public void gameInit() {
		Random random = new Random();
		this.currentlyPlaying = (random.nextInt(2) == 0) ? player1 : player2;
		this.model.reset();
		this.view.reset();
		this.gameOver = false;
		notifyAI();
	}

}
