
import cell.Cell;
import cell.CellState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static neighbours.NeighboursState.*;
import static neighbours.NeighboursState.EXACTLY_THREE_NEIGHBOURS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;

class TestCellShould {

    @Test
    void beAliveIfSetAlive() {
        Cell cell = new Cell(ALIVE);

        assertTrue(cell.isAlive());
    }

    @ParameterizedTest
    @EnumSource(CellState.class)
    void returnThePassedCellState(CellState state) {
        Cell cell = new Cell(state);

        assertEquals(state, cell.getState());
    }

    @Test
    void dieIfNeighboursAreFewerThanTwo() {
        Cell cell = new Cell(ALIVE);

        CellState nextState = cell.getNextState(FEWER_THAN_TWO_NEIGHBOURS);

        assertEquals(DEAD, nextState);
    }

    @Test
    void continueToLiveIfNeighboursAreTwo() {
        Cell cell = new Cell(ALIVE);

        CellState nextState = cell.getNextState(EXACTLY_TWO_NEIGHBOURS);

        assertEquals(ALIVE, nextState);
    }

    @Test
    void continueToLiveIfNeighboursAreThree() {
        Cell cell = new Cell(ALIVE);

        CellState nextState = cell.getNextState(EXACTLY_THREE_NEIGHBOURS);

        assertEquals(ALIVE, nextState);
    }

    @Test
    void becomeAliveIfNeighboursAreThree() {
        Cell cell = new Cell(DEAD);

        CellState nextState = cell.getNextState(EXACTLY_THREE_NEIGHBOURS);

        assertEquals(ALIVE, nextState);
    }

}
