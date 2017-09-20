package structures;

/**
 * Created by azee on 21.01.15.
 */
public class MergeSortLists {

    public static void main(String... args){
        printList(mergeSortList(
                buildList(new int[]{9, 4, 8, 2, 1, 22, 17, 56, 2})
        ));
    }

    public static Node mergeSortList(Node head) {

        if (head == null || head.next == null)
            return head;

        // count total number of elements
        int length = 0;
        Node pointer = head;
        while (pointer != null) {
            length++;
            pointer = pointer.next;
        }

        // break up to two list
        int middle = length / 2;

        Node right = null;
        pointer = head;
        int counter = 0;
        while (pointer != null) {
            counter++;
            Node next = pointer.next;

            if (counter == middle) {
                pointer.next = null;
                right = next;
            }
            pointer = next;
        }

        // now we have two parts l and r, recursively sort them
        Node h1 = mergeSortList(head);
        Node h2 = mergeSortList(right);

        // merge together
        Node merged = merge(h1, h2);

        return merged;
    }

    static Node merge(Node first, Node second){
        Node head = new Node(-1);
        Node storeHead = head;

        while (first != null && second != null){
            if (first.x < second.x){
                head.next = new Node(first.x);
                first = first.next;
            }
            else if (second.x < first.x){
                head.next = new Node(second.x);
                second = second.next;
            }
            else if (second.x == first.x){
                head.next = new Node(first.x);
                first = first.next;
                second = second.next;
            }
            head = head.next;
        }

        if (first != null){
            head.next = first;
        }
        if (second != null){
            head.next = second;
        }

        return storeHead.next;
    }

    static Node buildList(int[] values){
        Node iter = null;
        Node head = null;
        for (int value : values){
            Node node = new Node(value);
            if (iter != null){
                iter.next = node;
            } else {
                head = node;
            }
            iter = node;
        }
        iter.next = null;
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

    static class Node{
        Node next;
        int x;
        Node(int x){
            this.x = x;
        }
    }
}
