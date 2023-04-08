package com.example.hakaton;

import org.postgresql.util.PSQLException;

import java.sql.*;

public class Query {

    public boolean compare(String q1, String q2) {
        Connection c = null;

        Statement stmt = null;
        ResultSet rs = null;

        try {

            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hakaton","contractme", "contractme");


            System.out.println("Successfully Connected.");



            stmt = c.createStatement();
            String query = "(" + q1 +") EXCEPT (" + q2 + ");";
            rs = stmt.executeQuery(query);

            int rowCount = 0;
            while ( rs.next() ) {
                rowCount++;
            }

            rs.close();

            stmt.close();

            c.close();
            return rowCount == 0;
        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }
        return true;
    }

}
