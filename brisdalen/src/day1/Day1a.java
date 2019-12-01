package day1;

import java.io.IOException;

public class Day1a {

    private int[] masses;

    public Day1a() {
        try {
            masses = utility.ReadInput.parseInts("/Users/bjornar.risdalen/IdeaProjects/AoC2019/brisdalen/src/day1/input1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Day1a(boolean masses) { }

    public int calculateFuelModule(int mass) {
        return (int) (Math.floor(mass/3) - 2);
    }

    public int calculateTotalFuel() {
        int total = 0;
        for(int i : masses) {
            total += calculateFuelModule(i);
        }

        return total;
    }
}
