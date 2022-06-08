import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {
     public int getShortestPath(int[][] graph, int start, int finish) {
        Queue<Integer> myQueue = new LinkedList<>();
        int size = graph.length;
        boolean used[] = new boolean[size];
        int minRoad[] = new int[size];
        Arrays.fill(minRoad, Integer.MAX_VALUE);
        minRoad[start] = 0;
        myQueue.add(start);
        while (!myQueue.isEmpty()) {
            int value = myQueue.peek();
            myQueue.remove();
            used[value] = true;
            for (int i = 0; i < size; i++) {
                int tempRoad = minRoad[value] + graph[value][i];
                if (graph[value][i] != 0 && used[i] == false && minRoad[i] > tempRoad) {
                    minRoad[i] = tempRoad;
                    myQueue.add(i);
                }
            }
        }
        return minRoad[finish];
    }
}

