package lk.ijse.statements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementDemo {
    private static void saveCustomer(String id, String name, String address, String tel) throws SQLException {
        String sql = "INSERT INTO customers VALUES(?, ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);//return -> PrepareStatement
            pstm.setObject(1, id);
            pstm.setObject(2, name);
            pstm.setObject(3, address);
            pstm.setObject(4, tel);

            int affectedRows = pstm.executeUpdate();
            if(affectedRows > 0)
                System.out.println("customer saved!");
            else
                System.out.println("customer not saved!");
        }
    }

    private static void updateCustomer(String id, String name, String address, String tel) throws SQLException {
        String sql = "UPDATE customers SET name = ?, address = ?, tel = ? WHERE id = ?";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, name);
            pstm.setObject(2, address);
            pstm.setObject(3, tel);
            pstm.setObject(4, id);

            boolean isUpdated = pstm.executeUpdate() > 0;
            if(isUpdated)
                System.out.println("customer updated!");
            else
                System.out.println("customer not updated!");
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);

        System.out.print("Input customer id: ");
        String id = input.next();

        System.out.print("Input new customer name: ");
        String name = input.next();

        System.out.print("Input new customer address: ");
        String address = input.next();

        System.out.print("Input new customer tel: ");
        String tel = input.next();

//        saveCustomer(id, name, address, tel);

        updateCustomer(id, name,  address, tel);
    }
}
