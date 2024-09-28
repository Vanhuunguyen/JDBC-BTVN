package repository;

import model.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryRepo {
        void insert(Category category);
        void update(Category category);
        void delete(int id);
        Category findCById(int id);
        List<Category> findByName(String name);
}
