import java.util.Map;


public class Solution {

    final private static int size = 4;

    public static int getResult (String cells, String race) throws IllegalArgumentException {
        if (cells.length() != size * size || InputChecker.isBadString(cells) || InputChecker.isBadString(race))
            throw new IllegalArgumentException("Check your arguments");
        if (!CostGetter.parseCostsFromFile("data.txt"))
            return - 1;
        Map<Character, Integer> cost = CostGetter.getCost(race);
        if (cost == null)
            throw new IllegalArgumentException("Unknown race");
        int [][]myMap = MapCreator.create(cells, cost, 4);
        PathFinder pathFinder = new PathFinder(myMap);
        return pathFinder.getShortestPath(new Coordinates(0, 0), new Coordinates(3, 3));
    }


}


