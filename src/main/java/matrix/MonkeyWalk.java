package matrix;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/16/13
 * Time: 6:02 PM
  */

//There is a monkey which can walk around on a planar grid.
// The monkey can move one space at a time left, right, up or down.
// That is, from (x, y) the monkey can go to (x+1, y), (x-1, y), (x, y+1), and (x, y-1).
// Points where the sum of the digits of the absolute value of the x coordinate plus the
// sum of the digits of the absolute value of the y coordinate are lesser than or equal
// to 19 are accessible to the monkey. For example, the point (59, 79) is inaccessible
// because 5 + 9 + 7 + 9 = 30, which is greater than 19. Another example: the point (-5, -7) is accessible
// because abs(-5) + abs(-7) = 5 + 7 = 12, which is less than 19. How many points
// can the monkey access if it starts at (0, 0), including (0, 0) itself?
public class MonkeyWalk {

    public static void main(String ...args){
        Set<String> visited = new HashSet<String>();
        walk(0, 0, visited);
        System.out.println(visited.size());
    }

    public static void walk(int x, int y, Set<String> visited){
        if (isAccessible(x, y) && !visited.contains(Integer.toString(x) + "-" + Integer.toString(y))){
            visited.add(Integer.toString(x) + "-" + Integer.toString(y));

            //Right
            walk(x + 1, y, visited);

            //Left
            walk(x - 1, y, visited);

            //Up
            walk(x, y + 1, visited);

            //Down
            walk(x, y - 1, visited);
        }

        return;
    }

    public static boolean isAccessible(int x, int y){
        int sum = 0;
        char[] xChars = Integer.toString(Math.abs(x)).toCharArray();
        char[] yChars = Integer.toString(Math.abs(y)).toCharArray();

        for(char singleChar : xChars){
            sum = sum + Integer.parseInt(Character.toString(singleChar));
        }
        for(char singleChar : yChars){
            sum = sum + Integer.parseInt(Character.toString(singleChar));
        }

        if(sum > 19){
            return false;
        }
        return true;
    }

////Memory Optimisation
//    public static void main(String ...args){
//        Map<String, Cell> visited = new HashMap<String, Cell>();
//        walk(0, 0, visited);
//
//        int valuesToReduce = visited.size();
//
//        int zeroCounter = 0;
//        for(String key : visited.keySet()){
//            Cell found = visited.get(key);
//            if(found.getX() == 0 || found.getY() == 0){
//                zeroCounter ++;
//            }
//        }
//        System.out.println((valuesToReduce - zeroCounter) * 4 + (zeroCounter - 1) * 2 + 1);
//    }
//
//    public static void walk(int x, int y, Map<String, Cell> visited){
//        if (isAccessible(x, y) && !visited.containsKey(Integer.toString(x) + "-" + Integer.toString(y))){
//            visited.put(Integer.toString(x) + "-" + Integer.toString(y), new Cell(x, y));
//            //Right
//            walk(x + 1, y, visited);
//
//            //Up
//            walk(x, y + 1, visited);
//        }
//
//        return;
//    }
//
//    public static boolean isAccessible(int x, int y){
//        int sum = 0;
//        char[] xChars = Integer.toString(Math.abs(x)).toCharArray();
//        char[] yChars = Integer.toString(Math.abs(y)).toCharArray();
//
//        for(char singleChar : xChars){
//            sum = sum + Integer.parseInt(Character.toString(singleChar));
//        }
//        for(char singleChar : yChars){
//            sum = sum + Integer.parseInt(Character.toString(singleChar));
//        }
//
//        if(sum > 19){
//            return false;
//        }
//        return true;
//    }
//
//    static class Cell{
//        int x;
//        int y;
//
//        Cell(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        int getX() {
//            return x;
//        }
//
//        void setX(int x) {
//            this.x = x;
//        }
//
//        int getY() {
//            return y;
//        }
//
//        void setY(int y) {
//            this.y = y;
//        }
//    }

}
