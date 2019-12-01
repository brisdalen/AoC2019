package utility;

import java.io.*;
import java.util.ArrayList;

public class ReadInput {

    public static int[] parseInts(String filepath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            ArrayList<Integer> lines = new ArrayList<>();

            String line = reader.readLine();
            while(line != null) {
                lines.add(Integer.parseInt(line));
                line = reader.readLine();
            }

            return lines.stream().mapToInt(Integer::valueOf).toArray();
        }
    }
}
