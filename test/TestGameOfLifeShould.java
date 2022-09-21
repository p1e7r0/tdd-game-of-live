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

    @Test
    void annihilateTheUniverseMadeOfOneLivingCell() {
        CellState[][] firstGeneration = {
                { A },
        };
        CellState[][] expectedGeneration = {
                { D },
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        CellState[][] nextGeneration = gameOfLife.nextGeneration();

        assertArrayEquals(expectedGeneration, nextGeneration);
    }

    @Test
    void bringLifeInToTheUniverse() {
        CellState[][] firstGeneration = {
                { D, A },
                { A, A },
        };
        CellState[][] expectedGeneration = {
                { A, A },
                { A, A },
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        CellState[][] nextGeneration = gameOfLife.nextGeneration();

        assertArrayEquals(expectedGeneration, nextGeneration);
    }

    @Test
    void annihilateTheUniverse() {
        CellState[][] firstGeneration = {
                { D, A },
                { A, D },
        };
        CellState[][] expectedGeneration = {
                { D, D },
                { D, D },
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        CellState[][] nextGeneration = gameOfLife.nextGeneration();

        assertArrayEquals(expectedGeneration, nextGeneration);
    }

    @Test
    void alternateTheCenterColumToCenterRow1Step() {
        CellState[][] firstGeneration = {
                { D, A, D },
                { D, A, D },
                { D, A, D },
        };
        CellState[][] expectedGeneration = {
                { D, D, D },
                { A, A, A },
                { D, D, D },
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        gameOfLife.nextGeneration();

        assertArrayEquals(expectedGeneration, gameOfLife.getState());
    }

    @Test
    void alternateTheCenterColumToCenterRow2Step() {
        CellState[][] firstGeneration = {
                { D, A, D },
                { D, A, D },
                { D, A, D },
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        gameOfLife.nextGeneration();
        gameOfLife.nextGeneration();

        assertArrayEquals(firstGeneration, gameOfLife.getState());
    }

    @Test
    void alternateTheCenterColumToCenterRow3Step() {
        CellState[][] firstGeneration = {
                { D, A, D },
                { D, A, D },
                { D, A, D },
        };
        CellState[][] expectedGeneration = {
                { D, D, D },
                { A, A, A },
                { D, D, D },
        };
        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        gameOfLife.nextGeneration();
        gameOfLife.nextGeneration();
        gameOfLife.nextGeneration();

        assertArrayEquals(expectedGeneration, gameOfLife.getState());
    }
}