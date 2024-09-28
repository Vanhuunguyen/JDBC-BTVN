package services;

import Connection.DatabaseConnection;
import model.Category;
import model.Product;
import repository.ProductRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductService implements ProductRepo {


    @Override
    public void addProductIf(String productName, double price, Category catId) {

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
