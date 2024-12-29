package dao;

import entity.Category;

import java.util.List;

public interface ICategoryDAO {
    public void createCategory(Category c);
    public void deleteCategory(long id);
    public boolean existsByTitle(String title);
    public List<Category> getCategoryList();
    public boolean existsById(long id);

    void updateCategory(long id, Category category);
}
