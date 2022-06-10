package ru.eshakin.deeplay;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CostGetterTest {

    @Test
    void parseCostsFromFile_ReturnFalse_IfNotFound() {
        assertFalse(CostGetter.parseCostsFromFile("NOTFOUND.txt"));
    }
    @Test
    void parseCostsFromFile_ReturnTrue_IfExist() {
        assertTrue(CostGetter.parseCostsFromFile("data.txt"));
    }

}