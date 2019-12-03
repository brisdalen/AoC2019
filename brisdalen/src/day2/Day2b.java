package day2;

/* Intcode programs are given as a list of integers; these values are used as
the initial state for the computer's memory (the puzzle input).

A position in memory is called an address (for example, the first value in memory is at "address 0").

Opcodes (like 1, 2, or 99) mark the beginning of an instruction. The values used immediately after
an opcode, if any, are called the instruction's parameters.

The address of the current instruction is called the instruction pointer; it starts at 0.
After an instruction finishes, the instruction pointer increases by the number of values
in the instruction; until you add more instructions to the computer, this is always 4

-----------------------------------------------------------
Determine what pair of inputs produces the output 19690720.

Each time you try a pair of inputs, make sure you first reset the computer's memory to the values in the program
(your puzzle input) - in other words, don't reuse memory from a previous attempt.
*/

public class Day2b {

    private int min = 0;
    private int max = 99;

    public void solve() {

    }
}
