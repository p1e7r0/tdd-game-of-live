import cell.CellState;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import static cell.CellState.ALIVE;
import static cell.CellState.DEAD;

public class Main {

    static void printGeneration(CellState[][] grid) {
        System.out.println(Arrays.deepToString(grid)
                .replace("],", "],\n")
                .replaceAll("[ ,\\[\\]]", "")
                .replace(ALIVE.toString(), "X")
                .replace(DEAD.toString(), " ")
                );
    }

    public static void main(String[] args) {

        CellState A = ALIVE;
        CellState D = DEAD;

        CellState[][] firstGeneration = {
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
                { D, D, D, D, A, A, A, D, D, D, A, A, A, D, D, D, D },
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
                { D, D, A, D, D, D, D, A, D, A, D, D, D, D, A, D, D },
                { D, D, A, D, D, D, D, A, D, A, D, D, D, D, A, D, D },
                { D, D, A, D, D, D, D, A, D, A, D, D, D, D, A, D, D },
                { D, D, D, D, A, A, A, D, D, D, A, A, A, D, D, D, D },
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
                { D, D, D, D, A, A, A, D, D, D, A, A, A, D, D, D, D },
                { D, D, A, D, D, D, D, A, D, A, D, D, D, D, A, D, D },
                { D, D, A, D, D, D, D, A, D, A, D, D, D, D, A, D, D },
                { D, D, A, D, D, D, D, A, D, A, D, D, D, D, A, D, D },
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
                { D, D, D, D, A, A, A, D, D, D, A, A, A, D, D, D, D },
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
                { D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D, D },
        };

        printGeneration(firstGeneration);

        GameOfLife gameOfLife = new GameOfLife(firstGeneration);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                printGeneration(gameOfLife.nextGeneration());
            }
        }, 500, 500);
    }

}
