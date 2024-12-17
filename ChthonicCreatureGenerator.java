import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Генератор хтонічних істот із випадковими атрибутами.
 * <p>
 * Клас створює нескінченний стрім об'єктів ChthonicCreature з випадковими 
 * іменами, видами, силою атаки та датами першої згадки.
 * </p>
 */
public class ChthonicCreatureGenerator {

    private static final Random RANDOM = new Random();
    private static final String[] TYPES = {"Демон", "Вампір", "Привид", "Упир", "Відьма"};
    private static final String[] NAMES = {"Азазель", "Ліліт", "Баба Яга", "Дуллахан", "Крампус"};

    /**
     * Генерує нескінченний стрім хтонічних істот.
     *
     * @return нескінченний стрім об'єктів ChthonicCreature
     */
    public static Stream<ChthonicCreature> generate() {
        return Stream.generate(() -> {
            String name = NAMES[RANDOM.nextInt(NAMES.length)];
            String type = TYPES[RANDOM.nextInt(TYPES.length)];
            LocalDate firstMentionDate = LocalDate.of(RANDOM.nextInt(1500, 2025), RANDOM.nextInt(1, 13), RANDOM.nextInt(1, 28));
            int attackPower = RANDOM.nextInt(50, 201);
            return new ChthonicCreature(name, type, firstMentionDate, attackPower);
        });
    }
}
