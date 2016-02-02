import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by azee on 02.02.16.
 */
public class BinarySearchArray {
    public static void main(String[] args)
    {
        Integer[] data = {7, 4, 5, 1, 9, 10, -1, 0};
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
        System.out.println(findIndex(data, -1, data.length/2));
        System.out.println(findIndex(data, 0, data.length/2));
        System.out.println(findIndex(data, 1, data.length/2));
        System.out.println(findIndex(data, 4, data.length/2));
        System.out.println(findIndex(data, 5, data.length/2));
        System.out.println(findIndex(data, 7, data.length/2));
        System.out.println(findIndex(data, 9, data.length/2));
        System.out.println(findIndex(data, 10, data.length/2));
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
