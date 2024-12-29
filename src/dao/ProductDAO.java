package dao;

import entity.Product;
import util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductDAO {

    private Connection connection;

    private Connection getConnection() {
        if (this.connection == null) {
            DBConnection dbc = new DBConnection();
            this.connection = dbc.connect();
        }
        return connection;
    }

    public void createProduct(Product product) {
        //sql sorgusu
        String query = "insert into product (name, category_id)" +
                " values(\'" + product.getName() + "\' , " + product.getCategoryId() + ")";
        try {
            Statement statement = getConnection().createStatement();
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
