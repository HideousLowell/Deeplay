import java.util.HashMap;
import java.util.Map;

public class Solution {
    final static int size = 4;

    public static void main(String[] args) {
        int result = getResult("STWSWTPPTPTTPWPP", "Human");
        System.out.println(result);
    }
    public static int getResult (String cells, String race) {
        if (cells.length() != size * size)  {
            System.out.println("Error");
            return 0;
        }
        Map<Character, Integer> costs = new HashMap<>();
        int result = 0;
        try {
            CostGetter my = new CostGetter();
            my.readCosts(race, "info.txt");
            my.getCosts(costs);
            int [][]myMap = MapCreator.create(cells, costs);
            PathFinder pathFinder = new PathFinder(myMap);
            result = pathFinder.getShortestPath(0, 15);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static class MapCreator {
        public static int[][] create(String cells, Map<Character, Integer> weights) throws MyException {
            int[][]map = new int[size][size];
            for (int i = 0, s = 0; i < size; i++) {
                for (int j = 0; j < size && s < cells.length(); j++, s++) {
                    Character key = cells.charAt(s);
                    if (weights.containsKey(key))
                        map[i][j] = weights.get(cells.charAt(s));
                    else {
                        throw new MyException("Unknown type of the cell");
                    }
                }
            }
            return map;
        }
    }
}


