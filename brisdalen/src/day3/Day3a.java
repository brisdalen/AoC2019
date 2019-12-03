package day3;

import java.io.IOException;

public class Day3a {

    private String[][] commands;

    public void solve() {
        try {
            commands = utility.ReadInput.parseStrings("/Users/bjornar.risdalen/IdeaProjects/AoC2019/brisdalen/src/day3/input3");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
