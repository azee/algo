package structures;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/13/13
 * Time: 5:13 PM
 */

// O(n^2)

public class PowerSet{

    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        //Using LinkedHashSet to ensure the iteration order

        //Create an output container
        Set<Set<T>> sets = new LinkedHashSet<Set<T>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<T>());
            return sets;
        }

        //Copy original set to a list to be able to manipulate with it as a temporary list
        List<T> list = new ArrayList<T>(originalSet);

        //Getting the first element
        T head = list.get(0);

        //Getting the "tail"
        Set<T> rest = new LinkedHashSet<T>(list.subList(1, list.size()));

        //Get all possible states of the tail
        for (Set<T> set : powerSet(rest)) {
            Set<T> newSet = new LinkedHashSet<T>();

            //Concatinate head with possible tail
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);

            //Add a possible tail to result
            sets.add(set);
        }
        return sets;
    }


    public static void main(String ...args){
        Set<String> mySet = new LinkedHashSet<String>();
        mySet.add("x");
        mySet.add("y");
        mySet.add("z");
        for (Set<String> s : powerSet(mySet)) {
            System.out.println(s);
        }
    }


}
