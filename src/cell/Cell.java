package cell;

import neighbours.NeighboursState;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;

public class Cell {

    final private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state == ALIVE;
    }

    public CellState getState() {
        return state;
    }

    public CellState getNextState(NeighboursState neighboursState) {
        return DEAD;
    }
}
