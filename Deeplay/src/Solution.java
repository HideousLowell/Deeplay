import java.util.Map;


public class Solution {

    public static int getResult (String cells, String race) throws IllegalArgumentException {
        if (InputChecker.isBadString(cells) || InputChecker.isBadString(race))
            throw new IllegalArgumentException("Wrong arguments");
        int result = 0;
        CostGetter parser = new CostGetter();
        CostGetter.parseCostsFromFile("info.txt");
        Map<Character, Integer> cost = parser.getCost(race);
        int [][]myMap = MapCreator.create(cells, cost, 4);
        PathFinder pathFinder = new PathFinder(myMap);
        result = pathFinder.getShortestPath(0,0, 3, 3);
        return result;
    }


}


