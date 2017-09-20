package matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/17/13
 * Time: 4:15 PM
  */
public class SpiralMatrix {
    public static void main(String ...args){
        List<List<String>> matrix = prepareMatrix(3, 3, "1 2 3 4 5 6 7 8 9");
        List<List<String>> matrix2 = prepareMatrix(3, 4, "1 2 3 4 5 6 7 8 9 10 11 12");
        List<List<String>> matrix3 = prepareMatrix(4, 3, "1 2 3 4 5 6 7 8 9 10 11 12");
        List<List<String>> matrix4 = prepareMatrix(1, 3, "1 2 3");
        List<List<String>> matrix5 = prepareMatrix(3, 1, "1 2 3");
        List<List<String>> matrix6 = prepareMatrix(6, 3, "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18");

        System.out.println(matrix);
        drawLayer(matrix, 0, 0, matrix.size() * matrix.get(0).size());
        System.out.println();
        System.out.println();

        System.out.println(matrix2);
        drawLayer(matrix2, 0, 0, matrix2.size() * matrix2.get(0).size());
        System.out.println();
        System.out.println();

        System.out.println(matrix3);
        drawLayer(matrix3, 0, 0, matrix3.size() * matrix3.get(0).size());
        System.out.println();
        System.out.println();

        System.out.println(matrix4);
        drawLayer(matrix4, 0, 0, matrix4.size() * matrix4.get(0).size());
        System.out.println();
        System.out.println();

        System.out.println(matrix5);
        drawLayer(matrix5, 0, 0, matrix5.size() * matrix5.get(0).size());
        System.out.println();
        System.out.println();

        System.out.println(matrix6);
        drawLayer(matrix6, 0, 0, matrix6.size() * matrix6.get(0).size());
        System.out.println();
        System.out.println();

    }

    public static void drawLayer(List<List<String>> matrix, int layerRow, int layerCol, int cells){
        int downRowIndex = matrix.size() - 1 - layerRow;
        int rightColIndex = matrix.get(0).size() - 1 - layerCol;

        //Move all way right
        for(int j = layerCol; j <= rightColIndex; j++){
            System.out.print(matrix.get(layerRow).get(j) + " ");
            cells--;
            if (cells == 0){
                return;
            }
        }

        //Move all way down
        for(int i = layerRow + 1; i <= downRowIndex; i++){
            System.out.print(matrix.get(i).get(rightColIndex) + " ");
            cells--;
            if (cells == 0){
                return;
            }
        }

        //Move all way left
        for(int j = rightColIndex - 1; j >= layerCol; j--){
            System.out.print(matrix.get(downRowIndex).get(j) + " ");
            cells--;
            if (cells == 0){
                return;
            }
        }

        //Move all way up
        for(int i = downRowIndex - 1; i > layerRow; i--){
            System.out.print(matrix.get(i).get(layerCol)  + " ");
            cells--;
            if (cells == 0){
                return;
            }
        }

        drawLayer(matrix, ++layerRow, ++layerCol, cells);
    }

    public static List<List<String>> prepareMatrix(int n, int m, String data){
        List<String> dataList = Arrays.asList(data.split(" "));
        List<List<String>> result = new ArrayList<List<String>>();
        int counter = 0;
        for(int i = 0; i < n; i++){
            List<String> row = new ArrayList<String>();
            for(int j = 0; j < m; j++){
                row.add(dataList.get(counter));
                counter++;
            }
            result.add(row);
        }
        return result;
    }
}
