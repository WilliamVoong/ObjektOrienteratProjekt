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
}

