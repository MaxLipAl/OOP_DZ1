import java.util.ArrayList;
import java.util.Scanner;

// Класс, содержащий методы для работы с меню и логикой программы
public class MainMethods {
    private static final Scanner scanner = new Scanner(System.in);

    // Метод для отображения каталога товаров с категориями
    public static void showCatalogWithCategories(ArrayList<Category> store) {
        System.out.println("\nКаталог товаров:");
        for (Category category : store) {
            System.out.println(category.name + ":");
            for (int i = 0; i < category.commodities.size(); i++) {
                Commodity commodity = category.commodities.get(i);
                // Отображаем товары в категории с номерами, ценой и рейтингом
                System.out.println((i + 1) + ". " + commodity.name + " - Цена: $" + commodity.price +
                        ", Рейтинг: " + commodity.rating);
            }
        }
    }

    // Метод для отображения остатков товаров на складе
    public static void showStock(ArrayList<Category> store) {
        System.out.println("\nОстатки товаров на складе:");
        for (Category category : store) {
            System.out.println(category.name + ":");
            for (Commodity commodity : category.commodities) {
                // Отображаем остатки товаров на складе
                System.out.println(commodity.name + " - Остаток: " + commodity.stockBalance);
            }
        }
    }

    // Метод для отображения корзины пользователя
    public static void showBasket(User user) {
        System.out.println("\nКорзина пользователя " + user.getLogin() + ":");
        for (Commodity commodity : user.getBasket().basket) {
            // Отображаем товары в корзине пользователя
            System.out.println(commodity.name);
        }
    }

    // Метод для добавления товара в корзину
    public static void addInBasket(ArrayList<Category> store, User user) {
        showCatalogWithCategories(store);
        System.out.print("Выберите номер категории: ");
        int categoryNumber = scanner.nextInt();
        if (categoryNumber >= 1 && categoryNumber <= store.size()) {
            Category selectedCategory = store.get(categoryNumber - 1);
            showCatalogInCategory(selectedCategory);
            System.out.print("Выберите номер товара для добавления в корзину: ");
            int itemNumber = scanner.nextInt();
            System.out.print("Введите количество: ");
            int quantity = scanner.nextInt();

            if (itemNumber >= 1 && itemNumber <= selectedCategory.commodities.size()) {
                Commodity selectedItem = selectedCategory.commodities.get(itemNumber - 1);
                user.getBasket().addInBasket(selectedItem, quantity);
            } else {
                System.out.println("Некорректный номер товара.");
            }
        } else {
            System.out.println("Некорректный номер категории.");
        }
    }

    // Метод для удаления товара из корзины
    public static void deleteFromBasket(User user) {
        showBasket(user);
        System.out.print("Введите номер товара для удаления из корзины: ");
        int itemNumber = scanner.nextInt();
        System.out.print("Введите количество: ");
        int quantity = scanner.nextInt();

        if (itemNumber >= 1 && itemNumber <= user.getBasket().basket.size()) {
            Commodity selectedItem = user.getBasket().basket.get(itemNumber - 1);
            user.getBasket().deleteFromBasket(selectedItem, quantity);
        } else {
            System.out.println("Некорректный номер товара.");
        }
    }

    // Метод для изменения пароля пользователя
    public static void changePassword(User user) {
        System.out.print("Введите новый пароль: ");
        String newPassword = scanner.next();
        user.setPassword(newPassword);
        System.out.println("Пароль успешно изменен.");
    }

    // Метод для отображения каталога товаров в конкретной категории
    private static void showCatalogInCategory(Category category) {
        System.out.println("\nКаталог товаров в категории " + category.name + ":");
        for (int i = 0; i < category.commodities.size(); i++) {
            Commodity commodity = category.commodities.get(i);
            // Отображаем товары в категории с номерами, ценой и рейтингом
            System.out.println((i + 1) + ". " + commodity.name + " - Цена: $" + commodity.price +
                    ", Рейтинг: " + commodity.rating);
        }
    }
}