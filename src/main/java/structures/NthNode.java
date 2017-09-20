package structures;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/11/13
 * Time: 5:06 PM
  */
public class NthNode {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for(int i: nums){
            q.offer(i);

            if(q.size()>k){
                q.poll();
            }
        }
        return q.peek();
    }

    public static Node walkTheTree(Node start, int steps){
        boolean fromRight = true;
        Node shuttle = start;
        Node holder;
        if (shuttle.right != null){
            shuttle = shuttle.right;
            while (shuttle.left != null) {
                shuttle = shuttle.left;
            }
            fromRight = false;
        }
        int counter = 0;
        do{
            while (true){
                if (!fromRight && ++counter == steps) return shuttle;
                if (!fromRight && shuttle.right != null){
                    shuttle = shuttle.right;
                    break;
                }
                holder = shuttle;
                shuttle = shuttle.parent;
                fromRight = (holder == shuttle.right);
            }
            while (shuttle.left != null) shuttle = shuttle.left;
        }while (true);
    }


    public static class Node{
        Node left;
        Node right;
        Node parent;
        String name;

        public Node(String name, Node parent) {
            this.name = name;
            this.parent = parent;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
