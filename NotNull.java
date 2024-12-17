import java.lang.annotation.*;

/**
 * Анотація для перевірки, чи поле не є null.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface NotNull {
}
