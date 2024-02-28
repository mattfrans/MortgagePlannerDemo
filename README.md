A mortgage Planner, takes as input an CSV file with the headers: Customer, Total, loan, Interest, Years and calculates the fixed monthly payments for the customers, returning a string with loan information.

To run download or clone the repository and compile with maven (mvn compile) and run with mvn exec:java. The program takes as an argument the prospects.txt file, can be changed in the argument section in pom.xml. Alternatively you can delete the argument section in xml.pom and give the path of an appropriate text file as command line argument.

1.You need java installed and added to PATH, you also need maven
2.Navigate on command line, power shell or some other terminal. Compile with the command 'mvn compile', then run with 'mvn exec:java'. You can also run unit tests with 'mvn test'.

TODO: 
Dockerization
Web interface Publication in a cloud service
