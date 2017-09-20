import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by azee on 24.05.16.
 */
public class HackerRank {

    public static void main(String... args){
    }

    abstract static class Arithmetic {
        abstract int add(int a,int b);
    }

    public class Adder extends Arithmetic{
        @Override
        int add(int a,int b){
            return a + b;
        }
    }


    static void finalPrice(int[] prices) {
        prices = prices == null ? new int[0] : prices;
        Set<Integer> noDiscount = new TreeSet<>();

        for (int i = 0; i < prices.length; i++){
            int discount = 0;
            for (int j = i + 1; j < prices.length; j++){
                if (prices[j] <= prices[i]){
                    discount = prices[j];
                    break;
                }
            }
            if (discount == 0){
                noDiscount.add(i);
            }
            prices[i] = prices[i] - discount;
        }

        int sum = 0;
        for (int price : prices){
            sum += price;
        }

        System.out.println(sum);

        StringBuilder sb = new StringBuilder();
        for(Integer noDiscPrice : noDiscount){
            sb.append(noDiscPrice);
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static String firstRepeatedWord(String s) {
        Set<String> uniqueWords = new HashSet<>();
        s = s.replaceAll("  ", " ").replaceAll(":", " ").replaceAll(";", " ").replaceAll(",", " ").replaceAll("-", " ").replaceAll("\\.", " ");
        for (String word : s.split(" ")){
            word = word.trim();
            if (!uniqueWords.add(word)){
                return word;
            }
        }
        return "";
    }

    public static void doNothing(String str){
        str = null;
        str = new String("Yohoho2");
        System.out.println(str);
    }




    public static LinkedListNode deleteOdd(LinkedListNode list) {
        if (list.next == null){
            if (list.val % 2 != 0){
                return null;
            } else return (list);
        }

        while(list != null && list.val % 2 != 0){
            list = list.next;
        }

        LinkedListNode shuttle = list;
        while (shuttle.next != null){
            if (shuttle.next.val % 2 != 0){
                shuttle.next = shuttle.next.next;
            } else {
                shuttle = shuttle.next;
            }

        }

        return list;
    }


    public static class LinkedListNode{
        int val;
        LinkedListNode next;

        LinkedListNode(int node_value) {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, LinkedListNode tail, int val){
        if(head == null) {
            head = new LinkedListNode(val);
            tail = head;
        }
        else {
            tail.next = new LinkedListNode(val);
            tail = tail.next;
        }
        return tail;
    }






}

















