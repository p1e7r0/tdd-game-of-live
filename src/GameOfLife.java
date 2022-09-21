import cell.Cell;
import cell.CellState;

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
        CellState[][] actualState = new CellState[universe.length][universe[0].length];
        for(int row = 0; row < this.universe.length; row++) {
            for(int column = 0; column < this.universe[row].length; column++) {
                actualState[row][column] =  this.universe[row][column].state();
            }
        }
        return actualState;
    }

    public CellState[][] nextGeneration() {
        CellState[][] nextState = new CellState[1][1];
        nextState[0][0] = CellState.DEAD;
        return nextState;
    }
}
