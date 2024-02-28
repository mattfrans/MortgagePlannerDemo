// CSVReader.java
package mortgageplanner;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVReader {

    //The path to the CSV file is passed as a command line argument
 public static void main(String[] args) {
    String path = args[0];

    try {
        //Read CSV file
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        reader.readLine(); // skip the header line

        int prospectNr = 1; //initialize prospect number
        while ((line = reader.readLine()) != null) {
            List<String> values = parseLine(line);
            if (values.isEmpty()) {
                continue; // skip empty lines
            }
            Prospect prospect = new Prospect();
            prospect.setName(values.get(0));
            prospect.setTotal(Double.parseDouble(values.get(1)));
            prospect.setInterest(Float.parseFloat(values.get(2)));
            prospect.setYears(Integer.parseInt(values.get(3)));
            System.out.println(new String(prospect.toString(prospectNr).getBytes(), "UTF-8"));
            prospectNr++;
        }
    } catch (IOException e) {
        System.err.println("Error reading the CSV file: " + e.getMessage());
    } catch (Exception e) {
        System.err.println("Error processing the CSV file: " + e.getMessage());
    }
}


    private static List<String> parseLine(String line) {
        List<String> values = new ArrayList<>();
        if (line == null || line.trim().isEmpty()) {
            return values; // return empty list for empty lines
        }
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|(?<=,|^)([^,]*)(?:,|$)");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String value = matcher.group(1);
            if (value == null) {
                value = matcher.group(2);
            }
            values.add(value);
        }
        
        // Check that the line has the expected number of fields
        if (values.size() < 4) {
            throw new IllegalArgumentException("Line in CSV file does not have the expected number of fields: " + line);
        }
        
        return values;
    }
    
}
