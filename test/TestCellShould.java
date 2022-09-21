
import cell.Cell;
import cell.CellState;
import neighbours.Neighbours;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import static neighbours.NeighboursState.*;
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

        assertEquals(state, cell.state());
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

    @Test
    void dieIfNeighboursAreMoreThanTre() {
        Cell cell = new Cell(ALIVE);

        CellState nextState = cell.getNextState(MORE_THAN_THREE_NEIGHBOURS);

        assertEquals(DEAD, nextState);
    }

    @ParameterizedTest
    @CsvSource({
            "DEAD, 0, DEAD",
            "DEAD, 1, DEAD",
            "DEAD, 2, DEAD",
            "DEAD, 3, ALIVE",
            "DEAD, 4, DEAD",
            "DEAD, 5, DEAD",
            "DEAD, 6, DEAD",
            "DEAD, 7, DEAD",
            "DEAD, 8, DEAD",
            "ALIVE, 0, DEAD",
            "ALIVE, 1, DEAD",
            "ALIVE, 2, ALIVE",
            "ALIVE, 3, ALIVE",
            "ALIVE, 4, DEAD",
            "ALIVE, 5, DEAD",
            "ALIVE, 6, DEAD",
            "ALIVE, 7, DEAD",
            "ALIVE, 8, DEAD",
    })
    void returnNextCellStateAccordingToTransformationsRules(CellState cellState, int neighboursNumber, CellState expectedCellState) {
        Cell cell = new Cell(cellState);

        CellState nextState = cell.getNextState(new Neighbours(neighboursNumber));

        assertEquals(expectedCellState, nextState);
    }

}
