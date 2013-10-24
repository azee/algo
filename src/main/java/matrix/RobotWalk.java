package matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/24/13
 * Time: 2:54 PM
  */

//A robot is located at the top-left corner of a 4x4 grid. The robot can move either up,
// down, left, or right, but can not visit the same spot twice. The robot is trying to
// reach the bottom-right corner of the grid.
//Print out the unique number of ways the robot can reach its destination.
public class RobotWalk {
    static long nWays = 0;
    static final int MAX_INDEX = 3;

    public static void main(String ...args){
        walk(0, 0, new HashSet<String>());
        System.out.println(nWays);
    }

    public static void walk(int currX, int currY, Set<String> visited){
        String id = getId(currX, currY);
        if (currX < 0 || currY < 0 || currX > MAX_INDEX || currY > MAX_INDEX || visited.contains(id)){
            return;
        }
        visited.add(id);
        //Right
        walk(currX + 1, currY, visited);

        //Left
        walk(currX - 1, currY, visited);

        //Up
        walk(currX, currY + 1, visited);

        //Down
        walk(currX, currY - 1, visited);

        if(currX == MAX_INDEX && currY == MAX_INDEX){
            nWays++;
        }

        visited.remove(id);
    }

    public static String getId(int x, int y){
        return x + ":" + y;
    }
}
