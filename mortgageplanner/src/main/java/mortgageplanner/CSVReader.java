package mortgageplanner;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class CSVReader {
    private static final int MONTHS_IN_YEAR= 12;

    //The path to the CSV file is passed as a command line argument
    public static void main(String[] args) {
        String path = args[0];

        try {
            //Parse CSV file using CsvToBeanBuilder
            //Skip the first line as it contains the headers
            List<Prospect> prospects = new CsvToBeanBuilder(new FileReader(path)).withType(Prospect.class).withSkipLines(1).build().parse();

            int prospectNr = 1; //initialize prospect number
            //iterate over list of prospects
            for (Prospect temp : prospects) {
                System.out.println(temp.toString(prospectNr));
                prospectNr++;
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing the CSV file: " + e.getMessage());
        }
    }
}