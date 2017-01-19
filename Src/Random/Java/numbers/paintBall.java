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
            System.out.print("Enter the length of the wall : ");
            int n = scanner.nextInt();
            float min = n;
            float max = 0;
            String choice = "y";
            System.out.println("Paint ball values : ");
            float paintValue = scanner.nextFloat();
            min = paintValue;
            paintValue += 1;
            max = paintValue;
            do {
                paintValue = scanner.nextFloat();
                if(paintValue < min && paintValue >=0 && paintValue <= (n+1)) {
                    min = paintValue;
                }
                paintValue += 1;
                if(paintValue > max && paintValue >=0 && paintValue <= (n+1)) {
                    max = paintValue;
                }
                System.out.println("min :: "+min+" max :: "+(max-1));
                if(min <= 1 && max >= (float)n+1) {
                    System.out.println("The wall is covered");
                    break;
                }
            } while(choice.equalsIgnoreCase("y"));
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
