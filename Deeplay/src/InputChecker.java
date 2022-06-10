public class InputChecker {

    public static boolean isBadString(String string) throws IllegalArgumentException {
        return string == null || string.isEmpty();
    }
}
