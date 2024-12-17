import java.lang.annotation.*;

/**
 * Анотація для перевірки максимальної довжини рядка.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface StringLength {
    /**
     * Максимальна довжина рядка.
     *
     * @return максимальна кількість символів.
     */
    int max();
}
