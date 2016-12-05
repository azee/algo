import javafx.beans.binding.IntegerExpression;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * Created by azee on 24.05.16.
 */
public class Main {

    interface CustomerPurchase {
        String getCustomerId();
        String getProductCategory();
    }

    public static void main(String[] args) {
        List<CustomerPurchase> customerPurchases = new LinkedList<>();
        customerPurchases.add(_createCustomerPurchase("A Book"));
        customerPurchases.add(_createCustomerPurchase("A Pet"));
        customerPurchases.add(_createCustomerPurchase("B Pet"));
        customerPurchases.add(_createCustomerPurchase("C Pet"));
//        customerPurchases.add(_createCustomerPurchase("C Book"));


        System.out.print(countExclusiveCustomers(customerPurchases));
    }

    private static CustomerPurchase _createCustomerPurchase(String line) {
        final String[] split = line.split(" ");
        if (split.length != 2) {
            return null;
        }
        return new CustomerPurchase() {
            @Override
            public String getCustomerId() {
                return split[0];
            }

            @Override
            public String getProductCategory() {
                return split[1];
            }
        };
    }

    static int countExclusiveCustomers(List<CustomerPurchase> customerPurchases) {
        Map<String, Set<String>> usersGroups = new HashMap<>();
        customerPurchases.forEach(customerPurchase -> {
            if (!usersGroups.containsKey(customerPurchase.getCustomerId())){
                usersGroups.put(customerPurchase.getCustomerId(), new HashSet<>());
            }
            usersGroups.get(customerPurchase.getCustomerId()).add(customerPurchase.getProductCategory());
        });

        Map<Object, Long> counter = usersGroups.entrySet().stream()
                .filter(usersGroupsList -> usersGroupsList.getValue().size() == 1)
                .collect(java.util.stream.Collectors.groupingBy(entry -> entry.getValue(), Collectors.counting()));
        if (counter.size() == 0){
            return 0;
        }

        long max = counter
                .values().stream()
                .max(Comparator.naturalOrder())
                .get();

        return Math.toIntExact(max);
    }

























































//    public static void main(String[] args) {
//
//
//
//    Map<String, String> vals = new HashMap<>();
//        vals.put("aa", "bb");
//        vals.remove("dd");

//        System.out.println(getDate(20));

//        Set<String> str = new HashSet<>();
//        str.add(null);
//        str.add("aaa");
//        Set<String> str2 = new HashSet<>();
//        str2.addAll(str);
//        System.out.print(str2);
//        str2.remove("ss");


//        String s = "add";
//        Map<Character, String> data = new HashMap<>();
//        data.put(s.charAt(0), "a");
//        data.put(s.charAt(0), "1");
//        data.put(s.toCharArray()[0], "1");
//        System.out.println(data.size());
//
//
//    }


    private static String getDate (int cuntDay){
        Date date = new Date();
        date.setTime(date.getTime() + cuntDay * 24 * 60 * 60 * 1000);
        return new SimpleDateFormat("MM/dd/yyyy").format(date);
    }



//    public static void maai(){
//        Map<String,Object> map = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        sb.append("One");
//        map.put("1",sb);
//        sb.setLength(0);
//        sb.append("Two");
//        map.put("2",sb);
//        sb.setLength(0);
//        sb.append("Four");
//        map.put("3",sb);
//        System.out.println(map.get("3").equals("Four") ? map.get("2") : "Not valid");
//    }





//    /**
//     * Adds a watcher to all of the supplied issues.
//     * <p/>
//     * If there is partial success, the issues which we can modify will
//     * be modified and the ones we cannot will be returned in an ArrayList.
//     *
//     * @param issues the list of issues to update
//     * @param currentUser the user to run the operation as
//     * @param watcher the watcher to add to the issues
//     * @return an ArrayList<Issue> containing the issues that could not be modified
//     */
//
//    public ArrayList<Issue> addWatcherToAll(final ArrayList<Issue> issues, final User currentUser, final User watcher)
//    {
//        ArrayList<Issue> successfulIssues = new ArrayList<Issue> ();
//        ArrayList<Issue> failedIssues = new ArrayList<Issue> ();
//        for (Issue issue : issues) {
//            if (canWatchIssue(issue, currentUser, watcher)){
//                successfulIssues.add (issue);
//            }
//            else{
//                failedIssues.add (issue);
//            }
//        }
//        if (successfulIssues.isEmpty()){//<------------------- здесь - первая бага
//            watcherManager.startWatching (currentUser, successfulIssues);
//        }
//        return failedIssues;
//    }
//
//    private boolean canWatchIssue (Issue issue, User currentUser, User watcher){
//        if (currentUser.equals(watcher) || currentUser.getHasPermissionToModifyWatchers()){
//            return issue.getWatchingAllowed(watcher);//<------------------- здесь - вторая бага
//        }
//        return true;//<------------------- здесь - вторая бага
//    }
//
//
//
//    public TestAddWatchers (){
//        User user = new User ("admin");
//        user.setHasPermissionToModifyWatchers (true);
//        Issue goodIssue = new Issue ("Test 1");
//        Issue badIssue = new Issue ("Test 2");
//        goodIssue.setWatchingAllowed (user, true);
//        badIssue.setWatchingAllowed (user, false);
//        ArrayList<Issue> issues = new ArrayList<Issue> ();
//        issues.add (goodIssue);
//        issues.add (badIssue);
//        // Assert that we pass two issues into the function
//        assertEquals (issues.size(), 2);
//        ArrayList<Issue> result = addWatcherToAll (issues, user, user);
//        // Assert that only one issue failed to be updated
//        assertEquals (result.size(), 1);
//    }
//
//    public static class Issue{
//
//    }
//



}
