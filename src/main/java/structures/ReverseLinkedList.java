package structures;

/**
 * Created by azee on 14.01.15.
 */
public class ReverseLinkedList {

    public static void main(String... args) {
        Node node = build();
        print(node);
        System.out.println();
        print(reverse(node));
    }

    public static Node reverse(Node node){
        Node prev = null;
        while (node != null){
            Node oldNext = node.next;
            node.next = prev;
            prev = node;
            if (oldNext == null){
                return node;
            }
            node = oldNext;
        }
        return null;
    }

    public static Node reverseRecursive(Node n, Node p){
        if(n == null) return null;
        if(n.next == null){ //if this is the end of the list, then this is the new head
            n.next = p;
            return n;
        }
        Node r = reverseRecursive(n.next, n);  //call reverse for the next node,
        //using yourself as the previous node
        n.next = p;                     //Set your next node to be the previous node
        return r;                     //Return the head of the new list
    }

    public static Node build(){
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        Node head = new Node(0, node1);
        return head;
    }

    public static void print (Node node){
        while (node != null){
            System.out.print(node.x);
            node = node.next;
        }
    }

    static class Node{
        int x;
        Node next;

        public Node(int x, Node next){
            this.x = x;
            this.next = next;
        }
    }

}
