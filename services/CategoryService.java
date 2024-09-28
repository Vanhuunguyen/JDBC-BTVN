package services;

import Connection.DatabaseConnection;
import model.Category;
import repository.CategoryRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService implements CategoryRepo {


    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO category (id,name) VALUES (?, ?);";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());
            preparedStatement.executeUpdate();
            System.out.println("them thanh cong");
        } catch (SQLException e) {
            DatabaseConnection.printSQLException(e);
        }

    }

    @Override
    public void update(Category category) {
        String sql = "UPDATE Category SET name = ? WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.setInt(2, category.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM Category WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Category findCById(int id) {
        String sql = "SELECT * FROM Category WHERE id = ?;";
        Category category = null;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                category = new Category(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return category;

    }

    @Override
    public List<Category> findByName(String name) {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT * FROM Category WHERE name LIKE ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                categories.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
