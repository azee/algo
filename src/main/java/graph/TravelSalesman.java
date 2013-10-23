package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/23/13
 * Time: 6:13 PM
 */
public class TravelSalesman {

    public static void main(String ...args){
        Node head = new Node(1, 37.7768016, -122.4169151);
        double minPath = Double.MAX_VALUE;
        List<Node> nodes = new LinkedList<Node>();
        List<Node> bestPath = new LinkedList<Node>();

        nodes.add(new Node(2, 37.7860105, -122.4025377));
        nodes.add(new Node(3, 37.7821494, -122.4058960));
        nodes.add(new Node(4, 37.7689269, -122.4029053));
        nodes.add(new Node(5, 37.7768800, -122.3911496));
        nodes.add(new Node(6, 37.7706628, -122.4040139));
        //nodes.add(new Node(7, 37.7870361, -122.4039444));
        //nodes.add(new Node(8, 37.7507903, -122.3877184));
        //nodes.add(new Node(9, 37.7914417, -122.3927229));
        //nodes.add(new Node(10, 37.8672841, -122.5010216));

        List<List<Node>> result = permutate(nodes);

        for(List<Node> nodesList : result){
            List<Node> listWithHead = new LinkedList<Node>();
            listWithHead.add(head);
            listWithHead.addAll(nodesList);
            Double fullPath = countPath(listWithHead);
            if (fullPath < minPath){
                minPath = fullPath;
                bestPath = listWithHead;
            }
        }
        printList(bestPath);
    }

    public static double countPath(List<Node> nodes){
        double result = 0;
        for(int i = 0; i < nodes.size() - 1; i++){
            result = result + countDistance(nodes.get(i), nodes.get(i + 1));
        }
        return result;
    }

    public static List<List<Node>> permutate(List<Node> nodes){
        List<List<Node>> result = new LinkedList<List<Node>>();

        if (nodes.size() == 1){
            List<Node> singleNode = new LinkedList<Node>();
            singleNode.addAll(nodes);
            result.add(singleNode);
            return result;
        }

        for(int i = 0; i < nodes.size(); i++){
            Node currNode = nodes.get(i);
            for(List<Node> gotNodes : permutate(copyListRmEl(nodes, i))){
                List<Node> gotNodesList = new LinkedList<Node>();
                gotNodesList.add(currNode);
                gotNodesList.addAll(gotNodes);
                result.add(gotNodesList);
            }
        }
        return result;

    }

    public static class Node{
        double x;
        double y;
        int id;

        public Node(int id, double x, double y) {
            this.x = x;
            this.y = y;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

    }

    public static List<Node> copyListRmEl(List<Node> input, int element){
        List<Node> output = new LinkedList<Node>();
        for (int i = 0; i < input.size(); i++){
            if (i != element){
                Node oldNode = input.get(i);
                Node newNode = new Node(oldNode.getId(), oldNode.getX(), oldNode.getY());
                output.add(newNode);
            }
        }
        return output;
    }

    public static double countDistance(Node from, Node to){
        double xDist = Math.abs(Math.abs(to.getX()) - Math.abs(from.getX()));
        double yDist = Math.abs(Math.abs(to.getY()) - Math.abs(from.getY()));
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }

    public static void printList(List<Node> nodes){
        for(Node node : nodes){
            System.out.println(node.getId());
        }
    }
}
