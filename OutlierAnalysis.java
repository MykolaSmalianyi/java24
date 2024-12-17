import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Аналізує викиди у значеннях сили атаки хтонічних істот.
 * <p>
 * Клас ідентифікує викиди на основі міжквартильного розмаху (IQR) 
 * і групує істот за категоріями "дані" та "викиди".
 * </p>
 */
public class OutlierAnalysis {

    /**
     * Аналізує викиди у значеннях сили атаки істот та виводить результати.
     *
     * @param creatures список хтонічних істот для аналізу
     */
    public static void analyzeOutliers(List<ChthonicCreature> creatures) {
        List<Integer> sortedPowers = creatures.stream()
                .map(ChthonicCreature::getAttackPower)
                .sorted()
                .collect(Collectors.toList());

        int size = sortedPowers.size();
        double q1 = sortedPowers.get(size / 4);
        double q3 = sortedPowers.get(3 * size / 4);
        double iqr = q3 - q1;
        double lowerBound = q1 - 0.35 * iqr;
        double upperBound = q3 + 0.35 * iqr;

        Map<String, Long> grouped = creatures.stream()
                .collect(Collectors.groupingBy(
                        creature -> {
                            double power = creature.getAttackPower();
                            return (power < lowerBound || power > upperBound) ? "викиди" : "дані";
                        },
                        Collectors.counting()
                ));

        System.out.println("Аналіз викидів:");
        System.out.println(grouped);
    }
}
