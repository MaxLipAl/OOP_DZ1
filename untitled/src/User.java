import java.util.Objects;
// Определение корзины по логину и паролю
public class User {
    private String login;
    private String password;
    private Basket basket;

    // Конструктор, инициализирующий пользователя с указанными логином и паролем
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.basket = new Basket();
    }
    // Метод для получения логина пользователя
    public String getLogin() {
        return login;
    }
    // Метод для получения пароля пользователя
    public String getPassword() {
        return password;
    }
    // Метод для изменения пароля пользователя
    public void setPassword(String newPassword) {
        password = newPassword;
    }
    // Метод для получения корзины пользователя
    public Basket getBasket() {
        return basket;
    }

    // Переопределение метода equals для сравнения пользователей по логину
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(login, user.login);
    }

    // Переопределение метода hashCode для использования в HashSet
    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}