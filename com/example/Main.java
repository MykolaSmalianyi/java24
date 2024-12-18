package com.example;

import com.example.generators.SQLGenerator;
import com.example.models.*;
import com.example.validator.ObjectValidator;

/**
 * Головний клас програми для демонстрації роботи валідацій та SQL-генерації.
 * <p>
 * Використовує класи User, Product, Animal, Customer, Order
 * для демонстрації реальних сценаріїв застосування.
 */
public class Main {
    public static void main(String[] args) {

        try {
            // Демонстрація для User
            User user = new User("Alice", "alice@example.com", 30);
            validateAndGenerateSQL(user);

            // Демонстрація для Product
            Product product = new Product("Laptop", 1500);
            validateAndGenerateSQL(product);

            // Демонстрація для Animal
            Animal animal = new Animal("Dog", "Rex");
            validateAndGenerateSQL(animal);

            // Демонстрація для Customer
            Customer customer = new Customer("Bob", "bob@example.com", 0);
            validateAndGenerateSQL(customer);

            // Демонстрація для неправильних даних
            User invalidUser = new User(null, "invalid@example", 25);
            validateAndGenerateSQL(invalidUser);

            Product invalidProduct = new Product("", -100);
            validateAndGenerateSQL(invalidProduct);

        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    private static void validateAndGenerateSQL(Object obj) {
        try {
            ObjectValidator.validate(obj);
            String tableSQL = SQLGenerator.generateCreateTableSQL(obj.getClass());
            String insertSQL = SQLGenerator.generateInsertSQL(obj);
            System.out.println(tableSQL);
            System.out.println(insertSQL);
        } catch (Exception e) {
            System.err.println("Помилка валідації або генерації SQL для " + obj.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}