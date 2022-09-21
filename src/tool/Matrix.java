package tool;

import java.util.function.BiConsumer;

public class Matrix {
    public static <T> void traverse(T[][] matrix, BiConsumer<Integer, Integer> callback) {
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                callback.accept(row, column);
            }
        }
    }
}
