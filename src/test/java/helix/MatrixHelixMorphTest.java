package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test0x0 () {
        int[][] inMaxtrix = {{}};
        int[][] expOutput = {{}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test3x1 () {
        int[][] inMaxtrix = {
                {1},
                {2},
                {3}
        };

        int[][] expOutput = {
                {1},
                {2},
                {3}
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test3x2 () {
        int[][] inMaxtrix = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] expOutput = {
                {1, 2},
                {6, 3},
                {5, 4}
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test3x3 () {
        int[][] inMaxtrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] expOutput = {
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test1x3 () {
        int[][] inMaxtrix = {
                {1, 2, 3}
        };

        int[][] expOutput = {
                {1, 2, 3}
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test2x3 () {
        int[][] inMaxtrix = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] expOutput = {
                {1, 2, 3},
                {6, 5, 4},
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test8x8 () {
        int[][] inMaxtrix = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48},
                {49, 50, 51, 52, 53, 54, 55, 56},
                {57, 58, 59, 60, 61, 62, 63, 64},
        };

        int[][] expOutput = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {28, 29, 30, 31, 32, 33, 34, 9},
                {27, 48, 49, 50, 51, 52, 35, 10},
                {26, 47, 60, 61, 62, 53, 36, 11},
                {25, 46, 59, 64, 63, 54, 37, 12},
                {24, 45, 58, 57, 56, 55, 38, 13},
                {23, 44, 43, 42, 41, 40, 39, 14},
                {22, 21, 20, 19, 18, 17, 16, 15},
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void test5x5 () {
        int[][] inMaxtrix = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25},
        };

        int[][] expOutput = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9},
        };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }

    @Test
    public void TestNull () {
        int[][] inMaxtrix = null;

        int[][] expOutput = null;

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMaxtrix)));
    }
}
