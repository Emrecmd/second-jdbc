import dao.CategoryDAO;
import service.CategoryService;
import entity.Category;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService(new CategoryDAO());

        while (true) {
            int islem = getInteger("db'ye veri eklemek için 1, veri listelemek için 2, veri silmek için 3, çıkış için 4: ");
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
        category.setTitle(getString("güncellemek istediğini titleı girin: "));
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
            System.out.println(category.getId() + category.getTitle());
        }
    }
}
