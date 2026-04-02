package BankManagementSystem;

import java.sql.*;
public class Conn {
//    there are 5 step in jdbc:
//    1. Register the driver
//    2. create connection
//    3. create statement
//    4. execute Query
//    5. close the connection

//    Create Connection
    Connection c;
    Statement s;
    public Conn(){
        // jdbc is an external entity so if we will get an error then the
//        error come at runtime. so that's the reasone we need to write the
//        connection code in try and catch block.
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem","root","Sahil@28122024");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
