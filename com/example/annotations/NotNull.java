package com.example.annotations;

import java.lang.annotation.*;

/**
 * Анотація для перевірки того, що значення поля не є null.
 *
 * Використовується для валідації полів, які обов'язково мають бути заповнені.
 * Застосовується до полів класу.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
}
