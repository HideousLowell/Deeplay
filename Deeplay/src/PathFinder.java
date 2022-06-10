import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathFinder {
    public class Pair {
        public int i;
        public int j;
        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private Queue<Pair> myQueue = new LinkedList<>();
    private boolean used[][];
    private int minWay[][];
    private int[][] graph;
    private int size;

    PathFinder(int[][] graph) {
        this.graph = graph;
        size = graph.length;
        used = new boolean[size][size];
        minWay = new int[size][size];
        for (int[] line : minWay)
            Arrays.fill(line, Integer.MAX_VALUE);
    }

    private void visitNeighbourCell(int i, int j, Pair from) {
        if (i < 0 || j < 0 || i >= size || j >= size) return;
        int tempWay = minWay[from.i][from.j] + graph[i][j];
        if (!used[i][j] && minWay[i][j] > tempWay) {
            minWay[i][j] = tempWay;
            myQueue.add(new Pair(i, j));
        }
    }

     public int getShortestPath(int startI, int startJ,  int finishI, int finishJ) {
         minWay[startI][startJ] = 0;
         myQueue.add(new Pair(startI, startJ));
        while (!myQueue.isEmpty()) {
            Pair curPos = myQueue.peek();
            myQueue.remove();
            used[curPos.i][curPos.j] = true;
            visitNeighbourCell(curPos.i - 1, curPos.j, curPos);
            visitNeighbourCell(curPos.i + 1, curPos.j, curPos);
            visitNeighbourCell(curPos.i, curPos.j - 1, curPos);
            visitNeighbourCell(curPos.i, curPos.j + 1, curPos);
        }
        return minWay[finishI][finishJ];
    }
}

