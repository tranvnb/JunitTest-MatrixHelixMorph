package helix;

import org.jetbrains.annotations.NotNull;

public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */

    public static int[][] helix(int[][] inMatrix) {

        if (inMatrix == null)
            return null;

        int X = inMatrix.length;
        int Y = inMatrix[0].length;
        int spiralStartX = 0, spiralEndX = inMatrix.length - 1, spiralStartY = 0, spiralEndY = inMatrix[0].length - 1;

        int[][] helixResult = new int[X][Y];
        int spiralPointerX = 0;
        int spiralPointerNextMoveX = 0;
        int spiralPointerNextMoveY = 1;
        int spiralPointerY = 0;
        boolean moveHorizontally = true;
        boolean moveForward = true;
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                helixResult[spiralPointerX][spiralPointerY] = inMatrix[i][j];

                if (moveHorizontally) {
                    if (moveForward && spiralPointerY == spiralEndY) {
                        spiralStartX++;
                        spiralPointerNextMoveX = 1;
                        spiralPointerNextMoveY = 0;
                        moveHorizontally = false;
                    } else if (!moveForward && spiralPointerY == spiralStartY) {
                        spiralEndX--;
                        spiralPointerNextMoveX = -1;
                        spiralPointerNextMoveY = 0;
                        moveHorizontally = false;
                        moveForward = false;
                    }
                } else {
                    if (moveForward && spiralPointerX == spiralEndX) {
                        spiralEndY--;
                        spiralPointerNextMoveX = 0;
                        spiralPointerNextMoveY = -1;
                        moveHorizontally = true;
                        moveForward = false;
                    }else if (!moveForward && spiralPointerX == spiralStartX) {
                        spiralStartY++;
                        spiralPointerNextMoveX = 0;
                        spiralPointerNextMoveY = 1;
                        moveHorizontally = true;
                        moveForward = true;
                    }
                }

                spiralPointerX += spiralPointerNextMoveX;
                spiralPointerY += spiralPointerNextMoveY;

            }

        }

        return helixResult;
    }

    public static void main (String[] args) {
        int[][] initArr0 = {
                {1, 2},
                {3, 4}
        };
        int[][] initArr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] initArr1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        int[][] initArr2 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}
        };

        int[][] initArr3 = {{1}};

        int[][] initArr4 = {{}};

//        int[][] resultArr = MatrixHelixMorph.helix(initArr);
//        int[][] resultArr = MatrixHelixMorph.helix(initArr1);
//        int[][] resultArr = MatrixHelixMorph.helix(initArr2);
//        int[][] resultArr = MatrixHelixMorph.helix(initArr3);
//        int[][] resultArr = MatrixHelixMorph.helix(initArr4);
        int[][] resultArr = MatrixHelixMorph.helix(initArr0);
        int X = resultArr.length;
        int Y = resultArr[0].length;
        for (int i = 0; i < X; i++ ) {
            for (int j = 0; j < Y; j++ ) {
                System.out.print(resultArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}