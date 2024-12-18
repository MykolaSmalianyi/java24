package com.example.generators;

import java.lang.reflect.Field;

/**
 * Клас для генерації SQL-запитів на основі структури класів.
 */
public class SQLGenerator {

    /**
     * Генерує SQL-запит для створення таблиці.
     *
     * @param clazz клас, на основі якого генерується таблиця
     * @return SQL-інструкція CREATE TABLE
     */
    public static String generateCreateTableSQL(Class<?> clazz) {
        StringBuilder sql = new StringBuilder("CREATE TABLE ");
        sql.append(clazz.getSimpleName()).append(" (\n");

        for (Field field : clazz.getDeclaredFields()) {
            sql.append("  ").append(field.getName()).append(" ");
            if (field.getType().equals(String.class)) {
                sql.append("VARCHAR(255)");
            } else if (field.getType().equals(int.class)) {
                sql.append("INT");
            } else {
                sql.append("TEXT");
            }
            sql.append(",\n");
        }

        sql.setLength(sql.length() - 2); // Видалення останньої коми
        sql.append("\n);");
        return sql.toString();
    }

    /**
     * Генерує SQL-запит для вставки даних у таблицю.
     *
     * @param obj об'єкт, який потрібно вставити
     * @return SQL-інструкція INSERT INTO
     */
    public static String generateInsertSQL(Object obj) {
        Class<?> clazz = obj.getClass();
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(clazz.getSimpleName()).append(" (");

        Field[] fields = clazz.getDeclaredFields();
        StringBuilder values = new StringBuilder("VALUES (");

        for (Field field : fields) {
            field.setAccessible(true); // Дозвіл доступу до приватних полів
            sql.append(field.getName()).append(", ");
            try {
                Object value = field.get(obj);
                if (value instanceof String) {
                    values.append("'").append(value).append("', ");
                } else {
                    values.append(value).append(", ");
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Помилка доступу до поля: " + field.getName(), e);
            }
        }

        sql.setLength(sql.length() - 2); // Видалення останньої коми
        sql.append(") ");
        values.setLength(values.length() - 2); // Видалення останньої коми
        values.append(");");

        sql.append(values);
        return sql.toString();
    }
}