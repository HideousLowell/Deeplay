package ru.eshakin.deeplay;

class InputChecker {
    static boolean isBadString(String string) throws IllegalArgumentException {
        return string == null || string.isEmpty();
    }
}
