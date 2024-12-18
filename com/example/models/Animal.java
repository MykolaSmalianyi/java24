package com.example.models;

import com.example.annotations.*;

/**
 * Клас для моделювання тварини.
 * <p>
 * Містить анотації для валідації:
 * - Вид обов'язковий (@NotNull)
 * - Довжина клички має бути у заданому діапазоні (@StringLength)
 */
public class Animal {
    @NotNull
    private String species;

    @StringLength(min = 3, max = 20)
    private String nickname;

    /**
     * Конструктор для створення об'єкта Animal.
     *
     * @param species вид тварини
     * @param nickname кличка тварини
     */
    public Animal(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }
}
