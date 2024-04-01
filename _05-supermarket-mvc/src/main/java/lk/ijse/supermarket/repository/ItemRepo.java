package lk.ijse.supermarket.repository;

import lk.ijse.supermarket.db.DbConnection;
import lk.ijse.supermarket.model.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemRepo {
    public static boolean save(Item item) throws SQLException {
        String sql = "INSERT INTO items VALUES(?, ?, ?, ?)";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());

        return pstm.executeUpdate() > 0;
    }
}
