
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
import mortgageplanner.CSVReader;

public class CSVReaderTest {
    @Test
    public void testMain() {
        // Redirect System.out to a ByteArrayOutputStream so we can capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the main method with a sample file path
        String[] args = {"prospects.txt"};
        CSVReader.main(args);

        // Check that the output contains the expected text
        String output = outContent.toString();
        assertTrue(output.contains("Prospect 1: Juha want to borrow 1000.00"));

        // Reset System.out to its original stream
        System.setOut(System.out);
    }
}
