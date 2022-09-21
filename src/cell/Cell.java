package cell;

import neighbours.NeighboursState;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;
import static neighbours.NeighboursState.EXACTLY_TWO_NEIGHBOURS;
import static neighbours.NeighboursState.FEWER_THAN_TWO_NEIGHBOURS;

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
        if(state == ALIVE && neighboursState == FEWER_THAN_TWO_NEIGHBOURS) return DEAD;
        if(state == ALIVE && neighboursState == EXACTLY_TWO_NEIGHBOURS) return ALIVE;
        return DEAD;
    }
}
