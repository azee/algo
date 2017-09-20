package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/11/13
 * Time: 4:28 PM
 */

public class DFS {

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

        dfs(head);
    }

    //Recursion
    public static void dfs(Node node){
        System.out.println(node);
        for (Node child : node.getChildren()){
            dfs(child);
        }
    }

    //Using stack is for binary only
//    public static void dfsStack(Node top){
//        Stack<Node> stack = new Stack<Node>();
//        while (top != null || !stack.empty()){
//            if (!stack.empty()){
//                top = stack.pop();
//            }
//            while (top != null){
//                System.out.println(top);
//                if (top.right != null) stack.push(top.right);
//                top=top.left;
//            }
//        }
//    }

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
