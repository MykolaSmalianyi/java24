package com.example.annotations;

import java.lang.annotation.*;

/**
 * Анотація для валідації email адреси.
 *
 * Використовується для полів типу String, що містять email адреси.
 * Застосовується до полів класу.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Email {
    /**
     * Повідомлення про помилку при невалідному email.
     */
    String message() default "Невалідний формат email адреси";
}
