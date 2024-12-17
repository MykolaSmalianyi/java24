import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * Надає статистичний аналіз для списку хтонічних істот.
 * <p>
 * Клас обчислює основні статистичні показники, такі як мінімальне, максимальне, середнє значення 
 * та стандартне відхилення сили атаки хтонічних істот.
 * </p>
 */
public class Statistics {

    /**
     * Обчислює та виводить статистику сили атаки істот.
     *
     * @param creatures список хтонічних істот для аналізу
     */
    public static void calculateStatistics(List<ChthonicCreature> creatures) {
        IntSummaryStatistics stats = creatures.stream()
                .mapToInt(ChthonicCreature::getAttackPower)
                .summaryStatistics();

        double mean = stats.getAverage();
        double stddev = Math.sqrt(creatures.stream()
                .mapToDouble(creature -> Math.pow(creature.getAttackPower() - mean, 2))
                .average().orElse(0));

        System.out.println("Мінімальна сила атаки: " + stats.getMin());
        System.out.println("Максимальна сила атаки: " + stats.getMax());
        System.out.println("Середнє значення сили атаки: " + mean);
        System.out.println("Стандартне відхилення: " + stddev);
    }
}
