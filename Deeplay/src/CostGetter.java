import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CostGetter {
    final private static Map<String, Map<Character, Integer>> stepCostForRaces;

    static  {
        stepCostForRaces = new HashMap<>();
    }

    /**
     * Считывает и парсит в static Map данные из файлы
     * @param newFileName имя файла с даннными
     */
    public static void parseCostsFromFile(String newFileName) {
        if (!stepCostForRaces.isEmpty()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(newFileName))) {
            while (reader.ready()) {
                String input = reader.readLine();
                String[] parts = input.split("~");
                String race = parts[0];
                Map <Character, Integer> stepCosts = new HashMap<>();
                for (int i = 1; i < parts.length; i++) {
                    Character cellType = parts[i].charAt(0);
                    Integer cost = Integer.parseInt(parts[i].substring(2));
                    stepCosts.put(cellType, cost);
                }
                stepCostForRaces.put(race, stepCosts);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ищет стоимость шагов для расы в Map из файла
     * @param race - искомое существо
     * @return null если раса не найдена
     */
    public static Map<Character, Integer> getCost(String race) {
        return stepCostForRaces.get(race);
    }
}
