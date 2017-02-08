/*
Given: On a wall of size 'n', paint balls are thrown. The size of the wall is an integer and the point the 
paintballs hit on the wall are of type float i.e. they can hit anywhere on the wall to float precision.
Also when a ball hits the wall, it occupies 1 unit.
eg: if the paint ball hit at 1.5, the area from 1.5 to 2.5 is covered by paint.

To find: If the wall is covered by paint.
note: if the wall size is 3, it is still considered uncoverd, if the wall is covered upto 2.9999999

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
