package src.objektorienterat;

import java.util.Random;

public  class GameController {
    private GameModel theModel;
    private GameView theView;
    private Playing player1;
	private Playing player2;
	private Playing currentlyPlaying;
	private boolean gameOver;

    public GameController(GameModel theModel, GameView theView, Playing player1, Playing player2) {
        this.theModel = theModel;
        this.theView = theView;
        this.player1 = player1;
        this.player2 = player2;
        this.gameOver = true;
    }
    
    public void gameInit() {
		Random random = new Random();
		this.currentlyPlaying = (random.nextInt(2) == 0) ? player1 : player2;
		this.theModel.reset();
		this.theView.reset();
		this.gameOver = false;
		notifyAI();
	}
    
    public void viewCellWasClicked() {
		if(!this.gameOver && this.currentlyPlaying instanceof Player) {
			this.currentlyPlaying.makeMove(this.theModel, this.theView);
		}
	}
    
    public void viewStateWasChanged() {
		if(this.gameOver = this.theModel.isGameOver()) {
			// notify view (to be continued - the crap below is just for testing purposes)
			String s = (this.theModel.getMarkCount() == 0) ? Mark.X.toString() : Mark.O.toString();
			if(this.theModel.getMarkCount() > 8 && !this.theModel.isWinner()) {
				s = "No one";
			}
			System.out.println("Game over! The winner is: "+s+"!");
		} else {
			changeTurn();
			notifyAI();
		}
	}
    
    private void notifyAI() {
		if(!this.gameOver && this.currentlyPlaying instanceof AI) {
			this.currentlyPlaying.makeMove(this.theModel, this.theView);
		}
	}

	private void changeTurn() {
		this.currentlyPlaying = (this.currentlyPlaying == player1) ? player2 : player1;
	}

}
