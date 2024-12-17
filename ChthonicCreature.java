import java.time.LocalDate;

/**
 * Представляє хтонічну істоту з атрибутами: ім'я, вид, дата першої згадки та сила атаки.
 * <p>
 * Хтонічні істоти є міфічними створіннями, які згадуються в окультних або літературних джерелах. 
 * Кожна істота має унікальне ім'я, належить до певного виду та має історичну дату першої згадки.
 * </p>
 */
public class ChthonicCreature {
    private final String name;
    private final String type;
    private final LocalDate firstMentionDate;
    private final int attackPower;

    /**
     * Конструктор для створення об'єкта хтонічної істоти.
     *
     * @param name             ім'я істоти
     * @param type             вид істоти (наприклад, Демон, Привид тощо)
     * @param firstMentionDate дата першої згадки істоти в літературі
     * @param attackPower      сила атаки істоти (позитивне ціле число)
     */
    public ChthonicCreature(String name, String type, LocalDate firstMentionDate, int attackPower) {
        this.name = name;
        this.type = type;
        this.firstMentionDate = firstMentionDate;
        this.attackPower = attackPower;
    }

    /**
     * @return ім'я істоти
     */
    public String getName() {
        return name;
    }

    /**
     * @return вид істоти
     */
    public String getType() {
        return type;
    }

    /**
     * @return дата першої згадки істоти в літературі
     */
    public LocalDate getFirstMentionDate() {
        return firstMentionDate;
    }

    /**
     * @return сила атаки істоти
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * @return кількість років з моменту першої згадки істоти
     */
    public int getYearsSinceFirstMention() {
        return LocalDate.now().getYear() - firstMentionDate.getYear();
    }

    @Override
    public String toString() {
        return String.format("Хтонічна істота {ім'я='%s', вид='%s', дата першої згадки=%s, сила атаки=%d}",
                name, type, firstMentionDate, attackPower);
    }
}
