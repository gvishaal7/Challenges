/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package challenges;

import java.io.*;
import java.util.*;

/**
 *
 * @author vishaalgopalan
 */
public class paintBall {
    public static void main(String[] args) throws Exception {
        Scanner scanner = null;
        try{
            scanner = new Scanner(System.in);
            System.out.print("Enter the size of the wall : ");
            int wall_length = scanner.nextInt();
            System.out.println("Enter an alphabet/string to terminate");
            String value = scanner.next();
            String pattern = "(.*)[a-zA-z](.*)";
            Map<Integer,Integer> points_on_wall = new HashMap<>();
            while(!value.matches(pattern)) {
                float on_wall = Float.parseFloat(value);
                int on_wall_int = (int)on_wall;
                if(on_wall_int >0) {
                    int next_on_wall = on_wall_int+1;
                    if(!points_on_wall.containsKey(on_wall_int)) {
                        points_on_wall.put(on_wall_int, 1);
                    }
                    if(!points_on_wall.containsKey(next_on_wall)) {
                        points_on_wall.put(next_on_wall, 1);
                    }
                    if(points_on_wall.size() >= wall_length){
                        break;
                    }
                }
                value = scanner.next();
            }
            if(points_on_wall.size() >= wall_length) {
                System.out.println("The wall is covered");
            }
            else {
                System.out.println("The wall is not covered");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(scanner !=null){ scanner.close(); }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}
