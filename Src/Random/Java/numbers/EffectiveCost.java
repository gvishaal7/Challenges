/*
 * question : given an array of elements, an effective cost is the min value that of sum of the max value of the sub arrays
 * whose size is the threshold 'k'
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class EffectiveCost {
    
    private static final Scanner INPUT = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        System.out.print("n : ");
        int n = INPUT.nextInt();
        System.out.print("k : ");
        int k = INPUT.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++) {
            a[i] = INPUT.nextInt();
        }
        long start = System.currentTimeMillis();
        System.out.println(getCost(a,k));
        long end = System.currentTimeMillis();
        System.out.println("Time taken : "+(end - start)+" ms");
    }
    
    /*
     * function which returns the cost
     */
    static int getCost(int[] a, int k) {
        int cost = 0;
        if(a.length != 0 && k != 0 && k <= a.length) { //base case
            if(k == 1) {
                /*
                 * if the threshold is 1, then the effective cost is the sum of
                 * all the elements in the array
                 */
                return sum(a);
            }
            else if(k == a.length) {
                /*
                 * if the threshold is equal to the array length, then the
                 * effective cost is the min value of the array
                 */
                return getMin(a);
            }
            else {
                /*
                 * the array is sliced from 1 to k, with the sub-arrays having sizes of atleast 1 and utmost k
                 * for each slice the starting position is varied from 1 to k as 
                 * k to n-1 elements would be duplicate entries, already seen in 1 to k
                 * max value of each sub-array is determined and is added together
                 * this sum is added to another list, which contains the sum for various arrangements
                 */
                ArrayList<Integer> finalMinList = new ArrayList<>();
                for(int i=1;i<=k;i++) { 
                    int start = 0;
                    while(start < k) {
                        ArrayList<Integer> maxList = new ArrayList<>();
                        int j = start;
                        for(;j<a.length;j+=i) {
                            maxList.add(getMax(Arrays.copyOfRange(a, j, j+i)));
                        }
                        if(start != 0) {
                            for(j=0;j<start;j+=i) {
                                maxList.add(getMax(Arrays.copyOfRange(a, j, start)));
                            }
                        }
                        int[] maxArray = new int[maxList.size()];
                        changeToArray(maxList, maxArray);
                        finalMinList.add(sum(maxArray));
                        start++;
                        if(i == 1) {
                            /*
                             * when slice value is 1, immaterial of the start value, we will get the same result
                             */
                            break;
                        }
                    }
                }              
                int[] finalMinArr = new int[finalMinList.size()];
                changeToArray(finalMinList,finalMinArr);
                return getMin(finalMinArr);
            }
        }
        return cost;
    }
    
    /*
     * a function to convert a given list to an array
     * @param a list contanining elements, array to which the list elements must be transfered
     */
    static int[] changeToArray(ArrayList<Integer> list, int[] array) {
        for(int i=0;i<list.size();i++) {
            array[i] = list.get(i);
        }
        return array;
    }
    
    /*
     * a function which returns the max value of the given array
     * @param array/sub-array of the input array
     */
    static int getMax(int[] a) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }
    
    /*
     * a function which returns the min value of the given array
     * @param array/sub-array of the input array
     */
    static int getMin(int[] a) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<a.length;i++) {
            if(a[i] < min) {
                min = a[i];
            }
        }
        return min;
    }
    
    /*
     * a function which returns the sum of the elements of the given array
     * @param array/sub-array of the input array
     */
    static int sum(int[] a) {
        int sum = 0;
        for(int i=0;i<a.length;i++) {
            sum += a[i];
        }
        return sum;
    }
}
