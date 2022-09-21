package cell;

import neighbours.NeighboursState;

import java.util.HashMap;
import java.util.Map;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;
import static neighbours.NeighboursState.*;

public class Cell {
    private final Map<NeighboursState, CellState> neighboursCellStateFromAlive = new HashMap<>(){{
        put(FEWER_THAN_TWO_NEIGHBOURS, DEAD);
        put(EXACTLY_TWO_NEIGHBOURS, ALIVE);
        put(EXACTLY_THREE_NEIGHBOURS, ALIVE);
        put(MORE_THAN_THREE_NEIGHBOURS, DEAD);
    }};

    private final Map<NeighboursState, CellState> neighboursCellStateFromDead = new HashMap<>(){{
        put(EXACTLY_THREE_NEIGHBOURS, ALIVE);
    }};

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
        return switch (state){
            case ALIVE -> neighboursCellStateFromAlive.get(neighboursState);
            case DEAD -> neighboursCellStateFromDead.get(neighboursState);
        };
    }
}
