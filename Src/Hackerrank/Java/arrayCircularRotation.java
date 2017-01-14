/*

Question link : https://www.hackerrank.com/challenges/circular-array-rotation

*/

import java.io.*;
import java.util.*;

public class arrayCircularRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            for(int index=0;index<n;index++){
                int temp_var = index+k;
                while (temp_var >= n) {
                    temp_var = temp_var - n;
                }
                if(temp_var == m) {
                    System.out.println(a[index]);
                }
            }
        }
    }
}
