import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by azee on 02.02.16.
 */
public class BinarySearchArray {
    public static void main(String[] args)
    {
        Integer[] data = {7, 4, 5, 1, 9, 10, -1, 0, 25, 35};
        List<Integer> dataList = Arrays.asList(data);
        Collections.sort(dataList);
        System.out.println(find(dataList, -1));
        System.out.println(find(dataList, 0));
        System.out.println(find(dataList, 7));
        System.out.println(find(dataList, 4));
        System.out.println(find(dataList, 5));
        System.out.println(find(dataList, 1));
        System.out.println(find(dataList, 9));
        System.out.println(find(dataList, 10));
        //System.out.println(find(dataList, 101));
        /////////////////////
        System.out.println();
        System.out.println();
        /////////////////////
        System.out.println(findIndex(data, -1, data.length/2));
        System.out.println(findIndex(data, 0, data.length/2));
        System.out.println(findIndex(data, 1, data.length/2));
        System.out.println(findIndex(data, 4, data.length/2));
        System.out.println(findIndex(data, 5, data.length/2));
        System.out.println(findIndex(data, 7, data.length/2));
        System.out.println(findIndex(data, 9, data.length/2));
        System.out.println(findIndex(data, 10, data.length/2));

        /////////////////////
        System.out.println();
        System.out.println();
        /////////////////////
        System.out.println(findIndex(data, -1, 0, data.length - 1));
        System.out.println(findIndex(data, 0, 0, data.length - 1));
        System.out.println(findIndex(data, 1, 0, data.length - 1));
        System.out.println(findIndex(data, 4, 0, data.length - 1));
        System.out.println(findIndex(data, 5, 0, data.length - 1));
        System.out.println(findIndex(data, 7, 0, data.length - 1));
        System.out.println(findIndex(data, 9, 0, data.length - 1));
        System.out.println(findIndex(data, 10, 0, data.length - 1));


        /////////////////////
        System.out.println();
        System.out.println();
        /////////////////////
        System.out.println(findClosestIndex(data, -1, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 0, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 1, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 4, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 5, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 7, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 9, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 10, 0, data.length - 1));
        System.out.println(findClosestIndex(data, 39, 0, data.length - 1));
    }

    public static int findClosestIndex(Integer[] data, int toSearch, int left, int right){
        int median = (left + right) / 2;
        while (left <= right){
            if (data[median] > toSearch){
                return findClosestIndex(data, toSearch, left, --median);
            } else {
                return findClosestIndex(data, toSearch, ++median, right);
            }
        }
        return median;
    }

    public static int findIndex(Integer[] data, int toSearch, int left, int right){
        while (left <= right){
            int median = (left + right) / 2;
            if (data[median] == toSearch){
                return median;
            }
            if (data[median] > toSearch){
                return findIndex(data, toSearch, left, --median);
            } else {
                return findIndex(data, toSearch, ++median, right);
            }
        }
        throw new RuntimeException("Not found");
    }

    public static int findIndex(Integer[] data, int toSearch, int currIndex){
        if (currIndex < 0 || currIndex > data.length - 1){
            throw new RuntimeException("Not found");
        }

        int median = data[currIndex];
        if (median == toSearch){
            return currIndex;
        }

        int range = Math.min(data.length - currIndex, currIndex)/2;
        range = Math.max(1, range);

        return median > toSearch ? findIndex(data, toSearch, currIndex - range) :
                findIndex(data, toSearch, currIndex + range);
    }


    public static int find(List<Integer> data, int toSearch){
        if (data.size() == 0){
            throw new RuntimeException("Not found");
        }
        int val = data.get(data.size()/2);

        if (toSearch == val){
            return val;
        }
        return toSearch > val ? find(data.subList(data.size()/2 + 1, data.size()), toSearch) :
                find(data.subList(0, data.size()/2), toSearch);

    }
}
