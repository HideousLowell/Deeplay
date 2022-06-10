package ru.eshakin.deeplay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapCreatorTest {

    @Test
    void create() {
        Map<Character, Integer> cost = new HashMap<>();
        cost.put('A', 6);
        cost.put('B', 3);
        int[][] map = MapCreator.create("AAAAAAAABBBBBBBB", cost, 4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i < 2)
                    assertEquals(6, map[i][j]);
                else
                    assertEquals(3, map[i][j]);
            }
        }
    }

    @Test
    void create_WrongCell() {
        Map<Character, Integer> cost = new HashMap<>();
        cost.put('A', 6);
        cost.put('B', 3);
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                MapCreator.create("EAAAAAAABBBBBBBB", cost, 4));
        assertEquals("Can't find cost of step for this type of the cell", exception.getMessage());
    }
}