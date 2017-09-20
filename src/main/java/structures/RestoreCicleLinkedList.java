package structures;

/**
 * Created by azee on 21.01.15.
 */
public class RestoreCicleLinkedList {

    public static void main(String... args){
        printList(restoreCicle(buildCicle()));
    }


    static Node restoreCicle(Node head){
        if (head == null || head.next == null || head.next.next == null){
            return head;
        }

        Node slow = head;
        Node fast = head;
        Node prev = head;

        while (fast != null && fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
            if (slow == fast){
                break;
            }
        }

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
            prev = prev.next;
        }
        prev.next = null;

        return head;
    }


    static Node buildCicle(){
        Node head = new Node(-1);
        Node iter = head;
        for (int i = 0; i <= 10; i++){
            iter.next = new Node(i);
            iter = iter.next;
        }

        Node chain = head;
        for (int i = 0; i <= 3; i++){
            chain = chain.next;
        }

        iter.next = chain;
        return head;
    }

    static void printList(Node node){
        int counter = 0;
        while (node != null  && counter < 30){
            System.out.print(node.x);
            node = node.next;
            counter++;
        }
    }

    static class Node{
        Node next;
        int x;
        Node(){};
        Node(int x){
            this.x = x;
        }
    }
}
