package src.objektorienterat;

import java.util.Random;

public  class GameController {
    private GameModel theModel;
    private GameView theView;
    private Playing player1;
	private Playing player2;
	private Playing currentlyPlaying;

    public GameController(GameModel theModel, GameView theView, Playing player1, Playing player2) {
        this.theModel = theModel;
        this.theView = theView;
        this.player1 = player1;
        this.player2 = player2;
    }
    
    public void gameInit() {
		Random random = new Random();
		this.currentlyPlaying = (random.nextInt(2) == 0) ? player1 : player2;
		notifyAI();
	}
    
    public void viewCellWasClicked() {
		if(this.currentlyPlaying instanceof Player) {
			this.currentlyPlaying.makeMove(this.theModel, this.theView, this.theView.getLastClickedCell().getCoordinate());
		}
	}
    
    public void viewStateWasChanged() {
		changeTurn();
		notifyAI();
	}
    
    private void notifyAI() {
		if(this.currentlyPlaying instanceof AI) {
			this.currentlyPlaying.makeMove(this.theModel, this.theView, null);
		}
	}

	private void changeTurn() {
		this.currentlyPlaying = (this.currentlyPlaying == player1) ? player2 : player1;
	}

}
