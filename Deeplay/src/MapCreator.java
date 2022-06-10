import java.util.Map;

public class MapCreator {

    /**
     * Создает и заполняет карту данными о стоимости шагов по клеткам
     * @return карту размера size x size
     */
    public static int[][] create(String cells, Map<Character, Integer> cost, int size) throws IllegalArgumentException  {
        int[][]map = new int[size][size];
        for (int i = 0, s = 0; i < size; i++) {
            for (int j = 0; j < size && s < cells.length(); j++, s++) {
                Character key = cells.charAt(s);
                if (cost.containsKey(key))
                    map[i][j] = cost.get(cells.charAt(s));
                else
                    throw new IllegalArgumentException("Can't find cost of step for this type of the cell");
            }
        }
        return map;
    }
}