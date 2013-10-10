package structures;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 8:45 PM
 */

/**
 * Keep data in a queue.
 */
public class LruCache {
    int maxSize;
    List<Integer> values = new LinkedList<Integer>();

    public LruCache(int maxSize) {
        this.maxSize = maxSize;
    }

    public synchronized void put(Integer value){
        if (values.size() == maxSize){
            values.remove(0);
        }
        values.add(value);
    }

    public synchronized void get(int index){
        Integer toMove = values.get(index);
        values.remove(index);
        values.add(toMove);
    }


}
