package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/11/13
 * Time: 4:42 PM
  */
public class BFS {

    public static void main(String ...args){
        Node head = new Node("Top");
        head.getChildren().add(new Node("Child 1"));

        Node child2 = new Node("Child 2");
        child2.getChildren().add(new Node("Child 2 - 1"));

        Node child2_2 = new Node("Child 2 - 2");
        child2_2.getChildren().add(new Node("Child 2 - 2 - 1"));
        child2_2.getChildren().add(new Node("Child 2 - 2 - 2"));
        child2_2.getChildren().add(new Node("Child 2 - 2 - 3"));
        child2.getChildren().add(child2_2);
        head.getChildren().add(child2);

        head.getChildren().add(new Node("Child 3"));
        bfs(head);
    }

    static void bfs(Node top){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(top);
        while (!queue.isEmpty()){
            if (!queue.isEmpty()) top = queue.poll();
            System.out.println(top);
            for (Node child : top.getChildren()){
                queue.add(child);
            }
        }
    }

    public static class Node{
        List<Node> children;
        String name;

        public Node(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Node> getChildren() {
            if (children == null){
                children = new ArrayList<Node>();
            }
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
