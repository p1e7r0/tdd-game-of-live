
import cell.Cell;
import cell.CellState;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static cell.CellState.ALIVE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
