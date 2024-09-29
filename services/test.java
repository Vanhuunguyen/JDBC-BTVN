package services;

import model.Category;
import model.Product;

import java.sql.Connection;
import java.sql.DriverManager;

public class test {
    public static void main(String[] args) {
        Category category1 = new Category(10,"iphone");
        Category category2 = new Category(11,"Samsung");
        CategoryService categoryService = new CategoryService();

        Product product1 = new Product(1,"bap cai",10.0,1);
        Product product2 = new Product(2,"thit",5.5,2);
        ProductService productService = new ProductService();
        productService.checkCategory(category1,product1);

    }
}

