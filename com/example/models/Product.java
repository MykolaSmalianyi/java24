package com.example.models;

import com.example.annotations.*;

/**
 * Клас для моделювання продукту.
 *
 * Містить анотації для валідації:
 * - Назва продукту обов'язкова (@NotNull)
 * - Ціна не може бути менше 0 (@MinValue)
 */
public class Product {
    @NotNull
    private String name;

    @MinValue(0)
    private int price;

    /**
     * Конструктор для створення об'єкта Product.
     *
     * @param name назва продукту
     * @param price ціна продукту
     */
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
