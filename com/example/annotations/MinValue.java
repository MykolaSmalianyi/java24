package com.example.annotations;

import java.lang.annotation.*;

/**
 * Анотація для перевірки мінімально допустимого значення числа.
 *
 * Використовується для числових полів.
 * Застосовується до полів класу.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MinValue {
    /**
     * Мінімальне допустиме значення.
     */
    int value();
}
