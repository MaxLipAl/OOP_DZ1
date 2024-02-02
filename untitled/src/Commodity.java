// Класс Commodity представляет отдельный товар в магазине
public class Commodity {
    // Название товара
    String name;

    // Цена товара
    double price;

    // Рейтинг товара
    double rating;

    // Остаток товара на складе
    int stockBalance;

    // Конструктор, инициализирующий товар с указанными параметрами
    public Commodity(String name, double price, double rating, int stockBalance) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stockBalance = stockBalance;
    }

    // Метод для уменьшения остатка товара на складе
    public void reduceBalance(int quantity) {
        this.stockBalance -= quantity;
    }
}