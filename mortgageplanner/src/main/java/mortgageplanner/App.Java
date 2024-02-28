// App.java
package mortgageplanner;

import java.util.List;

public class App {
    public static void main(String[] args) {
        String path = args[0];
    
        try {
            //Read CSV file
            List<Prospect> prospects = CSVReader.readCSV(path);
    
            int prospectNr = 1; //initialize prospect number
            //iterate over list of prospects
            for (Prospect temp : prospects) {
                System.out.println(new String(temp.toString(prospectNr).getBytes(), "UTF-8"));
                prospectNr++;
            }
        } catch (Exception e) {
            System.err.println("Error processing the CSV file: " + e.getMessage());
        }
    }
}
