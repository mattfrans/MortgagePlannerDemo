// CSVReader.java
package mortgageplanner;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;

public class CSVReader {

    //The path to the CSV file is passed as a command line argument
    public static void main(String[] args) {
        String path = args[0];
    
        try {
            List<Prospect> prospects = new CsvToBeanBuilder(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))
                .withType(Prospect.class)
                .withSkipLines(1)
                .build()
                .parse();
    
            int prospectNr = 1; //initialize prospect number
            //iterate over list of prospects
            for (Prospect temp : prospects) {
                System.out.println(new String(temp.toString(prospectNr).getBytes(), "UTF-8"));
                prospectNr++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing the CSV file: " + e.getMessage());
        }
    }
}
