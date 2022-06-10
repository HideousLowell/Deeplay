package ru.eshakin.deeplay;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class CostGetter {
    final private static Map<String, Map<Character, Integer>> stepCostForRaces = new HashMap<>();

    /**
     * Считывает и парсит в static Map данные из файлы
     */
    public static boolean parseCostsFromFile(String fileName) {
        if (!stepCostForRaces.isEmpty()) return true;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                String input = reader.readLine();
                if (!input.contains("~")) return false;
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
        return (!stepCostForRaces.isEmpty());
    }

    /**
     * Ищет стоимость шагов для расы в Map из файла
     * @param race искомое существо
     * @return null если раса не найдена
     */
    public static Map<Character, Integer> getCost(String race) {
        return stepCostForRaces.get(race);
    }
}
