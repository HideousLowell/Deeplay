package ru.eshakin.deeplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void getResult_nullCellsTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult(null, "Human"));
        assertEquals("Check your arguments", exception.getMessage());
    }

    @Test
    void getResult_nullRaceTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTPPTPTTPWPP", null));
        assertEquals("Check your arguments", exception.getMessage());
    }

    @Test
    void getResult_wrongCellsSizeTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("aboba", "Human"));
        assertEquals("Check your arguments", exception.getMessage());
    }

    @Test
    void getResult_wrongCellTypeTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTABCPTTPWPP", "Human"));
        assertEquals("Can't find cost of step for this type of the cell", exception.getMessage());
    }

    @Test
    void getResult_wrongRaceTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTPPTPTTPWPP", "Humad"));
        assertEquals("Unknown race", exception.getMessage());
    }

    @Test
    void getResult_wrongRaceTest2() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTPPTPTTPWPP", "HumanSwamper"));
        assertEquals("Unknown race", exception.getMessage());
    }

    @Test
    void getResult_HumanTest() {
        assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human"));
    }

    @Test
    void getResult_SwamperTest() {
        assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper"));
    }

    @Test
    void getResult_WoodmanTest() {
        assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman"));
    }

}