/**
 * Клас для ручної валідації об'єктів Employee без рефлексії.
 */
public class EmployeeValidator {
    /**
     * Метод для валідації полів об'єкта Employee.
     *
     * @param employee об'єкт Employee, який потрібно валідувати.
     * @throws IllegalArgumentException якщо поле не відповідає умовам валідації.
     */
    public static void validate(Employee employee) {
        if (employee.getAge() < 18 || employee.getAge() > 65) {
            throw new IllegalArgumentException("Вік співробітника має бути у межах від 18 до 65 років");
        }
        if (employee.getEmployeeName() == null) {
            throw new IllegalArgumentException("Ім'я співробітника не може бути null");
        }
    }
}
