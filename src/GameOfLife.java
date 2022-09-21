import cell.Cell;
import cell.CellState;
import neighbours.Neighbours;
import tool.Matrix;

public class GameOfLife {

    final private Cell[][] universe;

    public GameOfLife(CellState[][] seed) {
        assert seed.length >= 1 && seed[0].length >= 1;
        this.universe = new Cell[seed.length][seed[0].length];
        Matrix.traverse(seed, (row, column) -> this.universe[row][column] = new Cell(seed[row][column]));
    }

    public CellState[][] getState() {
        CellState[][] actualState = new CellState[this.universe.length][this.universe[0].length];
        Matrix.traverse(universe, (row, column) -> actualState[row][column] = universe[row][column].state());
        return actualState;
    }

    public CellState[][] nextGeneration() {
        CellState[][] nextGeneration = new CellState[this.universe.length][this.universe[0].length];
        Matrix.traverse(universe, (row, column) -> nextGeneration[row][column] = universe[row][column].getNextState(getNeighbours(row, column)));
        Matrix.traverse(nextGeneration, (row, column) -> this.universe[row][column] = new Cell(nextGeneration[row][column]));
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
