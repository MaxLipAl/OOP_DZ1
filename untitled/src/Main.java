import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Создаем товары
        Commodity commodity1 = new Commodity("Ноутбук", 700, 4.5, 10);
        Commodity commodity2 = new Commodity("Смартфон", 500, 3.2, 200);
        Commodity commodity3 = new Commodity("Планшет", 800, 5.0, 15);

        // Создаем категории
        Category category1 = new Category("Электроника");
        category1.addCommodity(commodity1);
        category1.addCommodity(commodity2);

        Category category2 = new Category("Гаджеты");
        category2.addCommodity(commodity2);
        category2.addCommodity(commodity3);

        // Создаем магазин
        ArrayList<Category> store = new ArrayList<>();
        store.add(category1);
        store.add(category2);

        // Создаем пользователя
        User user = createUser();

        // Создаем меню пользователя
        int selection;
        do {
            System.out.println("\nМеню пользователя:");
            System.out.println("1. Посмотреть каталог товаров");
            System.out.println("2. Посмотреть остатки товаров");
            System.out.println("3. Посмотреть корзину");
            System.out.println("4. Добавить товар в корзину");
            System.out.println("5. Удалить товар из корзины");
            System.out.println("6. Сменить пользователя");
            System.out.println("0. Выход");

            //Выбор пользователя
            System.out.print("Выберите действие: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    MainMethods.showCatalogWithCategories(store);
                    break;
                case 2:
                    MainMethods.showStock(store);
                    break;
                case 3:
                    MainMethods.showBasket(user);
                    break;
                case 4:
                    MainMethods.addInBasket(store, user);
                    break;
                case 5:
                    MainMethods.deleteFromBasket(user);
                    break;
                case 6:
                    user = createUser();
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
            pause();
        } while (selection != 0);
    }

    //Новый пользователь
    private static User createUser() {
        System.out.print("Введите логин пользователя: ");
        String login = scanner.next();
        System.out.print("Введите пароль пользователя: ");
        String password = scanner.next();
        return new User(login, password);
    }

    private static void pause() {
        System.out.println("\nНажмите Enter, чтобы продолжить...");
        scanner.nextLine(); // считываем лишний Enter
    }
}
