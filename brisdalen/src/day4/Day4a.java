package day4;

public class Day4a {

    private String range = "356261-846303";

    private int low, high;

    public Day4a() {
        low = Integer.parseInt(range.split("-")[0]);
        high = Integer.parseInt(range.split("-")[1]);
        System.out.println("low: " + low);
        System.out.println("high: " + high);
    }

    public void solve() {
        System.out.println("Solution: " + validPasswords(low, high));
    }

    public int validPasswords(int low, int high) {
        int count = 0;

        for(int i = low; i <= high; i++) {
            if(noDecreasingNumbers(i) && containsPair(i)) {
                count++;
            }
        }

        return count;
    }

    private boolean noDecreasingNumbers(int number) {
        boolean noDecreasingNumbers = true;
        int[] temp = integerToArray(number);

        for(int i = 0; i < temp.length-1; i++) {
            if(temp[i] > temp[i+1]) {
                noDecreasingNumbers = false;
                break;
            }
        }

        return noDecreasingNumbers;
    }

    private boolean containsPair(int number) {
        boolean containsPair = false;
        int[] temp = integerToArray(number);

        for(int i = 0; i < temp.length-1; i++) {
            if(temp[i] == temp[i+1]) {
                containsPair = true;
            }
        }

        return containsPair;
    }

    private int[] integerToArray(int number) {
        String asString = Integer.toString(number);
        int[] temp = new int[asString.length()];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = Character.getNumericValue(asString.charAt(i));
        }

        return temp;
    }
}
