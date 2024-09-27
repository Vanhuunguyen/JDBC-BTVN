package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo <T>{
    public boolean checkCategoryExists(int catId);
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> findProductByName(String name);
    List<Product> findProductsByCategoryId(int catId);
    List<Product> sortProductsByPriceDesc(int catId);
    List<Product> sortProductsByPriceAsc(int catId);
}
