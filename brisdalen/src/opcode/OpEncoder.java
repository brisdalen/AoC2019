package opcode;

public class OpEncoder {

    //Opcode 1 adds together numbers read from two positions and stores the result in a third position.
    public void opcode1(int pos1, int pos2, int outputpos, int[] codes) {
        codes[outputpos] = codes[pos1] + codes[pos2];
    }

    //Opcode 2 works exactly like opcode 1, except it multiplies the two inputs instead of adding them.
    public void opcode2(int pos1, int pos2, int outputpos, int[] codes) {
        codes[outputpos] = codes[pos1] * codes[pos2];
    }

    //Opcode 3 takes a single integer as input and saves it to the position given by its only parameter.
    //For example, the instruction 3,50 would take an input value and store it at address 50.
    public void opcode3(int input, int outputpos, int[] codes) {
        codes[outputpos] = input;
    }

    //Opcode 4 outputs the value of its only parameter. For example, the instruction 4,50 would output the value at address 50.
    public void opcode4(int printposition, int[] codes) {
        System.out.println(codes[printposition]);
    }
}
