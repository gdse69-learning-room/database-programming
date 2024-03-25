package lk.ijse.statements;

import java.sql.*;

public class SQLInjection {
    private static void getUserDetailsByCreateStatement(String userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = " + userId;

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()) {
                String user_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String pw = resultSet.getString(3);

                System.out.println(user_id + " - " + name + " - " + pw);
            }
        }
    }

    private static void getUserDetailsByPrepareStatement(String userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE user_id = ?";

        try(Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kade",
                "root",
                "Ijse@1234"
        )) {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setObject(1, userId);

            ResultSet resultSet = pstm.executeQuery();
            while(resultSet.next()) {
                String user_id = resultSet.getString(1);
                String name = resultSet.getString(2);
                String pw = resultSet.getString(3);

                System.out.println(user_id + " - " + name + " - " + pw);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        String user_id = "'fdtyfyfyt' OR 1=1";

//        getUserDetailsByCreateStatement(user_id);
        getUserDetailsByPrepareStatement(user_id);
    }
}
