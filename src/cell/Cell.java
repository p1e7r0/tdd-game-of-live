package cell;

import neighbours.Neighbours;
import neighbours.NeighboursState;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;

public record Cell(CellState state) {

    public boolean isAlive() {
        return state == ALIVE;
    }

    public CellState getNextState(NeighboursState neighboursState) {
        return switch (state) {
            case ALIVE -> switch (neighboursState) {
                case FEWER_THAN_TWO_NEIGHBOURS, MORE_THAN_THREE_NEIGHBOURS -> DEAD;
                case EXACTLY_TWO_NEIGHBOURS, EXACTLY_THREE_NEIGHBOURS -> ALIVE;
            };
            case DEAD -> switch (neighboursState) {
                case FEWER_THAN_TWO_NEIGHBOURS, EXACTLY_TWO_NEIGHBOURS, MORE_THAN_THREE_NEIGHBOURS -> DEAD;
                case EXACTLY_THREE_NEIGHBOURS -> ALIVE;
            };
        };
    }

    public CellState getNextState(Neighbours neighbours) {
        return getNextState(neighbours.getState());
    }
}
