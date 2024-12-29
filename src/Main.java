import dao.CategoryDAO;
import entity.Product;
import service.CategoryService;
import entity.Category;
import service.ProductService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService(new CategoryDAO());
        ProductService productService = new ProductService();

        while (true) {
            int islem = getInteger("db'ye veri eklemek için 1, veri listelemek için 2, veri silmek için 3, çıkış için 4, güncellemek için 5, bir ürün eklemek için 6 : ");
            List<Category> categoryList;
            switch (islem) {
                case 1:
                    Category category = new Category(getString("eklemek istediğiniz title ı giriniz: "), LocalDateTime.now());
                    categoryService.createCategory(category);
                    System.out.println("güncellenmiş tablo: \n");
                    categoryList = categoryService.listCategory();
                    printCategoryList(categoryList);
                    break;
                case 2:
                    categoryList = categoryService.listCategory();
                    printCategoryList(categoryList);
                    break;
                case 3:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("silmek istediğiniz id yi girin: ");
                    long id = scanner.nextLong();
                    categoryService.deleteCategory(id);
                    System.out.println("güncellenmiş liste \n");
                    categoryList = categoryService.listCategory();
                    printCategoryList(categoryList);
                    break;
                case 4:
                    System.out.println("çıkış yapılıyor...");
                    break;
                case 5:
                    updateCategory(categoryService);
                    System.out.println("güncellenmiş liste \n");
                    categoryList = categoryService.listCategory();
                    printCategoryList(categoryList);
                    break;
                case 6:
                    Product product = new Product();
                    final String productName = getString("ürünün adını giriniz: ");
                    product.setName(productName);
                    product.setCreatedAt(LocalDateTime.now());
                    categoryList = categoryService.listCategory();
                    printCategoryList(categoryList);
                    final int productCategoryId = getInteger("ürünü hangi kategoriye eklemek istediğinizi giriniz: ");
                    product.setCategoryId(productCategoryId);
                    productService.createProduct(product);
                    break;
                default:
                    System.out.println("hatalı işlem.");
                    break;
            }
            if (islem == 4) {
                break;
            }
        }
    }

    private static void updateCategory(CategoryService categoryService) {
        int id = getInteger("güncellemek istediğiniz id yi girin: ");
        Category category = new Category();
        category.setName(getString("güncellemek istediğini titleı girin: "));
        categoryService.updateCategory(id, category);
    }

    public static int getInteger(String mesaj) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mesaj);
        return scanner.nextInt();
    }

    public static String getString(String mesaj) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mesaj);
        String title = scanner.nextLine();
        return title;
    }

    public static void printCategoryList(List<Category> categoryList) {
        for (Category category : categoryList) {
            System.out.println(category.getId() + category.getName());
        }
    }
}
