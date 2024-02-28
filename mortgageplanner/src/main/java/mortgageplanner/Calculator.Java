// Calculator.java
package mortgageplanner;
import mortgageplanner.Calculator;

public class Calculator {
    private static final int MONTHS_IN_YEAR = 12;

    public static double calculateFixedPayment(double total, float interest, int years) {
        int payments = years * MONTHS_IN_YEAR;
        float monthlyInterest = (interest / 100) / MONTHS_IN_YEAR;

        // (1+i)^n  i is monthly interest and n is payments, factor
        double curr = 1;
        for(int i=0; i<payments;i++) {
            float a = monthlyInterest + 1;
            curr = curr*a;
        }
        double b = total*((monthlyInterest*curr)/(curr-1));
        
        return b;
    }
}
