package com.example.models;

import com.example.annotations.*;

/**
 * Клас для моделювання користувача.
 * <p>
 * Містить анотації для валідації полів, таких як:
 * - Обов'язкова наявність імені (@NotNull)
 * - Довжина електронної пошти (@StringLength)
 * - Вікові обмеження (@MinValue, @MaxValue)
 */
public class User {
    @NotNull
    private String name;

    @Email
    private String email;

    @MinValue(18)
    @MaxValue(100)
    private int age;


    /**
     * Конструктор для створення об'єкта User.
     *
     * @param name ім'я користувача
     * @param email електронна пошта користувача
     * @param age вік користувача
     */
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
