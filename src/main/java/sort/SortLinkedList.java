package sort;

/**
 * Created by azee on 08.09.16.
 */
public class SortLinkedList {

    static class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String... args){
        Node head = new Node(7);
        Node node1 = new Node(1);
        Node node2 = new Node(4);
        Node node3 = new Node(0);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        sort(head);

        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static Node sort(Node head){
        int counter = 0;
        Node shuttle = head;
        while (shuttle.next != null){
            counter++;
            shuttle = shuttle.next;
        }

        while (counter != 0){
            shuttle = head;
            while (shuttle.next != null){
                if (shuttle.val > shuttle.next.val){
                    int buf = shuttle.val;
                    shuttle.val = shuttle.next.val;
                    shuttle.next.val = buf;
                }
                shuttle = shuttle.next;
            }
            counter--;
        }
        return head;
    }
}
