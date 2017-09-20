import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by azee on 05.12.16.
 */
public class AmzUniqueGroups {
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
}
