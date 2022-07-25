package com.bridgelabz;

import java.sql.*;

public class DBDemo {
    public static void main(String[] args) throws SQLException {
        System.out.println("welcome to employee-payroll mysql");
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
        String userName = "root";
        String password = "Mnj@1996";

        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, userName, password);
           Statement statement = connection.createStatement();
//            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET salary=5000000.00 WHERE name='Terisa'");
//            statement.executeUpdate();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM employee ");
            ResultSet resultSet = statement.executeQuery(" select * from employee where start BETWEEN CAST('2020-02-05' AS DATE) AND DATE(NOW()); ");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3) + " " + resultSet.getString(4) + " " + resultSet.getString(5));
//                System.out.println("sum of the all  salary " + resultSet.getDouble("max(salary)"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            connection.close();
        }
    }
}

