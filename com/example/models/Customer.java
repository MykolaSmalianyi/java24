package com.example.models;

import com.example.annotations.*;

/**
 * Клас для моделювання клієнта.
 * <p>
 * Містить анотації для валідації:
 * - Ім'я обов'язкове (@NotNull)
 * - Довжина електронної пошти має бути у заданому діапазоні (@StringLength)
 * - Кількість балів лояльності має бути більше або дорівнювати 0 (@MinValue)
 */
public class Customer {
    @NotNull
    private String name;

    @Email
    private String email;

    @MinValue(0)
    private int loyaltyPoints;

    /**
     * Конструктор для створення об'єкта Customer.
     *
     * @param name ім'я клієнта
     * @param email електронна пошта клієнта
     * @param loyaltyPoints бали лояльності
     */
    public Customer(String name, String email, int loyaltyPoints) {
        this.name = name;
        this.email = email;
        this.loyaltyPoints = loyaltyPoints;
    }
}
