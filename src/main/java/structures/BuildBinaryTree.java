package structures;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/14/13
 * Time: 5:20 PM
 */

//Build a balanced binary tree from a sorted array
public class BuildBinaryTree {
    public static Node addToTree(int arr[], int start, int end){
        if (end < start) {
            return null;
        }

        //Take a middle element, place it at the head, recurse left and righ and add them as a sub-tree
        int mid = (start + end) / 2;
        Node n = new Node(arr[mid]);

        n.left = addToTree(arr, start, mid - 1);
        n.right = addToTree(arr, mid + 1, end);
        return n;
    }

    public static Node createMinimalBST(int array[]) {
        return addToTree(array, 0, array.length - 1);
    }

    public static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
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
    }


}
