package tree;

/**
 * Created by azee on 15.01.15.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LCA {

    // IMPORTANT: DO NOT MODIFY THIS CLASS
    public static class Employee {

        private final int id;
        private final String name;
        private List<Employee> reports;

        public Employee(int id, String name) {
            this.id = id;
            this.name = name;
            this.reports = new ArrayList<Employee>();
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<Employee> getReports() {
            return reports;
        }

        public void addReport(Employee employee) {
            reports.add(employee);
        }
    }

    /*
     * Read the attached PDF for more explanation about the problem
     * Note: Don't modify the signature of this function
     * @param ceo
     *
     * @param firstEmployee
     *
     * @param secondEmployee
     *
     * @return common manager for both employees that is closest to them.
     */
    @SuppressWarnings("unused")
    public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
        NodesContainer nodesContainer = new NodesContainer();
        //All operations will take O(2N) operations and O(2N) memory.
        dfsFlattenTree(ceo, 0, nodesContainer, firstEmployee, secondEmployee);
        return lowestCommonAncestor(nodesContainer);
    }

    /*
    We will assume that memory complexity is less important than algorithm complexity.
    It is hard to find a company with more than 20k employees. Memory is cheap and time is priceless.
    We will flatten the tree to the list of objects containing employees and the height of the node.
    Then we will search between firstEmployee and secondEmployee an employee with the smallest height.
    We will flatten the tree for O(N) operations and it will take O(2N) memory.
     */
    private static void dfsFlattenTree(Employee head, int height, NodesContainer container,
                                       Employee firstEmployee, Employee secondEmployee){
        if (head == null || firstEmployee == null || secondEmployee == null){
            return;
        }

        //Store ids in list so we could achieve o(1) - O(N) while searching for common ancestor in list
        if (firstEmployee.getId() == head.getId() || secondEmployee.getId() == head.getId()){
            container.getEmployeeIndex().add(container.getNodes().size());
        }

        //We add ancestor before all and after each descendant
        container.getNodes().add(new Node(head, height));
        for (Employee descendant : head.getReports()) {
            dfsFlattenTree(descendant, height + 1, container, firstEmployee, secondEmployee);
            container.getNodes().add(new Node(head, height));
        }
    }

    /*
    Look for an lca in the list. Will take O(N)
     */
    private static Employee lowestCommonAncestor(NodesContainer container){
        Employee result = null;
        int minHeight = 0;
        if (container.getEmployeeIndex().size() < 2){
            throw new RuntimeException("One of employees was not found in the company");
        }

        for (int i = Collections.min(container.getEmployeeIndex()) + 1;
             i < Collections.max(container.getEmployeeIndex()); i++){
            Node currNode = container.getNodes().get(i);
            if (result == null || minHeight > currNode.getHeight()){
                result = currNode.getEmployee();
                minHeight = currNode.getHeight();
            }
        }
        return result;
    }

    static class NodesContainer{
        List<Integer> employeeIndex;
        List<Node> nodes;

        public List<Integer> getEmployeeIndex() {
            if (employeeIndex == null){
                employeeIndex = new ArrayList<Integer>();
            }
            return employeeIndex;
        }

        public List<Node> getNodes() {
            if (nodes == null){
                nodes = new ArrayList<Node>();
            }
            return nodes;
        }

        public void setNodes(List<Node> nodes) {
            this.nodes = nodes;
        }
    }

    static class Node{
        private Employee employee;
        private int height;

        Node(Employee employee, int height) {
            this.employee = employee;
            this.height = height;
        }

        public Employee getEmployee() {
            return employee;
        }

        public int getHeight() {
            return height;
        }
    }


    //Can't use Junit so I'll just run main and throw exceptions
    public static void main(String[] args) {
        Employee bill = new Employee(1, "Bill");
        Employee dom = new Employee(2, "Dom");
        Employee simar = new Employee(3, "Simar");
        Employee michael = new Employee(4, "Michael");
        Employee bob = new Employee(5, "Bob");
        Employee peter = new Employee(6, "Peter");
        Employee porter = new Employee(7, "Porter");
        Employee milton = new Employee(8, "Milton");
        Employee nina = new Employee(9, "Nina");

        bill.getReports().add(dom);
        bill.getReports().add(simar);
        bill.getReports().add(michael);

        dom.getReports().add(bob);
        dom.getReports().add(peter);
        dom.getReports().add(porter);

        peter.getReports().add(milton);
        peter.getReports().add(nina);

        Employee ccm = closestCommonManager(bill, milton, nina);
        if (ccm != peter){
            throw new RuntimeException("Peter expected");
        }

        ccm = closestCommonManager(bill, nina, porter);
        if (ccm != dom){
            throw new RuntimeException("Dom expected");
        }

        ccm = closestCommonManager(bill, nina, simar);
        if (ccm != bill){
            throw new RuntimeException("Bill expected");
        }

        ccm = closestCommonManager(bill, nina, peter);
        if (ccm != peter){
            throw new RuntimeException("Peter expected");
        }
    }
}

