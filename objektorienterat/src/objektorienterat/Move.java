package src.objektorienterat;

import java.io.Serializable;

public class Move implements Serializable {
	private Mark mark;
	private Coordinate coord;
	
	public Move(Mark mark, Coordinate coord) {
		this.mark = mark;
		this.coord = coord;
	}
	
	public Move getMove() {
		return this;
	}
	
	public Mark getMark() {
		return this.mark;
	}
	
	public Coordinate getCoord() {
		return this.coord;
	}
}
