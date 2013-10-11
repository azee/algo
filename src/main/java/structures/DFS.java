package structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/11/13
 * Time: 4:28 PM
 */

public class DFS {

    public static void main(String ...args){
        Node head = new Node();
        head.getChildren().add(new Node());
        head.getChildren().add(new Node());
        //So On... Buld a tree

        dfs(head);

    }

    public static void dfs(Node node){
        System.out.println(node);
        for (Node child : node.getChildren()){
            dfs(child);
        }
    }

    public static class Node{
        List<Node> children;

        public List<Node> getChildren() {
            if (children == null){
                children = new ArrayList<Node>();
            }
            return children;
        }

        public void setChildren(List<Node> children) {
            this.children = children;
        }
    }

}
