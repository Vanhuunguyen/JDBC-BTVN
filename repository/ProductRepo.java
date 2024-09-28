package repository;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo{
    public void addProductIf(String productName, double price, Category catId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> findProductByName(String name);
    List<Product> findProductsByCategoryId(int catId);
    List<Product> sortProductsByPriceDesc(int catId);
    List<Product> sortProductsByPriceAsc(int catId);
}
