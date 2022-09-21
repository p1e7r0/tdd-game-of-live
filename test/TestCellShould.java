
import cell.Cell;
import org.junit.jupiter.api.Test;

import static cell.CellState.ALIVE;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TestCellShould {

    @Test
    void beAliveIfSetAlive() {
        Cell cell = new Cell(ALIVE);

        assertTrue(cell.isAlive());
    }
}
