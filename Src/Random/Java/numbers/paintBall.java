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
            float min = (float)n;
            float max = 0;
            System.out.println("Paint ball values : ");
            do {
                float paintValue = scanner.nextFloat();
                if(paintValue < min && paintValue >=1 && paintValue <= (n+1)) {
                    min = paintValue;
                }
                paintValue += 1;
                if(paintValue > max && paintValue >=1 && paintValue <= (n+1)) {
                    max = paintValue;
                }
            } while(min > 1 && max < (float)n+1);
            System.out.println("The wall is covered");
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
