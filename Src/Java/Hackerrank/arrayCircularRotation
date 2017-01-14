/*
John Watson performs an operation called a right circular rotation on an array of integers, . After performing one right circular rotation operation, the array is transformed from to .

Watson performs this operation times. To test Sherlock's ability to identify the current element at a particular position in the rotated array, Watson asks queries, where each query consists of a single integer, , for which you must print the element at index in the rotated array (i.e., the value of ).

Input Format

The first line contains space-separated integers, , , and , respectively.
The second line contains space-separated integers, where each integer describes array element (where ).
Each of the subsequent lines contains a single integer denoting .

Constraints

Output Format

For each query, print the value of the element at index of the rotated array on a new line.
*/

package src.java.hackerrank;

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
                while (temp_var>= n) {
                    temp_var = temp_var - n;
                }
                if(temp_var == m) {
                    System.out.println(a[index]);
                }
            }
        }
    }
}
