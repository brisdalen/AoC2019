package day1;

public class Day1Solutions {
    public static void main(String[] args) {
        Day1a day1 = new Day1a();
        int total = day1.calculateTotalFuel();
        System.out.println("a solution: " + total);

        Day1b day1b = new Day1b();
        int total2 = day1b.calculateTotalFuel();
        System.out.println("b solution: " + total2);
    }
}
