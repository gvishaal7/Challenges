package com.challenges.random.misc.brickwallsplit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FromFile {
    
    public static Wall getFromFile(String fileName) {
        BufferedReader br = null;
        Wall wall = null;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String input = br.readLine();
            int height = Integer.parseInt(input.split(" ")[0]);
            int length = Integer.parseInt(input.split(" ")[1]);
            wall = new Wall(height,length);
            int levelIndex = 0;
            while((input=br.readLine())!=null) {
                String[] inputValues = input.split(" ");
                Level level = new Level(inputValues.length);
                for(int i=0;i<inputValues.length;i++) {
                    level.addLength(Integer.parseInt(inputValues[i]), i);
                }
                wall.setLevel(level, levelIndex);
                levelIndex++;
            }
            br.close();
        } catch(NumberFormatException nfe) {
            System.err.println("Error while reading the file! Enter only integers!");
            System.err.println("Error message : "+nfe.getMessage());
        } catch(IOException ioe) {
            System.err.println("Error while reading the file!");
            System.err.println("Error message : "+ioe.getMessage());
        } finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch(IOException ioe) {
                System.err.println("Error while closing BufferedReader object.");
                System.err.println("Error message : "+ioe.getMessage());
            }
        }
        return wall;
    }
}
