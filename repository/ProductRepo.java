package repository;

import model.Category;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepo{
    public void checkCategory(Category category,Product product);
    public List<Product> get10Products();
    public void updateProductById(Product product);
    public void deleteProductById(int id);
    public List<Product> sortProductsByPriceDesc(int catId);
    public List<Product> sortProductAscInCategory(int catId);
    public List<Product> findProdAndCateByName(String productName, String categoryName);

}
