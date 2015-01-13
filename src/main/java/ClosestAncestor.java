import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/15/13
 * Time: 12:28 AM
 */
public class ClosestAncestor {

    public static void main(String[] args) {
        //Getting input data
        List<String> inputData = new ArrayList<String>();
        List<Node> nodes = new LinkedList<Node>();
        try {
            inputData = getInputData(args[0]);

        } catch (Exception e) {
            System.out.println("Error occurred while reading a file \n" + e.getMessage());
        }

        for (String singleString : inputData){
            nodes.add(prepareNode(singleString));
        }
        calculate(nodes);
    }

    private static Node prepareNode(String singleString) {
        Node result =  new Node();
        String[] firstString = singleString.split("\\|");
        result.setId(Integer.parseInt(firstString[0].trim()));

        String[] secondString = firstString[1].split("\\(");
        String dataString = secondString[1].substring(0, secondString[1].length() - 1);
        String[] coords = dataString.split(",");

        result.setX(Double.parseDouble(coords[0].trim()));
        result.setY(Double.parseDouble(coords[1].trim()));
        return result;
    }

    /**
     * Reads the file into list of strings
     * @return
     * @throws Exception
     */
    private static List<String> getInputData(String filePath) throws Exception {
        List<String> characters = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            String line = br.readLine();
            while (line != null) {
                characters.add(line);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return characters;
    }

    public static void calculate(List<Node> nodes){
        Node head = nodes.get(0);
        nodes.remove(0);
        double minPath = Double.MAX_VALUE;
        List<Node> bestPath = new LinkedList<Node>();
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

        public Node() {
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
