package lists;

import java.util.*;

/**
 * Created by azee on 20.09.17.
 */
public class TopValues {
    public static void main(String[] args) {
        System.out.println(top3Queue(1, 2, 7, 99, 4, 5, 12));
        System.out.println(top3Array(1, 2, 7, 99, 4, 5, 12));
    }

    private static List<Integer> top3Queue(int... arr){
        Queue<Integer> queue = new PriorityQueue<>(3, (o1, o2) -> o2.compareTo(o1));
        for(int val : arr){
            queue.add(val);
        }
        List<Integer> result = new ArrayList<>();
        result.add(queue.poll());
        result.add(queue.poll());
        result.add(queue.poll());
        return result;
    }

    private static List<Integer> top3Array(int... arr){
        List<Integer> result = new LinkedList<>();
        Integer min = null;
        for (int val : arr){
            if (min == null){
                min = val;
            }
            if (result.size() < 3){
                result.add(val);
                min = Math.min(val, min);
            } else if (val > min) {
                result.remove(min);
                result.add(val);
                min = findMin(result);
            }
        }
        return result;
    }

    private static Integer findMin(List<Integer> result) {
        Integer min = null;
        for (Integer val : result){
            min = min == null ? val : Math.min(val, min);
        }
        return min;
    }
}
