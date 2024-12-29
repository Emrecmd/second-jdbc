package service;

import dao.CategoryDAO;
import dao.ProductDAO;
import entity.Product;

public class ProductService {
    ProductDAO productDao = new ProductDAO();
    CategoryService categoryService = new CategoryService(new CategoryDAO());

    public void createProduct(Product product) {
        if(categoryService.existById(product.getCategoryId())) {
            productDao.createProduct(product);
        }
        else System.out.println("böyle bir category id si yok.");
        return;
    }
}
