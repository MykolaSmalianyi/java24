import java.lang.annotation.*;

/**
 * Анотація для перевірки мінімального значення числового поля.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MinValue {
    /**
     * Мінімальне допустиме значення.
     *
     * @return мінімальне значення.
     */
    int value();
}
