package structures;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/10/13
 * Time: 8:32 PM
  */

/**
 * The idea is like in car racing.
 * We have 2 cars, one is racing with the speed twice bigger than another.
 * When the fast one will be at the end the slow one will be in the middle of it's way
 */
public class FindMiddleNode {

    public void findMiddleNode() {
        Node headNode = new Node();
        headNode.setNext(new Node());
        /// ... and so on - form a list

        Node n1 = headNode;
        Node n2 = headNode;
        while(n2.getNext() != null && n2.getNext().getNext()!= null) {
            n1 = n1.getNext();
            n2 = n2.getNext().getNext();
        }

        System.out.println("middle node is "+ n1);
    }

    private class Node{
        Node nextNode;

        private Node getNext() {
            return nextNode;
        }

        private void setNext(Node nextNode) {
            this.nextNode = nextNode;
        }
    }

}
