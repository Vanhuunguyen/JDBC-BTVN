package services;

import Connection.DatabaseConnection;
import model.Product;
import repository.ProductRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductServices implements ProductRepo<Product> {


    @Override
    public boolean checkCategoryExists(int catId) {
        String sql = "SELECT COUNT(*) FROM Category WHERE id = ?;";
        boolean exists = false;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, catId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<Product> findProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> findProductsByCategoryId(int catId) {
        return List.of();
    }

    @Override
    public List<Product> sortProductsByPriceDesc(int catId) {
        return List.of();
    }

    @Override
    public List<Product> sortProductsByPriceAsc(int catId) {
        return List.of();
    }
}
