import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {

    private Queue<Integer> myQueue;
    private boolean used[];
    private int minWay[];
    private int[][] graph;
    private int size;

    PathFinder(int[][] graph) {
        this.graph = graph;
        myQueue = new LinkedList<>();
        size = graph.length;
        used = new boolean[size * size];
        minWay = new int[size * size];
        Arrays.fill(minWay, Integer.MAX_VALUE);
    }

    private void visitNeighbourCell(int i, int j, int from) {
        if (i < 0 || j < 0 || i >= size || j >= size) return;
        int to = i * 4 + j;
        int tempWay = minWay[from] + graph[i][j];
        if (graph[i][j] != 0 && !used[to] && minWay[to] > tempWay) {
            minWay[to] = tempWay;
            myQueue.add(to);
        }
    }

     public int getShortestPath(int start, int finish) {
         minWay[start] = 0;
         myQueue.add(start);
        while (!myQueue.isEmpty()) {
            int value = myQueue.peek();
            myQueue.remove();
            used[value] = true;
            int i = value / 4;
            int j = value % 4;
            visitNeighbourCell(i - 1, j, value);
            visitNeighbourCell(i + 1, j, value);
            visitNeighbourCell(i, j - 1, value);
            visitNeighbourCell(i, j + 1, value);
        }
        return minWay[finish];
    }
}

