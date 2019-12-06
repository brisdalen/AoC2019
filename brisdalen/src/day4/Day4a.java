package day4;

public class Day4a {

    private final String ORIGINAL_INPUT = "356261-846303";
    private String range = "356261-846303";

    private int low, high;

    public Day4a() {
        low = Integer.parseInt(range.split("-")[0]);
        high = Integer.parseInt(range.split("-")[1]);
        System.out.println("low: " + low);
        System.out.println("high: " + high);
    }

    public void solve() {
        long start = System.currentTimeMillis();
        System.out.println("Solution: " + validPasswords(low, high));
        long end = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (end - start));
    }

    public int validPasswords(int low, int high) {
        int count = 0;

        for(int i = low; i <= high; i++) {
            if(noDecreasingNumbers(i) && containsValidPair(i)) {
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

    private boolean containsValidPair(int number) {
        int validPairs = 0;
        int[] temp = integerToArray(number);

        for(int i = 0; i < temp.length-1; i++) {
            // Sjekk de 4 første sifferene
            if(i < 4) {
                // Se etter et par
                if (temp[i] == temp[i + 1]) {
                    // Se om paret ikke er en del av en større gruppe like tall (eks. ikke 444)
                    if(i == 0) {
                        if (temp[i + 1] != temp[i + 2]) {
                            validPairs++;
                            // Ikke vits å sjekke neste da i og i+1 allerede er et par
                            i++;
                        }else {
                            // Om paret er en del av en større gruppe tall flyttes pekeren (i) 2 til høyre
                            // hvis pekeren er på første eller andre siffer
                            if(i <= 1) {
                                i += 2;
                                // Hvis pekeren er på 3. siffer (2) og er en del av flere like siffer
                                // er det ingen vits å sjekke resten av tallene
                            } else if(i == 2 || i == 3) {
                                break;
                            }
                        }
                    } else {
                        if(temp[i+1] != temp[i+2] && temp[i] != temp[i-1]) {
                            validPairs++;
                            // Ikke vits å sjekke neste da i og i+1 allerede er et par
                            i++;
                        } else {
                            // Om paret er en del av en større gruppe tall flyttes pekeren (i) 2 til høyre
                            // hvis pekeren er på første eller andre siffer
                            if(i <= 1) {
                                i += 2;
                                // Hvis pekeren er på 3. siffer (2) og er en del av flere like siffer
                                // er det ingen vits å sjekke resten av tallene
                            } else if(i == 2 || i == 3) {
                                break;
                            }
                        }
                    }
                }
            // Sjekk de 2 siste sifferene
            } else if(i == 4) {
                // Sjekk om de 2 siste er et par, men ikke like det 3. siste sifferet
                if(temp[i] == temp[i + 1] && temp[i] != temp[i-1]) {
                    validPairs++;
                    break;
                } else {
                    break;
                }
            }
        }

        return validPairs > 0;
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
