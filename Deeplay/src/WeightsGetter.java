import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class WeightsGetter {
    private String line;

    public boolean readWeights(String word, String filename) {
        line = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.ready()) {
                line = reader.readLine();
                if (line.contains(word)) {
                    line = line.substring(line.lastIndexOf(word) + 1);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Wrong path");
        }
        return !line.isEmpty();
    }

    public void getWeights(Map<Character, Integer> weights) {
        String[] parts = line.split("~");
        for (String part: parts) {
            int index = 0;
            if ((index = part.indexOf('=')) != -1) {
                Character key = part.charAt(index - 1);
                Integer value = Integer.parseInt(part.substring(index + 1));
                weights.put(key, value);
            }
        }
    }
}
