package day2;

import java.io.IOException;

public class Day2a {
    private int[] codes;

    public Day2a() {
        try {
            codes = utility.ReadInput.parseLineOfInts("/Users/bjornar.risdalen/IdeaProjects/AoC2019/brisdalen/src/day2/input2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void solve() {
        int[] codes = getCodes();

        System.out.print("original: ");
        for(int i : codes) {
            System.out.print(i + ",");
        }

        codes = intencode(codes, 12, 2);

        System.out.println();
        System.out.print("after opcode1: ");
        for(int i : codes) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("Solution: " + codes[0]);
    }

    public int[] intencode(int[] input, int noun, int verb) {
        // before running the program, replace position 1 with the value 12 and replace position 2 with the value 2
        input[1] = noun;
        input[2] = verb;
        for(int i = 0; i < input.length; i += 4) {
            if(input[i] == 99) {
                break;
            } else if(input[i] == 1) {
                opcode1(input[i + 1], input[i + 2], input[i + 3], input);
            } else if(input[i] == 2) {
                opcode2(input[i + 1], input[i + 2], input[i + 3], input);
            }
        }

        return input;
    }

    //Opcode 1 adds together numbers read from two positions and stores the result in a third position.
    public void opcode1(int pos1, int pos2, int outputpos, int[] codes) {
        codes[outputpos] = codes[pos1] + codes[pos2];
    }

    //Opcode 2 works exactly like opcode 1, except it multiplies the two inputs instead of adding them.
    public void opcode2(int pos1, int pos2, int outputpos, int[] codes) {
        codes[outputpos] = codes[pos1] * codes[pos2];
    }

    public int[] getCodes() {
        return codes;
    }
}
