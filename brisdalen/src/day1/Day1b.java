package day1;

import java.io.IOException;

public class Day1b {

    private int[] masses;

    public Day1b() {
        try {
            masses = utility.ReadInput.parseInts("/Users/bjornar.risdalen/IdeaProjects/AoC2019/brisdalen/src/day1/input1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int calculateFuelModule(int mass) {
        System.out.println("[Day1b]calculate started with mass: " + mass);
        int moduleTotal = 0;
        int result = (int) (Math.floor(mass/3) - 2);
        if(result <= 0) {
            return 0;
        } else {
            moduleTotal += result;
            moduleTotal += calculateFuelModule(result);
        }

        return moduleTotal;
    }

    public int calculateTotalFuel() {
        int total = 0;
        for(int i : masses) {
            total += calculateFuelModule(i);
        }

        return total;
    }
}
