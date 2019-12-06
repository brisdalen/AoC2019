package day3;

import utility.ReadInput;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Day3a {

    private String[][] testcommands;
    private String[][] commands;

    private Point[] wire1;
    private Point[] wire2;

    private ReadInput readInput;

    public void solve() {

        readInput = new ReadInput();

        try {
            testcommands = readInput.parseStrings("testinput");
            commands = readInput.parseStrings("input3");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Point> points = new ArrayList<>();
        ArrayList<Point> points2 = new ArrayList<>();

        points = commandsToPointList(testcommands[0]);
        points2 = commandsToPointList(testcommands[1]);

        System.out.println("wire1:");
        points.forEach(point -> System.out.print("[" + point.x + ":" + point.y + "]"));

        System.out.println("\nwire2:");
        points2.forEach(point -> System.out.print("[" + point.x + ":" + point.y + "]"));

    }

    public void addPointWithCommand(Point previous, String command, ArrayList<Point> outputList) {
        String direction = command.substring(0, 1);
        System.out.print(direction);
        int amount = Integer.valueOf(command.substring(1));
        System.out.println(":" + amount);

        switch (direction) {
            case "L":
                for(int i = 1; i < amount; i++) {
                    outputList.add(new Point(previous.x - i, previous.y));
                }
                break;

            case "U":
                for(int i = 1; i < amount; i++) {
                    outputList.add(new Point(previous.x, previous.y - i));
                }
                break;

            case "R":
                for(int i = 1; i < amount; i++) {
                    outputList.add(new Point(previous.x + i, previous.y));
                }
                break;

            case "D":
                for(int i = 1; i < amount; i++) {
                    outputList.add(new Point(previous.x, previous.y - i));
                }
                break;

            default:
                System.out.println("Uknown command.");
                break;
        }
    }

    public ArrayList<Point> commandsToPointList(String[] commands) {
        ArrayList<Point> points = new ArrayList<>();

        points.add(new Point(0,0));

        for(int i = 0; i < commands.length; i++) {
            addPointWithCommand(points.get(i), commands[i], points);
        }

        return points;
    }
}
