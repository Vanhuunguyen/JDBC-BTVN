package services;

import Connection.DatabaseConnection;
import model.Category;
import repository.CategoryRepo;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class CategoryService implements CategoryRepo<Category> {

    @Override
    public void insert(Category category) {
        String sql = "INSERT INTO Category (name) VALUES (?);";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category.getName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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

    }

    @Override
    public Category findCById(int id) {
        return null;
    }

    @Override
    public List<Category> findByName(String name) {
        return List.of();
    }
}
