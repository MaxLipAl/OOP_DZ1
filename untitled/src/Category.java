import java.util.ArrayList;

// Класс Category представляет категорию товаров в магазине
public class Category {
    // Название категории
    String name;

    // Список товаров в категории
    ArrayList<Commodity> commodities;

    // Конструктор, инициализирующий категорию с указанным названием
    public Category(String name) {
        this.name = name;
        this.commodities = new ArrayList<>();
    }

    // Метод для добавления товара в категорию
    public void addCommodity(Commodity commodity) {
        this.commodities.add(commodity);
    }
}