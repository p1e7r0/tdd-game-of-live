package cell;

import static cell.CellState.ALIVE;

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
}
