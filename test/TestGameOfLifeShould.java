import cell.CellState;
import org.junit.jupiter.api.Test;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TestGameOfLifeShould {

    private final CellState A = ALIVE;
    private final CellState D = DEAD;

    @Test
    void returnThePassedSeed() {
        CellState[][] firstGeneration = {
                { D, A },
                { A, D }
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        assertArrayEquals(firstGeneration, gameOfLife.getState());
    }
}