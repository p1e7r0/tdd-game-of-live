package cell;

import static cell.CellState.ALIVE;

public class Cell {

    private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state == ALIVE;
    }
}
