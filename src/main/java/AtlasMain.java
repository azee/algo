import javafx.beans.binding.IntegerExpression;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by azee on 24.05.16.
 */
public class AtlasMain {

    public static void main(String... args){
        System.out.println(stupidCode().size());



    }

    public static ArrayList<String> stupidCode() {
        ArrayList<String> crap = new ArrayList<String> ();
        return crap;
    }



    public static boolean tf(){
        try {
            return true;
        } finally {
            return false;
        }
    }


//    public static void main(String... args){
//        System.out.println(compute("PMLPMMMLPMLPMML"));
//        System.out.println(compute("PL"));
//        System.out.println(compute("PLPLPLPLPLPLPLPLPLPL"));
//
//    }

    static String compute(String instructions) {
        List<Integer> piles = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        boolean haveBlock = false;
        int currentPosition = 0;

        for(char instruction : instructions.toCharArray()){
            if (instruction == 'P'){
                if (!haveBlock){
                    haveBlock = true;
                }
                currentPosition = 0;
            }

            if (instruction == 'M'){
                if (currentPosition != 9){
                    currentPosition++;
                }
            }

            if (instruction == 'L' && haveBlock){
                if (piles.get(currentPosition) < 15){
                    piles.set(currentPosition, piles.get(currentPosition) + 1);
                    haveBlock = false;
                }
            }
        }

        return getResult(piles);
    }

    private static String getResult(List<Integer> piles) {
        StringBuilder sb = new StringBuilder();
        for (Integer pile : piles){
            sb.append(Integer.toHexString(pile));
        }
        return sb.toString().toUpperCase();
    }


    static String convert(long input) {
        String digits = "0atlsin";
        if (input == 0){
            return "0";
        }
        String result = "";
        while (input > 0){
            long digit = input % 7;
            result = digits.charAt((int)digit) + result;
            input = input / 7;
        }
        return result;
    }




    //    public static void main(String... args){
//        System.out.println(LookAndSay("1"));
//        System.out.println(LookAndSay("11"));
//        System.out.println(LookAndSay("21"));
//        System.out.println(LookAndSay("1211"));
//        System.out.println(LookAndSay("111221"));
//    }

    static String LookAndSay(String start, int n) {
        for (int i = 0; i < n; i++){
            start = LookAndSay(start);
        }
        return start;
    }

    static String LookAndSay(String start) {
        char current;
        int counter;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < start.length(); i++){
            counter = 0;
            current = start.charAt(i);
            for (int j = i; j < start.length(); j++){
                if (start.charAt(j) == current){
                    counter++;
                    i = j;
                } else {
                    break;
                }
            }
            sb.append(counter);
            sb.append(current);
        }
        return sb.toString();
    }

//    public static void main(String... args){
//        LinkedListNode head = _insert_node_into_singlylinkedlist(null, "1");
//        LinkedListNode node = _insert_node_into_singlylinkedlist(head, "2");
//        node = _insert_node_into_singlylinkedlist(node, "3");
//        //node = _insert_node_into_singlylinkedlist(node, "4");
//        //node = _insert_node_into_singlylinkedlist(node, "5");
//
//
//        LinkedListNode head1 = _insert_node_into_singlylinkedlist(null, "1");
//        LinkedListNode node1 = _insert_node_into_singlylinkedlist(head1, "2");
//        _insert_node_into_singlylinkedlist(node1, "3");
//
//        System.out.println(find(head, head1));
//
//
//    }

    public static class LinkedListNode{
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    }

    public static LinkedListNode _insert_node_into_singlylinkedlist(LinkedListNode head, String val){
        if(head == null) {
            head = new LinkedListNode(val);
        }
        else {
            LinkedListNode end = head;
            while (end.next != null) {
                end = end.next;
            }
            LinkedListNode node = new LinkedListNode(val);
            end.next = node;
        }
        return head;
    }

    static int find(LinkedListNode list, LinkedListNode sublist) {
        int result = -1;
        int counter = 0;
        if (list.val.equals(sublist.val) && sublist.next == null){
            return 0;
        }
        while (list != null){
            LinkedListNode shuttle = list;
            LinkedListNode subShuttle = sublist;
            while(shuttle.val.equals(subShuttle.val)){
                if (subShuttle.next == null){
                    return counter;
                }
                if (shuttle == null || shuttle.next == null){
                    break;
                }
                shuttle = shuttle.next;
                subShuttle = subShuttle.next;
            }
            list = list.next;
            counter++;

        }

        return result;
    }





}
