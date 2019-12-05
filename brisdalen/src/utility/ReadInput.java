package utility;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static int[] parseLineOfInts(String filepath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            ArrayList<Integer> numbers = new ArrayList<>();

            String[] input = reader.readLine().split(",");
            for(String s : input) {
                numbers.add(Integer.parseInt(s));
            }

            return numbers.stream().mapToInt(Integer::valueOf).toArray();
        }
    }

    public String[][] parseStrings(String filepath) throws IOException {
        File file1 = new File("");
        String path = file1.getCanonicalPath() + "/brisdalen/src/day3/" + filepath;
        File input = new File(path);
        System.out.println("C:\\Users\\Bjørnar\\IdeaProjects\\AoC2019\\AoC2019\\brisdalen\\src\\day3\\input3");
        System.out.println(input.getPath());
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String[] wires = new String[2];
            wires[0] = reader.readLine();
            wires[1] = reader.readLine();

            String[] directions1 = wires[0].split(",");
            String[] directions2 = wires[1].split(",");


            String commands[][] = {directions1, directions2};

            return commands;
        }
    }
}
