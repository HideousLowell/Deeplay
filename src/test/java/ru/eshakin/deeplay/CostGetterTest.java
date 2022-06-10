package ru.eshakin.deeplay;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostGetterTest {

    @Test
    void parseCostsFromFile() {
        Assertions.assertTrue(CostGetter.parseCostsFromFile("data.txt"));
        Assertions.assertFalse(CostGetter.parseCostsFromFile("NOTFOUND.txt"));
    }
}