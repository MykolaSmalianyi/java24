import java.lang.reflect.Field;

/**
 * Клас для валідації полів об'єктів за допомогою анотацій та рефлексії.
 */
public class Validator {

    /**
     * Валідатор, який перевіряє поля об'єкта на основі заданих анотацій.
     *
     * @param obj об'єкт, що підлягає валідації.
     * @throws IllegalArgumentException якщо знайдено невідповідність умовам валідації.
     */
    public static void validate(Object obj) throws IllegalArgumentException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);

            // Перевірка NotNull
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(obj) == null) {
                        throw new IllegalArgumentException("Поле " + field.getName() + " не може бути null");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Перевірка StringLength
            if (field.isAnnotationPresent(StringLength.class)) {
                try {
                    if (field.getType() == String.class) {
                        String value = (String) field.get(obj);
                        int maxLength = field.getAnnotation(StringLength.class).max();
                        if (value != null && value.length() > maxLength) {
                            throw new IllegalArgumentException("Поле " + field.getName() + " перевищує максимальну довжину " + maxLength);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Перевірка MaxValue
            if (field.isAnnotationPresent(MaxValue.class)) {
                try {
                    if (field.getType() == Integer.class) {
                        int value = (Integer) field.get(obj);
                        int maxValue = field.getAnnotation(MaxValue.class).value();
                        if (value > maxValue) {
                            throw new IllegalArgumentException("Поле " + field.getName() + " перевищує максимальне значення " + maxValue);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            // Перевірка MinValue
            if (field.isAnnotationPresent(MinValue.class)) {
                try {
                    if (field.getType() == Integer.class) {
                        int value = (Integer) field.get(obj);
                        int minValue = field.getAnnotation(MinValue.class).value();
                        if (value < minValue) {
                            throw new IllegalArgumentException("Поле " + field.getName() + " менше мінімального значення " + minValue);
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
