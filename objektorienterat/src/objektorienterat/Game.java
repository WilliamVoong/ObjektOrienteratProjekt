package src.objektorienterat;

public class Game {
    private String[][] marks;
    private int markCount;

    Game() {
        this.marks = new String[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                this.marks[i][j] = "";
            }
        }
        this.markCount = 0;
    }

    public void mark(Coordinate c) {
        int x = c.getX();
        int y = c.getY();
        if(this.markCount % 2 == 0) {
            this.marks[x][y] = "X";
        } else {
            this.marks[x][y] = "O";
        }
        this.markCount++;
    }

    public String getMark(Coordinate c) {
        return this.marks[c.getX()][c.getY()];
    }

    public String[][] getMarks() {
        return this.marks;
    }

    public int getMarkCount() {
        return this.markCount;
    }
    
    public int checkForWinner(Coordinate c) {
    	// there cannot be a winner if markCount < 5
    	if(this.markCount < 5) {
    		return -1;
    	}
    	int x = c.getX();
    	int y = c.getY();
    	
    	// check the row
    	if(	this.marks[x][0].equals(this.marks[x][1])
    		&&
    		this.marks[x][1].equals(this.marks[x][2])) 
    	{
    		return this.markCount % 2;
    	}
    	
    	// check the column
    	if(	this.marks[0][y].equals(this.marks[1][y])
        	&&
        	this.marks[1][y].equals(this.marks[2][y]))
    	{
        	return this.markCount % 2;
        }
    	
    	// check diagonals regardless due to laziness
    	if(	this.marks[0][0].equals(this.marks[1][1])
        	&&
        	this.marks[1][1].equals(this.marks[2][2])
    		||
    		this.marks[2][0].equals(this.marks[1][1])
    	    &&
    	    this.marks[1][1].equals(this.marks[0][2]))
    	{
        	return this.markCount % 2;
        }
    	
    	// no winner
    	return -1;
    }
    
    public void reset() {
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) {
    			this.marks[i][j] = "";
    		}
    	}
    	this.markCount = 0;
    }
    
}

