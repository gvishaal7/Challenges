/*
Question : There is a wall of size 'n' and paint balls are thrown at the wall. Each paint ball takes up a size of 1 unit
and its of float data type. Get inputs until the wall is filled.

Eg: if a paint ball is thrown at 5.3, it occupies the space between 5.3 and 6.3.
Output when all the spaces on the wall are covered with the paint.
*/

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
