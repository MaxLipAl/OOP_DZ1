import java.util.ArrayList;

// Класс Basket представляет корзину пользователя, где хранятся товары
public class Basket {
    // Список товаров в корзине
    ArrayList<Commodity> basket;

    // Конструктор, инициализирующий пустую корзину
    public Basket() {
        this.basket = new ArrayList<>();
    }

    // Метод для добавления товара в корзину с указанным количеством
    public void addInBasket(Commodity commodity, int quantity) {
        // Проверка наличия достаточного количества товара на складе
        if (commodity.stockBalance >= quantity) {
            // Добавление товара в корзину
            this.basket.add(commodity);
            // Уменьшение баланса товара на складе
            commodity.reduceBalance(quantity);
            // Вывод информации об успешном добавлении в корзину
            System.out.println("Товар добавлен в корзину: " + commodity.name + " (Количество: " + quantity + ")");
        } else {
            // Вывод сообщения об ошибке в случае недостатка товара на складе
            System.out.println("Недостаточно товара на складе.");
        }
    }

    // Метод для удаления товара из корзины с указанным количеством
    public void deleteFromBasket(Commodity commodity, int quantity) {
        // Удаление товара из корзины
        this.basket.remove(commodity);
        // Возврат товара на склад с увеличением баланса
        commodity.stockBalance += quantity;
        // Вывод информации об успешном удалении из корзины
        System.out.println("Товар удален из корзины: " + commodity.name + " (Количество: " + quantity + ")");
    }
}