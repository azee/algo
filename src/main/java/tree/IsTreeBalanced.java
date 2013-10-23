package tree;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/14/13
 * Time: 5:12 PM
  */
public class IsTreeBalanced {
    //Iterate all way down left and right and add + at every node
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    //Iterate all way down left and right and add + at every node
    public static int minDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static boolean isBalanced(Node root){
        return (maxDepth(root) - minDepth(root) <= 1);
    }

    public static class Node{
        Node left;
        Node right;

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
    }

}
