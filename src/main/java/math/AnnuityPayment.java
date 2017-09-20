package math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by azee on 14.10.16.
 */
public class AnnuityPayment {

    public AnnuityPayment() {
    }

    public static void main(String... args){
//        System.out.println(getAnnuityMonthlyPayment(130000, 4, 96));
//        System.out.println(getAnnuityMonthlyPayment(900000, 17.9, 60));
//


        for (int i = 12; i <= 12*20; i = i + 12){
            System.out.println(i/12 + " - " + getAnnuityMonthlyPayment(250000, 4, i));
        }
    }

    public static double getAnnuityMonthlyPayment(double loanAmt, double interest, int months){
        double monthlyInterest = (interest / 12) / 100;
        double coefficient = (monthlyInterest * Math.pow(1 + monthlyInterest, months)) / (Math.pow(1 + monthlyInterest, months) - 1);
        return loanAmt * coefficient;
    }
}
