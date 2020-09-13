package kz.aitu.project;

import kz.aitu.project.entity.Group;
import kz.aitu.project.entity.Student;

import java.util.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Alan", "87717717171", 1);
        Group group = new Group(1,"CS-1905");
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:postgresql://localhost:5432/post+gres";
            String user = "postgres";
            String password = "123";

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            // more processing here
            // ...
            Statement stmt = conn.createStatement();
            ResultSet rs;
            String query = "INSERT INTO \"Group\" VALUES" +
                    "("+group.id+",\'"+group.name+"\'"+")";
            stmt.executeUpdate(query);
            query = "INSERT INTO  \"Student\" VALUES " +
                    "("+student.id+",\'"+student.name+"\',\'"+student.phone+"\',"+student.groupId+")";
            stmt.executeUpdate(query);
            Scanner in = new Scanner(System.in);
            String group_name = in.next();
            String query1 = "SELECT \"Student\".id,\"Student\".name,\"Student\".phone\n" +
                    "FROM \"Student\"\n" +
                    "INNER JOIN \"Group\"\n" +
                    "ON \"Student\".id = \"Group\".id\n" +
                    "WHERE \"Group\".name = \'"+group_name+"\'";
            rs = stmt.executeQuery(query1);
            while (rs.next() ) {
                System.out.println(rs.getString("id"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("phone"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
}
