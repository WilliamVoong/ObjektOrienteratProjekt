package src.objektorienterat;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AI {

	private static Coordinate smartMove(String[][] marks, int markCount) {
		int rowOffenseCount;
		int rowDefenseCount;
		String currentRowMark = null;
		Coordinate potentialRowMarkCoordinate = null;
		Coordinate defensiveRowMarkCoordinate = null;

		int columnOffenseCount;
		int columnDefenseCount;
		String currentColumnMark = null;
		Coordinate potentialColumnMarkCoordinate = null;
		Coordinate defensiveColumnMarkCoordinate = null;

		int diagonal1OffenseCount = 0;
		int diagonal1DefenseCount = 0;
		String currentDiagonal1Mark = null;
		Coordinate potentialDiagonal1MarkCoordinate = null;

		int diagonal2OffenseCount = 0;
		int diagonal2DefenseCount = 0;
		String currentDiagonal2Mark = null;
		Coordinate potentialDiagonal2MarkCoordinate = null;

		for (int i = 0; i < 3; i++) {
			rowOffenseCount = rowDefenseCount = columnOffenseCount = columnDefenseCount = 0;
			potentialRowMarkCoordinate = potentialColumnMarkCoordinate = null;
			for (int j = 0; j < 3; j++) {
				currentRowMark = marks[i][j];
				currentColumnMark = marks[j][i];
				switch (markProperty(currentRowMark, markCount)) {
				case 0:
					potentialRowMarkCoordinate = new Coordinate(i, j);
					break;
				case 1:
					rowOffenseCount++;
					break;
				case 2:
					rowDefenseCount++;
				}
				switch (markProperty(currentColumnMark, markCount)) {
				case 0:
					potentialColumnMarkCoordinate = new Coordinate(j, i);
					break;
				case 1:
					columnOffenseCount++;
					break;
				case 2:
					columnDefenseCount++;
				}
			}
			if (isMoveGood(rowOffenseCount, potentialRowMarkCoordinate)) {
				return potentialRowMarkCoordinate;
			} else if (isMoveGood(columnOffenseCount, potentialColumnMarkCoordinate)) {
				return potentialColumnMarkCoordinate;
			} else if (isMoveGood(rowDefenseCount, potentialRowMarkCoordinate)) {
				defensiveRowMarkCoordinate = potentialRowMarkCoordinate;
			} else if (isMoveGood(columnDefenseCount, potentialColumnMarkCoordinate)) {
				defensiveColumnMarkCoordinate = potentialColumnMarkCoordinate;
			}

			currentDiagonal1Mark = marks[i][i];
			currentDiagonal2Mark = marks[i][2 - i];
			switch (markProperty(currentDiagonal1Mark, markCount)) {
			case 0:
				potentialDiagonal1MarkCoordinate = new Coordinate(i, i);
				break;
			case 1:
				diagonal1OffenseCount++;
				break;
			case 2:
				diagonal1DefenseCount++;
			}
			switch (markProperty(currentDiagonal2Mark, markCount)) {
			case 0:
				potentialDiagonal2MarkCoordinate = new Coordinate(i, 2 - i);
				break;
			case 1:
				diagonal2OffenseCount++;
				break;
			case 2:
				diagonal2DefenseCount++;
			}
		}

		if (isMoveGood(diagonal1OffenseCount, potentialDiagonal1MarkCoordinate)) {
			return potentialDiagonal1MarkCoordinate;
		} else if (isMoveGood(diagonal2OffenseCount, potentialDiagonal2MarkCoordinate)) {
			return potentialDiagonal2MarkCoordinate;
		} else if (defensiveRowMarkCoordinate != null) {
			return defensiveRowMarkCoordinate;
		} else if (defensiveColumnMarkCoordinate != null) {
			return defensiveColumnMarkCoordinate;
		} else if (isMoveGood(diagonal1DefenseCount, potentialDiagonal1MarkCoordinate)) {
			return potentialDiagonal1MarkCoordinate;
		} else if (isMoveGood(diagonal2DefenseCount, potentialDiagonal2MarkCoordinate)) {
			return potentialDiagonal2MarkCoordinate;
		}

		return null;
	}

	private static int markProperty(String mark, int markCount) {
		if (mark.equals("")) {
			return 0;
		} else if ((mark.equals("X") && markCount % 2 == 0) || (mark.equals("O") && markCount % 2 == 1)) {
			return 1;
		} else {
			return 2;
		}
	}

	private static boolean isMoveGood(int count, Coordinate potentialMarkCoordinate) {
		return count == 2 && potentialMarkCoordinate != null;
	}

	private static Coordinate randomMove(String[][] marks) {
		List<Coordinate> potentialMoveCoordinates = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (marks[i][j].equals("")) {
					potentialMoveCoordinates.add(new Coordinate(i, j));
				}
			}
		}
		if (!potentialMoveCoordinates.isEmpty()) {
			return potentialMoveCoordinates.get(rand.nextInt(potentialMoveCoordinates.size()));
		}
		return null;
	}

	public static Coordinate move(String[][] marks, int markCount) {
		Coordinate retCoord;
		retCoord = smartMove(marks, markCount);
		if (retCoord != null) {
			return retCoord;
		}
		retCoord = randomMove(marks);
		if (retCoord != null) {
			return retCoord;
		}
		return null;
	}

}
