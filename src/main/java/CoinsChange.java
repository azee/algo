import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: azee
 * Date: 10/15/13
 * Time: 4:17 PM
  */
public class CoinsChange {
    public static void main(String[] args) {
        List<Coins> result = new ArrayList<Coins>();
        List<Double> coins = new ArrayList<Double>();
        coins.add(Coins.ONE_HUNDRED.value());
        coins.add(Coins.FIFTY.value());
        coins.add(Coins.TWENTY.value());
        coins.add(Coins.TEN.value());
        coins.add(Coins.FIVE.value());
        coins.add(Coins.TWO.value());
        coins.add(Coins.ONE.value());
        coins.add(Coins.HALF_DOLLAR.value());
        coins.add(Coins.QUARTER.value());
        coins.add(Coins.DIME.value());
        coins.add(Coins.NICKEL.value());
        coins.add(Coins.PENNY.value());

        countCoins(0.15, result, coins);
        //countCoins(11, result, coins);
        System.out.println(result);
    }

    public static void countCoins(double value, List<Coins> result, List<Double> coins){
        for(Double coin : coins){
            int division = (int) (value / coin);
            if (division >= 1){
                for(int j = 0; j < division; j++){
                    result.add(Coins.fromValue(coin));
                }
                value = round(value - division * coin, 2);
                countCoins(value, result, coins);
                break;
            }
        }
    }

    public enum Coins {

        PENNY(0.01, "PENNY"),
        NICKEL(0.05, "NICKEL"),
        DIME(0.10, "DIME"),
        QUARTER(0.25, "QUARTER"),
        HALF_DOLLAR(0.50, "HALF DOLLAR"),
        ONE(1, "ONE"),
        TWO(2, "TWO"),
        FIVE(5, "FIVE"),
        TEN(10, "TEN"),
        TWENTY(20, "TWENTY"),
        FIFTY(50, "FIFTY"),
        ONE_HUNDRED(100, "ONE HUNDRED"),
        ZERO(0, "ZERO"),
        ERROR(-1, "ERROR");

        private final double value;
        private final String description;

        Coins(double v, String description) {
            this.value = v;
            this.description = description;
        }

        public double value() {
            return value;
        }


        public static Coins fromValue(double v) {
            for (Coins c: Coins.values()) {
                if (c.value == v) {
                    return c;
                }
            }
            throw new IllegalArgumentException(Double.toString(v));
        }

    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, BigDecimal.ROUND_HALF_UP);
        return bd.doubleValue();
    }

}
