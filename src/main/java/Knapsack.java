import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/*
Place maximum objects in package with maximum cost. If the cost is the same - use package with the lowest weight

Input example:
81 : (1,53.38,$45) (2,88.62,$98) (3,78.48,$3) (4,72.30,$76) (5,30.18,$9) (6,46.34,$48)
8 : (1,15.3,$34)
75 : (1,85.31,$29) (2,14.55,$74) (3,3.98,$16) (4,26.24,$55) (5,63.69,$52) (6,76.25,$75) (7,60.02,$74) (8,93.18,$35) (9,89.95,$78)
56 : (1,90.72,$13) (2,33.80,$40) (3,43.15,$10) (4,37.97,$16) (5,46.81,$36) (6,48.77,$79) (7,81.80,$45) (8,19.36,$79) (9,6.76,$64)

MAX_WEIGHT : (ITEM_INDEX,ITEM_WEIGHT,$ITEM_COST)

Output: indexes:
4
-
2,7
8,9
 */
/**
 * Created by azee on 29.12.15.
 */
public class Knapsack {
    public static void main(String[] args) throws Exception {
        List<Task> tasks = getInputData(args[0]);
        for (Task task : tasks){
            performTask(task);
        }
    }

    private static void performTask(Task task) {
        List<List<Package>> packagesList = new LinkedList<>();
        preformTask(task, packagesList);
        float maxCost = 0;
        List<Package> maxCostPackages = new LinkedList<>();
        for (List<Package> packages : packagesList){
            float cost = totalCost(packages);
            if(cost > maxCost || (cost == maxCost && totalWeight(packages) < totalWeight(maxCostPackages))){
                maxCost = cost;
                maxCostPackages = packages;
            }
        }
        printPackages(maxCostPackages);
    }

    private static void printPackages(List<Package> maxCostPackages) {
        if (maxCostPackages == null || maxCostPackages.size() == 0){
            System.out.println("-");
            return;
        }
        Collections.sort(maxCostPackages, new Comparator<Package>() {
            @Override
            public int compare(Package o1, Package o2) {
                return new Integer(o1.getIndex()).compareTo(o2.getIndex());
            }
        });

        String values = "";
        for(Package aPackage : maxCostPackages){
            values += aPackage.getIndex() + ",";
        }
        System.out.println(values.substring(0, values.length() - 1));
    }

    private static void preformTask(Task task, List<List<Package>> packagesList) {
        performTask(task, new LinkedList<Package>(), new LinkedList<Package>(task.getPackages()), packagesList);
    }

    private static void performTask(Task task, List<Package> packages, List<Package> remaining, List<List<Package>> packagesList) {
        for(int i = 0; i < remaining.size(); i++){
            if (totalWeight(packages) + remaining.get(i).getWeight() <= task.getWeightLimit()){
                LinkedList<Package> newRemaining = new LinkedList<>(remaining);
                LinkedList<Package> newPackages = new LinkedList<>(packages);
                newPackages.add(newRemaining.remove(i));
                performTask(task, newPackages, newRemaining, packagesList);
            } else {
                packagesList.add(packages);
            }
        }
        return;
    }

    private static float totalWeight(List<Package> packages) {
        float result = 0;
        for (Package aPackage : packages){
            result += aPackage.getWeight();
        }
        return result;
    }

    private static float totalCost(List<Package> packages) {
        float result = 0;
        for (Package aPackage : packages){
            result += aPackage.getCost();
        }
        return result;
    }

    private static List<Task> getInputData(String filePath) throws Exception {
        List<Task> tasks = new ArrayList<Task>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        try {
            String line = br.readLine();
            while (line != null) {
                tasks.add(transform(line));
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        return tasks;
    }

    private static Task transform(String line) {
        Task task = new Task(Float.parseFloat(line.split(":")[0]));

        String inBracetsBlock = line.split(":")[1].trim();
        for(String singlePack : inBracetsBlock.split("\\(")){
            if (!"".equals(singlePack.trim())){
                singlePack = singlePack.replace(")", "").trim();
                String[] values = singlePack.split(",");
                Package aPackage = new Package(
                        Integer.parseInt(values[0]),
                        Float.parseFloat(values[1]),
                        Float.parseFloat(values[2].replace("$", "")));
                task.getPackages().add(aPackage);
            }
        }
        return task;
    }

    static class Package {
        int index;
        float weight;
        float cost;

        public Package(int index, float weight, float cost) {
            this.index = index;
            this.weight = weight;
            this.cost = cost;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public float getCost() {
            return cost;
        }

        public void setCost(float cost) {
            this.cost = cost;
        }
    }

    static class Task{
        List<Package> packages = new LinkedList<>();
        float weightLimit;

        public Task(float weightLimit) {
            this.weightLimit = weightLimit;
        }

        public float getWeightLimit() {
            return weightLimit;
        }

        public void setWeightLimit(float weightLimit) {
            this.weightLimit = weightLimit;
        }

        public List<Package> getPackages() {
            return packages;
        }
    }
}
