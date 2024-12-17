import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Головний клас для виконання завдань, пов'язаних із генерацією та аналізом хтонічних істот.
 */
public class Main {

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        int skipCount = 100;

        // Крок 1: Генерація списку істот
        List<ChthonicCreature> creatures = ChthonicCreatureGenerator.generate()
                .filter(creature -> !creature.getType().equals("Привид")) // Фільтруємо за полем А
                .skip(skipCount)
                .limit(500)
                .collect(Collectors.toList());

        // Крок 2: Групування за полем В
        Map<String, List<ChthonicCreature>> groupedByType = creatures.stream()
                .filter(creature -> creature.getYearsSinceFirstMention() > 100 && creature.getYearsSinceFirstMention() < 500)
                .collect(Collectors.groupingBy(ChthonicCreature::getType));

        System.out.println("Групування за видом:");
        groupedByType.forEach((type, list) -> System.out.println(type + ": " + list.size()));

        // Крок 3: Обчислення статистики
        Statistics.calculateStatistics(creatures);

        // Крок 4: Аналіз викидів
        OutlierAnalysis.analyzeOutliers(creatures);
    }
}
