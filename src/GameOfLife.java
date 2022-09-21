import cell.Cell;
import cell.CellState;
import neighbours.Neighbours;

public class GameOfLife {

    final private Cell[][] universe;

    public GameOfLife(CellState[][] seed) {
        this.universe = new Cell[seed.length][seed[0].length];
        for(int row = 0; row < seed.length; row++) {
            for(int column = 0; column < seed[row].length; column++) {
                this.universe[row][column] = new Cell(seed[row][column]);
            }
        }
    }

    public CellState[][] getState() {
        CellState[][] actualState = new CellState[this.universe.length][this.universe[0].length];
        for(int row = 0; row < this.universe.length; row++) {
            for(int column = 0; column < this.universe[row].length; column++) {
                actualState[row][column] =  this.universe[row][column].state();
            }
        }
        return actualState;
    }

    public CellState[][] nextGeneration() {
        CellState[][] nextGeneration = new CellState[this.universe.length][this.universe[0].length];
        for (int row = 0; row < this.universe.length; row++) {
            for (int column = 0; column < this.universe[row].length; column++) {
                nextGeneration[row][column] = this.universe[row][column].getNextState(getNeighbours(row, column));
            }
        }
        for (int row = 0; row < this.universe.length; row++) {
            for (int column = 0; column < this.universe[row].length; column++) {
                this.universe[row][column] = new Cell(nextGeneration[row][column]);
            }
        }
        return nextGeneration;
    }

    private Neighbours getNeighbours(int row, int column) {
        int neighboursNumber = 0;
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = column - 1; j <= column + 1; j++) {
                if (i == row && j == column) continue;
                if (i < 0 || i >= universe.length || j < 0 || j >= universe[row].length) continue;
                if (universe[i][j].isAlive()) {
                    neighboursNumber++;
                }
            }
        }
        return new Neighbours(neighboursNumber);
    }
}
