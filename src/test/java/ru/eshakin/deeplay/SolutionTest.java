package ru.eshakin.deeplay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void nullCellTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult(null, "Human"));
        Assertions.assertEquals("Check your arguments", exception.getMessage());
    }

    @Test
    void nullRaceTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTPPTPTTPWPP", null));
        Assertions.assertEquals("Check your arguments", exception.getMessage());
    }

    @Test
    void wrongCellsSizeTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("aboba", "Human"));
        Assertions.assertEquals("Check your arguments", exception.getMessage());
    }

    @Test
    void wrongCellTypeTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTABCPTTPWPP", "Human"));
        Assertions.assertEquals("Can't find cost of step for this type of the cell", exception.getMessage());
    }

    @Test
    void wrongRaceTest() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTPPTPTTPWPP", "Humad"));
        Assertions.assertEquals("Unknown race", exception.getMessage());
    }

    @Test
    void wrongRaceTest2() {
        RuntimeException exception = assertThrows(IllegalArgumentException.class, () ->
                Solution.getResult("STWSWTPPTPTTPWPP", "HumanSwamper"));
        Assertions.assertEquals("Unknown race", exception.getMessage());
    }

    @Test
    void HumanTest() {
        Assertions.assertEquals(10, Solution.getResult("STWSWTPPTPTTPWPP", "Human"));
    }

    @Test
    void SwamperTest() {
        Assertions.assertEquals(15, Solution.getResult("STWSWTPPTPTTPWPP", "Swamper"));
    }

    @Test
    void WoodmanTest() {
        Assertions.assertEquals(12, Solution.getResult("STWSWTPPTPTTPWPP", "Woodman"));
    }

}