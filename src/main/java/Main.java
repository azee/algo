
import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import utils.HTML2Md;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created by azee on 22.12.14.
 */
public class Main{

    public static void main(String... args) throws IOException {






    }






















//  public static void main(String... args) throws IOException {
//    System.out.println(new Main().solution(new int[]{1, 5, 3, 3, 7}));
//      System.out.println(new Main().solution(new int[]{1, 3, 5, 3, 4}));
//      System.out.println(new Main().solution(new int[]{1, 3, 5}));
//
//  }

    public boolean solution(int[] A) {
        int buffer;
        for (int i = 0; i < A.length; i++){
            if (i == A.length - 1){
                return isSorted(A);
            }

            for (int j = 0; j < A.length; j++){
                if (A[i] > A[j]){
                    buffer = A[i];
                    A[i] = A[j];
                    A[j] = buffer;

                    if (isSorted(A)){
                        return true;
                    } else {
                        buffer = A[i];
                        A[i] = A[j];
                        A[j] = buffer;
                    }
                }
            }

        }
        return false;
    }


    public boolean isSorted(int[] A){
        for (int i = 0; i < A.length; i++){
            if (i == A.length - 1){
                return true;
            }
            for (int j = i + 1; j < A.length; j++){
                if (A[i] > A[j]){
                    return false;
                }
            }
        }
        return true;
    }


//    public int solution(int[] A) {
//        int result = Integer.MAX_VALUE;
//        if (A == null || A.length == 0){
//            return result;
//        }
//        if (A.length == 1){
//            return A[0];
//        }
//
//        for (int i = 0; i < A.length; i++){
//            int tempResult = A[i];
//            if (i == A.length - 1){
//                result = Math.min(result, Math.abs(tempResult));
//            }
//            else {
//                for (int j = i + 1; j < A.length; j++){
//                    tempResult += A[j];
//                    result = Math.min(result, Math.abs(tempResult));
//                }
//            }
//        }
//        return result;
//    }





//    public int solution(int[] A) {
//        int maxDepth = -1;
//        if (A == null || A.length <= 3){
//            return maxDepth;
//        }
//
//        int p = 0;
//        int q = 0;
//        int r = 0;
//
//        int persistedP = 0;
//        int persistedQ = 0;
//
//        for (int i = 0; r < A.length; i++){
//            p = i;
//            q = i + 1;
//            r = i + 2;
//            if (A[p] <= A[q]){
//                continue;
//            }
//
//            persistedP = p;
//
//            while (q < A.length && A[persistedP] > A[q]){
//                persistedP++;
//                q++;
//            }
//            q--;
//
//            persistedQ = q;
//            r = q + 1;
//            while (r < A.length && A[persistedQ] < A[r]){
//                maxDepth = Math.max(maxDepth, Math.min(A[p] - A[q], A[r] - A[q]));
//                persistedQ++;
//                r++;
//            }
//            r--;
//
//            if (p < q && q < r){
//                maxDepth = Math.max(maxDepth, Math.min(A[p] - A[q], A[r] - A[q]));
//            }
//        }
//        return maxDepth;
//    }


}