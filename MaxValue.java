import java.lang.annotation.*;

/**
 * Анотація для перевірки максимального значення числового поля.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MaxValue {
    /**
     * Максимальне допустиме значення.
     *
     * @return максимальне значення.
     */
    int value();
}
