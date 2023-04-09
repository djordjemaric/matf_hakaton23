package com.example.hakaton;

import org.postgresql.util.PSQLException;

import java.sql.*;

public class Query {

    public boolean compare(String q1, String q2) {
        Connection c = null;

        Statement stmt1 = null;
        Statement stmt2 = null;
        ResultSet rs = null;

        try {

            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hakaton","contractme", "contractme");


            System.out.println("Successfully Connected.");



            stmt1 = c.createStatement();
            stmt2 = c.createStatement();
            ResultSet rs1 = stmt1.executeQuery(q1);
            ResultSet rs2 = stmt2.executeQuery(q2);
            ResultSetMetaData rsmd1 = rs1.getMetaData();
            ResultSetMetaData rsmd2 = rs2.getMetaData();
            if (rsmd1.getColumnCount() != rsmd2.getColumnCount())
                return false;
            while ( rs1.next() && rs2.next()) {
                for(int i = 1; i <= rsmd1.getColumnCount(); i++){
                    String columnNameRs1 = rsmd1.getColumnName(i);
                    if (!rs1.getObject(i).equals(rs2.getObject(columnNameRs1))) {
                        return false;
                    }

                }

//                rsmd.getColumnCount();
            }

//            rs.close();

            stmt1.close();
            stmt2.close();

            c.close();
        } catch ( Exception e ) {

            System.err.println( e.getClass().getName()+": "+ e.getMessage() );

            System.exit(0);

        }
        return true;
    }

}
