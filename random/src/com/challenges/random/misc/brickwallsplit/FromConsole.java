package com.challenges.random.misc.brickwallsplit;

import java.util.Scanner;

public class FromConsole {

    public static Wall getFromConsole() {
        Wall wall = null;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the height and length of wall in a line (space separated)");
        int height = in.nextInt();
        int length = in.nextInt();
        wall = new Wall(height, length);
        int levelIndex = 0;
        String input = in.nextLine();
        System.out.println("Enter the length of each brick in space separated format");
        for (int i = 0; i < height; i++) {
            input = in.nextLine();
            String[] inputValues = input.split(" ");
            Level level = new Level(inputValues.length);
            for (int j = 0; j < inputValues.length; j++) {
                level.addLength(Integer.parseInt(inputValues[j]), j);
            }
            wall.setLevel(level, levelIndex);
            levelIndex++;
        }
        in.close();
        return wall;
    }
}
