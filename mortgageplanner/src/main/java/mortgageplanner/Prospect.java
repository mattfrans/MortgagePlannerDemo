package mortgageplanner;

import java.text.DecimalFormat;

import com.opencsv.bean.CsvBindByPosition;


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
	private double fixedPayment = paymentAmount(payments,monthlyInterest,total); 
	
    private void calculate(){
        payments = years * MONTHS_IN_YEAR;
        monthlyInterest = (interest / 100) / MONTHS_IN_YEAR;
        fixedPayment = paymentAmount(payments, monthlyInterest, total);
    }

	// method for calculating the monthly fixed payment 
	public double paymentAmount(int payments, float monthlyInterest, double total) {
		// (1+i)^n  i is monthly interest and n is payments, factor
		double curr = 1;
		for(int i=0; i<payments;i++) {
			float a = monthlyInterest + 1;
			curr = curr*a;
		}
		double b = total*((monthlyInterest*curr)/(curr-1));
		
		return b;
		
	}
	
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
        calculate();
	}
	/**
	 * @return the interest
	 */
	public float getInterest() {
		return interest;
	}
	/**
	 * @param interest the interest to set
	 */
	public void setInterest(float interest) {
		this.interest = interest;
        calculate();
	}
	/**
	 * @return the years
	 */
	public int getYears() {
		return years;
	}
	/**
	 * @param years the years to set
	 */
	public void setYears(int years) {
		this.years = years;
        calculate();
	}

	/**
	 * @return the fixedPayment
	 */
	public double getFixedPayment() {
		return fixedPayment;
	}

	/**
	 * @param fixedPayment the fixedPayment to set
	 */
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
        return "Prospect "+prospectNr+": "+getName()+" wants to borrow "+df.format(total)+" €"+ " for a period of "+years+" years and pay "+df.format(fixedPayment)+" € each month.";
    }
}
