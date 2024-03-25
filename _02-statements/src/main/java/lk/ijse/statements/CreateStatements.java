package lk.ijse.statements;

import java.sql.*;

public class CreateStatements {
    private static void saveCustomer() throws ClassNotFoundException, SQLException {
        /* since JDBC4.x not compulsory to load the Driver *//*
        Class.forName("com.mysql.cj.jdbc.Driver");*/

        String sql = "INSERT INTO customers VALUES('C005', 'Danushi', 'Galle', '0765481254')";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        );
        Statement statement = connection.createStatement();
        int affectedRows = statement.executeUpdate(sql);

        if (affectedRows > 0)
            System.out.println("Customer saved!");
        else
            throw new RuntimeException("Customer not saved!");

        connection.close();

    }

    private static void getAllCustomer() throws SQLException {
        String sql = "SELECT * FROM customers";

        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        );
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);    //customer table -> customer ResultSet

        while (resultSet.next()) {
//            String id = resultSet.getString(1);
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");
            String tel = resultSet.getString("tel");

            System.out.println(id + " " + name + " " + address + " " + tel);
        }

        connection.close();
    }

    private static void searchCustomerById() throws SQLException {
        String sql = "SELECT * FROM customers WHERE id = 'C001'";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);    //return type -> int OR ResultSet

            if (resultSet.next()) {
                String id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                String tel = resultSet.getString(4);

                System.out.println(id + " " + name + " " + address + " " + tel);
            } else {
                System.out.println("OOPs! customer not found!");
            }
        }
//        connection.close();   // No need
    }

    private static void deleteCustomer() throws SQLException {
        String sql = "DELETE FROM customers WHERE id = 'C005'";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(sql);

            if(affectedRows > 0)
                System.out.println("customer deleted successfully!");
            else
                System.out.println("customer deleted is not successfully!");
        }
    }

    private static void updateCustomer() throws SQLException {
        String sql = "UPDATE customers SET name = 'Kathrina', address = 'Panadura', tel = '07645873294' WHERE id = 'C003'";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            int affectedRows = statement.executeUpdate(sql);

            if(affectedRows > 0)
                System.out.println("customer updated successfully!");
            else
                System.out.println("customer not updated!");
        }


    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        saveCustomer();

//        getAllCustomer();

//        searchCustomerById();

//        deleteCustomer();

        updateCustomer();

    }
}
