package sort;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/14/13
 * Time: 5:08 PM
  */

//Sort a stack using another one
public class Sort2Stacks {
    public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while(!s.isEmpty()) {
            int tmp = s.pop();
            while(!r.isEmpty() && r.peek() > tmp) {
                s.push(r.pop());
            }
            r.push(tmp);
        }
        return r;
    }
}
