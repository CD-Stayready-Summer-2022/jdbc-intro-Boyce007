package com.codedifferently;
import java.sql.*;

public class ESelectDBExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/ROSTER";
    static final String USER = "root";
    static final String PASS = "clean-code";
    static final String QUERY = "SELECT id, first, last, age FROM STUDENTS";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(QUERY);
        ) {
            while(rs.next()){
                //Display values
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setAge(rs.getInt("age"));
                student.setFirst( rs.getString("first"));
                student.setLast(rs.getString("last"));
                System.out.println(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
