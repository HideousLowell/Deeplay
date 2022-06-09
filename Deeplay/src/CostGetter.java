import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class CostGetter {

    private String needed;
    public void readCosts(String race, String filename) throws MyException {
        if (race.isEmpty()) throw new MyException("Enter the race");
        String line = "";
        needed = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.ready()) {
                line = reader.readLine();
                if (line.substring(0, race.length()).equals(race)) {
                    needed = line.substring(line.lastIndexOf(race) + 1);
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {;
            throw new MyException("Wrong filepath");
        }
        if (needed.isEmpty()) throw new MyException("Unknown race");
    }

    public void getCosts(Map<Character, Integer> weights) throws MyException {
        String[] parts = needed.split("~");
        for (String part: parts) {
            int index = 0;
            if ((index = part.indexOf('=')) != -1) {
                Character key = part.charAt(index - 1);
                try {
                    Integer value = Integer.parseInt(part.substring(index + 1));
                    weights.put(key, value);
                } catch (NumberFormatException e) {
                    throw new MyException("Parse error");
                }
            }
        }
    }
}
