// CSVReader.java
package mortgageplanner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Prospect> readCSV(String path) {
        List<Prospect> prospects = new ArrayList<>();
        
        try {
            //Read CSV file
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
            String line;
            reader.readLine(); // skip the header line
            
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Prospect prospect = new Prospect();
                prospect.setName(values[0]);
                prospect.setTotal(Double.parseDouble(values[1]));
                prospect.setInterest(Float.parseFloat(values[2]));
                prospect.setYears(Integer.parseInt(values[3]));
                prospects.add(prospect);
            }
        } catch (IOException e) {
            System.err.println("Error reading the CSV file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing the CSV file: " + e.getMessage());
        }
        
        return prospects;
    }
}

