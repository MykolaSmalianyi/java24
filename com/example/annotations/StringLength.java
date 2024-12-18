package com.example.annotations;

import java.lang.annotation.*;

/**
 * Анотація для перевірки мінімальної та максимальної довжини рядка.
 *
 * Використовується для полів типу String.
 * Застосовується до полів класу.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringLength {
    /**
     * Мінімальна довжина рядка.
     */
    int min() default 0;

    /**
     * Максимальна довжина рядка.
     */
    int max() default Integer.MAX_VALUE;
}
