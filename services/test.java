package services;

import model.Category;
import java.sql.Connection;
import java.sql.DriverManager;

public class test {
    public static void main(String[] args) {
        Category category1 = new Category(10,"iphone");
        Category category2 = new Category(11,"Samsung");
        CategoryService categoryService = new CategoryService();

        categoryService.delete(10);

    }
}

