package com.example.annotations;

import java.lang.annotation.*;

/**
 * Анотація для перевірки максимально допустимого значення числа.
 *
 * Використовується для числових полів.
 * Застосовується до полів класу.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxValue {
    /**
     * Максимальне допустиме значення.
     */
    int value();
}
