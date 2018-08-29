public class ReverseLinkedList {

    static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    public static void main(String... args){

        Node head = new Node("HEAD");

        Node one = new Node("1");
        head.next = one;

        Node two = new Node("2");
        one.next = two;

        Node three = new Node("3");
        two.next = three;

        printaAll(head);
        System.out.println("");
        printaAll(reverse(head, null));
    }

    private static Node reverse(Node head, Node futureNext) {
        Node next;
        while(head != null && head.next != null){
            next = head.next;
            head.next = futureNext;
            futureNext = head;
            head = next;
        }
        head.next = futureNext;
        return head;
    }

    public static void printaAll(Node head){
        while (head != null){
            System.out.print(head.value);
            head = head.next;
        }
    }

}
