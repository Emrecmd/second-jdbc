package dao;

import entity.Category;

import java.util.List;

public class CsvDAO implements ICategoryDAO{
    @Override
    public void createCategory(Category c) {

        System.out.println("created category");
    }

    @Override
    public void deleteCategory(long id) {

    }

    @Override
    public boolean existsByTitle(String title) {
        return true;
    }

    @Override
    public List<Category> getCategoryList() {
        return List.of();
    }

    @Override
    public boolean existsById(long id) {
        return false;
    }

    @Override
    public void updateCategory(long id, Category category) {

    }
}
