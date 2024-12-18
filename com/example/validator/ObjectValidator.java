package com.example.validator;

import com.example.annotations.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Клас для валідації об'єктів на основі анотацій.
 * <p>
 * Використовує рефлексію для перевірки полів класу на відповідність
 * правилам, заданим анотаціями.
 */
public class ObjectValidator {
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
        "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    );


    /**
     * Валідатор об'єкта на основі анотацій.
     *
     * @param obj об'єкт для валідації
     * @throws Exception якщо одне з полів не відповідає правилам
     */
    public static void validate(Object obj) throws Exception {
        List<String> errors = new ArrayList<>();
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                validateField(field, obj, errors);
            } catch (IllegalAccessException e) {
                errors.add("Помилка доступу до поля " + field.getName());
            }
        }

        if (errors.size() > 0) {
            throw new Exception(String.join("\n", errors));
        }
    }

    
    /**
     * Перевіряє значення поля об'єкта на відповідність анотаціям валідації.
     *
     * @param field поле, яке потрібно перевірити
     * @param obj об'єкт, значення поля якого перевіряється
     * @param errors список помилок, до якого додаються повідомлення про помилки валідації
     * @throws IllegalAccessException якщо доступ до поля неможливий
     */
    private static void validateField(Field field, Object obj, List<String> errors) 
        throws IllegalAccessException {
        
        Object value = field.get(obj);

        // Перевірка NotNull
        if (field.isAnnotationPresent(NotNull.class) && value == null) {
            errors.add("Поле " + field.getName() + " не може бути null");
            return;
        }

        if (value != null) {
            // Перевірка Email
            if (field.isAnnotationPresent(Email.class) && field.getType() == String.class) {
                String email = (String) value;
                if (!EMAIL_PATTERN.matcher(email).matches()) {
                    Email annotation = field.getAnnotation(Email.class);
                    errors.add(annotation.message());
                }
            }

            // Перевірка StringLength
            if (field.isAnnotationPresent(StringLength.class) && field.getType() == String.class) {
                StringLength annotation = field.getAnnotation(StringLength.class);
                String str = (String) value;
                if (str.length() < annotation.min() || str.length() > annotation.max()) {
                    errors.add("Довжина поля " + field.getName() + 
                            " має бути між " + annotation.min() + 
                            " та " + annotation.max() + " символів");
                }
            }

            // Перевірка MaxValue
            if (field.isAnnotationPresent(MaxValue.class) && field.getType() == int.class) {
                MaxValue annotation = field.getAnnotation(MaxValue.class);
                int num = (int) value;
                if (num > annotation.value()) {
                    errors.add("Значення поля " + field.getName() + 
                            " не може бути більше " + annotation.value());
                }
            }

            // Перевірка MinValue
            if (field.isAnnotationPresent(MinValue.class) && field.getType() == int.class) {
                MinValue annotation = field.getAnnotation(MinValue.class);
                int num = (int) value;
                if (num < annotation.value()) {
                    errors.add("Значення поля " + field.getName() + 
                            " не може бути менше " + annotation.value());
                }
            }
        }
    }
}
