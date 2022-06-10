import java.util.Map;

public class MapCreator {
    public static int[][] create(String cells, Map<Character, Integer> weights, int size) throws RuntimeException  {
        int[][]map = new int[size][size];
        for (int i = 0, s = 0; i < size; i++) {
            for (int j = 0; j < size && s < cells.length(); j++, s++) {
                Character key = cells.charAt(s);
                if (weights.containsKey(key))
                    map[i][j] = weights.get(cells.charAt(s));
                else
                    throw new IllegalArgumentException("Can't find cost for this type of the cell");
            }
        }
        return map;
    }
}