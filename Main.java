/**
 * Головний клас для демонстрації роботи валідації з рефлексією і без неї.
 */
public class Main {
    public static void main(String[] args) {
        // Валідація користувача
        System.out.println("=== Тестування класу User ===");
        testUserValidation();

        // Валідація продукту
        System.out.println("\n=== Тестування класу Product ===");
        testProductValidation();

        // Валідація співробітника
        System.out.println("\n=== Тестування класу Employee ===");
        testEmployeeValidation();
    }

    /**
     * Тестування валідації для класу User.
     */
    private static void testUserValidation() {
        User validUser = new User("Іван Петренко", "ivanpetro", 25);
        User invalidUser1 = new User(null, "ivanpetro", 25); // Поле name є null
        User invalidUser2 = new User("Іван Петренко", "ivanpetro123456", 25); // Перевищено довжину username
        User invalidUser3 = new User("Іван Петренко", "ivanpetro", -5); // Вік менший за мінімум

        validateWithReflection(validUser, "User");
        validateWithReflection(invalidUser1, "User");
        validateWithReflection(invalidUser2, "User");
        validateWithReflection(invalidUser3, "User");
    }

    /**
     * Тестування валідації для класу Product.
     */
    private static void testProductValidation() {
        Product validProduct = new Product("Ноутбук", 500);
        Product invalidProduct1 = new Product(null, 500); // Поле productName є null
        Product invalidProduct2 = new Product("Телефон", 1500); // Ціна перевищує максимальне значення

        validateWithReflection(validProduct, "Product");
        validateWithReflection(invalidProduct1, "Product");
        validateWithReflection(invalidProduct2, "Product");
    }

    /**
     * Тестування валідації для класу Employee.
     */
    private static void testEmployeeValidation() {
        Employee validEmployee = new Employee("Олена Шевченко", 30);
        Employee invalidEmployee1 = new Employee(null, 30); // Поле employeeName є null
        Employee invalidEmployee2 = new Employee("Олена Шевченко", 17); // Вік менший за мінімальний
        Employee invalidEmployee3 = new Employee("Олена Шевченко", 70); // Вік більший за максимальний

        System.out.println("Валідація без використанням рефлексії:");
        validateWithoutReflection(validEmployee, "Employee");
        validateWithoutReflection(invalidEmployee1, "Employee");
        validateWithoutReflection(invalidEmployee2, "Employee");
        validateWithoutReflection(invalidEmployee3, "Employee");
        System.out.println("\nВалідація з використанням рефлексії:");
        validateWithReflection(validEmployee, "Employee");
        validateWithReflection(invalidEmployee1, "Employee");
        validateWithReflection(invalidEmployee2, "Employee");
        validateWithReflection(invalidEmployee3, "Employee");
    }

    /**
     * Валідація об'єкта за допомогою рефлексії.
     *
     * @param obj       об'єкт для валідації.
     * @param className ім'я класу для відображення.
     */
    private static void validateWithReflection(Object obj, String className) {
        System.out.println("Тестування об'єкта класу " + className + ": " + obj);
        long start = System.nanoTime();
        try {
            Validator.validate(obj);
            System.out.println("OK!\tУсі поля пройшли валідацію!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR!\tПомилка валідації: " + e.getMessage());
        }
        long end = System.nanoTime();
        System.out.println("Час виконання: " + (end - start) + " нс");
    }

    /**
     * Валідація об'єкта без використання рефлексії.
     *
     * @param obj       об'єкт для валідації.
     * @param className ім'я класу для відображення.
     */
    private static void validateWithoutReflection(Employee obj, String className) {
        System.out.println("Тестування об'єкта класу " + className + ": " + obj);
        long start = System.nanoTime();
        try {
            EmployeeValidator.validate(obj);
            System.out.println("OK!\tУсі поля пройшли валідацію!");
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR!\tПомилка валідації: " + e.getMessage());
        }
        long end = System.nanoTime();
        System.out.println("Час виконання: " + (end - start) + " нс");
    }
}
