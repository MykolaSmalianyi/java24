/**
 * Клас для демонстрації валідації полів користувача.
 */
public class User {
    @NotNull
    private String name;

    @StringLength(max = 10)
    private String username;

    @MaxValue(100)
    @MinValue(0)
    private int age;

    /**
     * Конструктор для ініціалізації полів користувача.
     *
     * @param name     ім'я користувача.
     * @param username ім'я користувача для системи.
     * @param age      вік користувача.
     */
    public User(String name, String username, int age) {
        this.name = name;
        this.username = username;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }
}
