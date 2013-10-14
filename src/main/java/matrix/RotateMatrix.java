package matrix;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/14/13
 * Time: 2:37 PM
 */
public class RotateMatrix {
    public static void rotate(int[][] matrix) {

        //Loop through all edges line by line reducing the matrix
        for (int layer = 0; layer < matrix.length / 2; ++layer) {
            //Define the layer size
            int first = layer;
            int last = matrix.length - 1 - layer;

            //Move all cells to its new position
            for(int i = first; i < last; ++i) {

                //Adjust offset
                int offset = i - first;

                //Save one value to restore it after shifting
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
    }

    public static void main(String ...args){
        rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    public static void printMatrix(int[][] matrix){
        for(int[] layer : matrix){
            for(int value : layer){
                System.out.println(value + " ");
            }
            System.out.println();
        }
    }
}

