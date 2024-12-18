package com.example.models;

import com.example.annotations.*;

/**
 * Клас для моделювання замовлення.
 * <p>
 * Містить анотації для валідації:
 * - Номер замовлення обов'язковий (@NotNull)
 * - Кількість має бути більше або дорівнювати 1 (@MinValue)
 * - Загальна ціна має бути більше або дорівнювати 0 (@MinValue)
 */
public class Order {
    @NotNull
    private String orderId;

    @MinValue(1)
    private int quantity;

    @MinValue(0)
    private int totalPrice;

    /**
     * Конструктор для створення об'єкта Order.
     *
     * @param orderId номер замовлення
     * @param quantity кількість товарів
     * @param totalPrice загальна ціна
     */
    public Order(String orderId, int quantity, int totalPrice) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}
