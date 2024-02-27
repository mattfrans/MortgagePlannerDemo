import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import mortgageplanner.Prospect;


public class ProspectTest {
    @Test
    void testCalculate() {
        Prospect prospect= new Prospect();
        prospect.setTotal(100000);
        prospect.setInterest(5);
        prospect.setYears(20);

        assertEquals(20,prospect.getYears());
        assertEquals(5, prospect.getInterest());
        assertEquals(100000, prospect.getTotal());
        assertEquals(240, prospect.getPayments());
        assertEquals(0.004166667f, prospect.getMonthlyInterest());
        assertEquals(659.9506501597755, prospect.getFixedPayment());
        
        
    }

    @Test
    void testPaymentAmount() {
        Prospect prospect = new Prospect();
        double payment = prospect.paymentAmount(240, 0.004166667f, 100000);

        assertEquals(659.9506501597755, payment);
    }

}
