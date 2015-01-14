

/**
 * Created by azee on 22.12.14.
 */
public class Main {
    public static void main(String... args) {
        Node node = build();
        print(node);
        System.out.println();
        print(reverse(node, null));
    }

    public static Node reverse(Node node, Node prev){
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
