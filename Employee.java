/**
 * Клас для демонстрації валідації без використання рефлексії.
 */
public class Employee {
    @NotNull
    private String employeeName;

    @MinValue(18)
    @MaxValue(65)
    private int age;

    /**
     * Конструктор для ініціалізації полів співробітника.
     *
     * @param employeeName ім'я співробітника.
     * @param age          вік співробітника.
     */
    public Employee(String employeeName, int age) {
        this.employeeName = employeeName;
        this.age = age;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getAge() {
        return age;
    }
}
