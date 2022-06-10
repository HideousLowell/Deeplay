package ru.eshakin.deeplay;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class PathFinder {

    private final Queue<Coordinates> myQueue = new LinkedList<>();
    private final boolean[][] used;
    private final int[][] minWay;
    private final int[][] graph;
    private final int size;

    PathFinder(int[][] graph) {
        this.graph = graph;
        size = graph.length;
        used = new boolean[size][size];
        minWay = new int[size][size];
        for (int[] line : minWay)
            Arrays.fill(line, Integer.MAX_VALUE);
    }

    /**
     * Вспомогательная функция для getShortestPath
     * Делает шаг в клетку с координатами i, j
     */
    private void visitCell(int i, int j, Coordinates from) {
        if (i < 0 || j < 0 || i >= size || j >= size) return;
        int tempWay = minWay[from.i][from.j] + graph[i][j];
        if (!used[i][j] && minWay[i][j] > tempWay) {
            minWay[i][j] = tempWay;
            myQueue.add(new Coordinates(i, j));
        }
    }

    /**
     * Поиск пути на карте основе алгоритма Дейкстры
     *
     * @return -1, если координаты за пределами карты
     */
     int getShortestPath(Coordinates start, Coordinates finish) {
        minWay[start.i][start.j] = 0;
        myQueue.add(start);
        while (!myQueue.isEmpty()) {
            Coordinates curPos = myQueue.peek();
            myQueue.remove();
            used[curPos.i][curPos.j] = true;
            visitCell(curPos.i - 1, curPos.j, curPos);
            visitCell(curPos.i + 1, curPos.j, curPos);
            visitCell(curPos.i, curPos.j - 1, curPos);
            visitCell(curPos.i, curPos.j + 1, curPos);
        }
        return minWay[finish.i][finish.j];
    }
}

