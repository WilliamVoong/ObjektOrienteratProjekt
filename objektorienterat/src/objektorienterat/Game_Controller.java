package src.objektorienterat;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game_Controller {
	private Game theModel;
	private GUI_GAME theView;

	public Game_Controller(Game theModel, GUI_GAME theView) {
		this.theModel = theModel;
		this.theView = theView;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				theView.addCellListener(new Coordinate(i, j), new CellListener());
			}
		}
	}

	class CellListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Cell c = (Cell) e.getSource();
			if (c.getText() == "") {
				Coordinate coord = c.getCoordinate();
				theModel.mark(coord);
				theView.setCellText(coord, theModel.getMark(coord));
				Coordinate AIcoord = AI.move(theModel.getMarks(), theModel.getMarkCount());
				if (AIcoord != null) {
					theModel.mark(AIcoord);
					theView.setCellText(AIcoord, theModel.getMark(AIcoord));
				}
			}
		}

	}

}