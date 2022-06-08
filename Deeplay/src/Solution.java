import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    final static int size = 4;

    public static void main(String[] args) {
        getResult("STWSWTPPTPTTPWPP", "Human");
    }

    public static class MapCreator {
        public static int[][] create(String landscape, Map<Character, Integer> weights) throws MyException {
            int[][]map = new int[size][size];
            for (int i = 0, s = 0; i < size; i++) {
                for (int j = 0; j < size && s < landscape.length(); j++, s++) {
                    Character key = landscape.charAt(s);
                    if (weights.containsKey(key))
                        map[i][j] = weights.get(landscape.charAt(s));
                    else {
                        throw new MyException("Unknown type of the cell");
                    }
                }
            }
            return map;
        }
    }

    public static class AdjacencyMatrixCreator {
        public static int[][] create (int[][] map) {
           int matrix[][] = new int[16][16];
            for (int i = 0, m = 0; i < size; i++) {
                for (int j = 0; j < size; j++, m++) {
                    if (i < size - 1)
                        list.get(l).add(map[i + 1][j]);
                    if (i > 0)
                        list.get(l).add(map[i - 1][j]);
                    if (j < size - 1)
                        list.get(l).add(map[i][j + 1]);
                    if (j > 0)
                        list.get(l).add(map[i][j - 1]);
                }
            }
            return list;
        }
    }

    public static int getResult (String landscape, String race) {
        WeightsGetter my = new WeightsGetter();
        Map<Character, Integer> weights = new HashMap<>();
        if (my.readWeights(race, "get.txt"))
            my.getWeights(weights);
        else
            System.out.println("Weights not found");
        int [][]myMap = null;
        try {
            myMap = MapCreator.create(landscape, weights);
        } catch (MyException ex) {
            System.out.println(ex.getMessage());
        }
        int[][] adjacencyMatrix = AdjacencyMatrixCreator.create(myMap);
        System.out.println(lists);
        return 0;
    }
}


