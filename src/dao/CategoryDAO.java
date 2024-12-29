package dao;

import entity.Category;
import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {

    private Connection connection;

    private Connection getConnection() {
        if (this.connection == null) {
            DBConnection dbc = new DBConnection();
            this.connection = dbc.connect();
        }
        return connection;
    }


    public void createCategory(Category c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into category (name , created_at) values ('" + c.getName() + "', '" + c.getCreatedAt() + "')";
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateCategory(long id, Category category) {
        String query = "UPDATE category SET " +
                " name = \'" + category.getName() + "\'" +
                " WHERE ID = " + id;

        try (Statement statement = getConnection().createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteCategory(long id) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "DELETE FROM category WHERE id = " + id;
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean existsByTitle(String name) {
        String query = "SELECT COUNT(*) FROM category WHERE LOWER(name) = LOWER(\'" + name + "\')";
        try {
            Statement statement = this.getConnection().createStatement();
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            int count = 0;
            if (resultSet.next()) {
                count = resultSet.getInt("count");
            }
            return (count > 0);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public boolean existsById(long id) {
        String query = "SELECT COUNT(*) FROM category WHERE id = " + id;

        try {
            Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            int count = 0;
            if(resultSet.next()) {
                count = resultSet.getInt("count");
            }
            return (count > 0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Category> getCategoryList() {
        List<Category> categoryList = new ArrayList<>();
        try {
            Statement st = getConnection().createStatement();
            String query = "select * from category";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getLong("id"));
                category.setName(rs.getString("name"));
                categoryList.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categoryList;
    }
}
