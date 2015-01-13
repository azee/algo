package tree;

import java.util.ArrayList;

/**
 * Created by azee on 14.01.15.
 */
public class BSTToLinkedList {
    public DoubleNode tree2Double(TreeNode root) {
        ArrayList<DoubleNode> nodes = new ArrayList<DoubleNode>();
        return this.preOrder(root, nodes);
    }

    public DoubleNode preOrder(TreeNode root, ArrayList<DoubleNode> nodes) {
        DoubleNode dn = new DoubleNode(root);
        DoubleNode curr = dn;
        nodes.add(dn);
        if (root.left != null) {
            DoubleNode next = this.preOrder(root.left, nodes);
            dn.next = next;
            next.prev = dn;
            curr = dn.next;
        }
        if (root.right != null) {
            DoubleNode next = this.preOrder(root.right, nodes);
            curr.next = next;
            next.prev = curr;
        }
        return dn;

    }

    class DoubleNode{
        DoubleNode next;
        DoubleNode prev;
        int x;

        public DoubleNode(TreeNode treeNode){
            x = treeNode.x;
        }
    }

    class TreeNode{
        TreeNode left;
        TreeNode right;
        int x;
    }
}

