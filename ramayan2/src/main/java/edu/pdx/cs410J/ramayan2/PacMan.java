package edu.pdx.cs410J.ramayan2;

class Keyboard {
    public enum KEY {
        LEFT, RIGHT, UP, DOWN
    }
    private KEY keyPress;

    public void setKeyPress(KEY keyPress) {
        this.keyPress = keyPress;
    }

    public KEY getKeyPress() {
        return keyPress;
    }
}


class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Find valid moves
    //credit: https://jvm-gaming.org/t/pacman-pathfinding/21714/2
    public Position[] generateMoves(Board board)
    {
        boolean[] moves = new boolean[4];
        int count = 0;
        Position[] positions;

        //check for valid moves
        if(!board.isWall(x-1, y)) moves[0] = true;
        if(!board.isWall(x+1, y)) moves[1] = true;
        if(!board.isWall(x, y-1)) moves[2] = true;
        if(!board.isWall(x, y+1)) moves[3] = true;

        //count how many valid moves
        for(int i=0; i<moves.length; i++)
            count += (moves[i] ? 1 : 0);

        //valid moves array
        positions = new Position[count];
        count = 0;

        //if a spot is not a wall, save position
        if(!board.isWall(x-1, y)) positions[count++] = new Position(x-1, y);
        if(!board.isWall(x+1, y)) positions[count++] = new Position(x+1, y);
        if(!board.isWall(x, y-1)) positions[count++] = new Position(x, y-1);
        if(!board.isWall(x, y+1)) positions[count++] = new Position(x, y+1);

        return positions;
    }
}

//create the board
class Board {
    char gameboard[][];

    public Board(int x, int y){
        gameboard = new char[x][y];
        // Logic for creating boundary walls (Credits: https://www.geeksforgeeks.org/find-sum-of-all-boundary-and-diagonal-element-of-a-matrix/)
        char boundaryWallValue = '1';
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0 || i == x - 1|| j == y - 1) {
                    gameboard[i][j] = boundaryWallValue;
                }
            }
        }
        // Pac man starting position is char '<'
        gameboard[1][1] = '<';
    }
    public boolean isWall(int x, int y)
    {
           if(gameboard[x][y] == '1')
               return true;
           else
               return false;
    }

}

public class PacMan {

    public static void main(String[] args) {
        Board board = new Board(5, 10);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board.gameboard[i][j]);
            }
            System.out.println();
        }
    }

}
