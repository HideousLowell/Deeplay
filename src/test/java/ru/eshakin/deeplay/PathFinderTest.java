package ru.eshakin.deeplay;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PathFinderTest {

    @Test
    void getShortestPath_way1() {
        int[][] map = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        PathFinder pathFinder = new PathFinder(map);
        int result = pathFinder.getShortestPath(new Coordinates(0, 0), new Coordinates(3, 3));
        assertEquals(6, result);
    }

    @Test
    void getShortestPath_way2() {
        int[][] myMap = {{1, 2, 2, 6}, {1, 2, 2, 2}, {1, 2, 2, 2}, {2, 2, 6, 2}};
        PathFinder pathFinder = new PathFinder(myMap);
        int result = pathFinder.getShortestPath(new Coordinates(0, 0), new Coordinates(3, 3));
        assertEquals(10, result);
    }

    @Test
    void getShortestPath_way3() {
        int[][] myMap = {{1, 1, 1, 1}, {1, 2, 2, 1}, {1, 2, 2, 1}, {1, 1, 6, 2}};
        PathFinder pathFinder = new PathFinder(myMap);
        int result = pathFinder.getShortestPath(new Coordinates(0, 0), new Coordinates(3, 3));
        assertEquals(7, result);
    }

    @Test
    void getShortestPath_way4() {
        int[][] myMap = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}};
        PathFinder pathFinder = new PathFinder(myMap);
        int result = pathFinder.getShortestPath(new Coordinates(0, 0), new Coordinates(3, 3));
        assertEquals(1, result);
    }

}