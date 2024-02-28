// Prospect.java
package mortgageplanner;

import com.opencsv.bean.CsvBindByPosition;
import java.text.DecimalFormat;
import java.nio.charset.StandardCharsets;

public class Prospect {
    private static final int MONTHS_IN_YEAR=12;
    private static final DecimalFormat df = new DecimalFormat("#.00");
    
    @CsvBindByPosition(position = 0)
    private String name;
    
    @CsvBindByPosition(position = 1)
    private double total;
    
    @CsvBindByPosition(position = 2)
    private float interest;
    
    @CsvBindByPosition(position = 3)
    private int years;
    
    private int payments = years*MONTHS_IN_YEAR;
    private float monthlyInterest = (interest/100)/MONTHS_IN_YEAR;
    private double fixedPayment;
    
    private void calculate(){
        fixedPayment = Calculator.calculateFixedPayment(total, interest, years);
    }
    
    public String getName() {
        return new String(name.getBytes(), StandardCharsets.UTF_8);
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
        calculate();
    }
    
    public float getInterest() {
        return interest;
    }
    
    public void setInterest(float interest) {
        this.interest = interest;
        calculate();
    }
    
    public int getYears() {
        return years;
    }
    
    public void setYears(int years) {
        this.years = years;
        calculate();
    }

    public double getFixedPayment() {
        calculate();
        return fixedPayment;

    }

    public void setFixedPayment(double fixedPayment) {
        this.fixedPayment = fixedPayment;
    }
    
    public float getMonthlyInterest() {
        return monthlyInterest;
    }
    public void setMonthlyInterest(float monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
        calculate();
    }
    
    public int getPayments() {
        return payments;
    }
    public void setPayments(int payments) {
        this.payments = payments;
        calculate();
    }
    
    public String toString(int prospectNr) {
        return new String(("Prospect "+prospectNr+": "+getName()+" wants to borrow "+df.format(total)+" €"+ " for a period of "+years+" years and pay "+df.format(fixedPayment)+" € each month.").getBytes(), StandardCharsets.UTF_8);
    }
}
