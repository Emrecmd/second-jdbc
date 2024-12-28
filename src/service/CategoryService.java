package service;

import dao.CategoryDAO;
import dao.CsvDAO;
import dao.ICategoryDAO;
import entity.Category;
import java.util.List;

public class CategoryService {
    private final ICategoryDAO categoryDao;

    public CategoryService (ICategoryDAO categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<Category> listCategory() {
        return categoryDao.getCategoryList();
    }

    public void deleteCategory(long id) {
        categoryDao.deleteCategory(id);
    }

    public void createCategory(Category category) {
        if (categoryDao.existsByTitle(category.getTitle())) {
            System.out.println("bu title zaten mevcut");
            return;
        }
        categoryDao.createCategory(category);
    }

    public void updateCategory(long id, Category category) {
        categoryDao.updateCategory(id, category);
    }
}
