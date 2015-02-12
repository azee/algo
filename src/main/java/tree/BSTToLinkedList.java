package tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by azee on 14.01.15.
 */
public class BSTToLinkedList {

    public static void main(String... args) {
        inorder(buildTree());
        flattenInorder(buildTree());
        printList(head);
        System.out.println();
        printList(nodes);
    }

    static Node prev = null;
    static Node head = null;
    static void flattenInorder(TreeNode root) {
        if (root == null) return;
        flattenInorder(root.left);
        Node node = new Node(root.x);
        if (head == null) head = node;
        if (prev != null) {
            prev.next = node;
        }
        prev = node;
        flattenInorder(root.right);
    }

    public static LinkedList<Node> nodes = new LinkedList<>();
    public static void inorder(TreeNode root) {
        if (root == null){
            return;
        }
        inorder(root.left);
        nodes.add(new Node(root.x));
        inorder(root.right);
    }


    static class TreeNode{
        public TreeNode(int x) {
            this.x = x;
        }

        TreeNode left;
        TreeNode right;
        int x;
    }

    static TreeNode buildTree(){
        TreeNode head = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode six = new TreeNode(6);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);


        head.left = two;
        head.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = eight;
        eight.right = nine;
        return head;
    }

    static void printList(Node node){
        int counter = 0;
        while (node != null  && counter < 30){
            System.out.print(node.x + " ");
            node = node.next;
            counter++;
        }
    }

    static void printList(List<Node> nodes){
        for (Node node : nodes){
            System.out.print(node.x + " ");
        }
    }

    static class Node{
        Node next;
        int x;
        Node(int x){
            this.x = x;
        }
    }
}

