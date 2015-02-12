package structures;

/**
 * Created by azee on 21.01.15.
 */
public class MergetwoSortedLists {

    public static void main(String... args){
        printList(merge(
                buildList(new int[]{1, 3, 4, 5, 7, 10, 11, 12}),
                buildList(new int[]{1, 2, 3, 6, 8, 9})
        ));
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
