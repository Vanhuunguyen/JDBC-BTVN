package services;

import Connection.DatabaseConnection;
import model.Category;
import model.Product;
import repository.ProductRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements ProductRepo {


    @Override
    public void checkCategory(Category category, Product product) {
        String sql = "SELECT * FROM category WHERE name = ?";
        String sqlInsert =  "INSERT INTO product (id,NAME,price,cat_id) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, category.getName());
            ResultSet rs = ps.executeQuery();
//            System.out.println(rs.next());
            if (rs.next()) {
                PreparedStatement ps2 = conn.prepareStatement(sqlInsert);
                ps2.setInt(1, product.getId());
                ps2.setString(2, category.getName());
                ps2.setDouble(3, product.getPrice());
                ps2.setInt(4, product.getCat_id());

                int checkResult = ps2.executeUpdate();
                System.out.println("them thanh cong");

            } else {
                System.out.println("Category does not exist");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> get10Products() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product ORDER BY id DESC LIMIT 10;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("cat_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void updateProductById(Product product) {
        String sql = "UPDATE Product SET name = ?, price = ? WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteProductById(int id) {
        String sql = "DELETE FROM Product WHERE id = ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> sortProductsByPriceDesc(int catId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE cat_id = ? ORDER BY price DESC;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, catId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("cat_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }

    @Override
    public List<Product> sortProductAscInCategory(int catId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM Product WHERE cat_id = ? ORDER BY price ASC;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, catId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("cat_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }

    @Override
    public List<Product> findProdAndCateByName(String productName, String categoryName) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT p.* FROM Product p JOIN Category c ON p.cat_id = c.id WHERE p.name LIKE ? AND c.name LIKE ?;";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + productName + "%");
            pstmt.setString(2, "%" + categoryName + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"), rs.getInt("cat_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;

    }
}
