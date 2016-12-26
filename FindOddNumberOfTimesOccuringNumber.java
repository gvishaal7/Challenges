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
public class FindOddNumberOfTimesOccuringNumber {
    
    private static int[] myArray;
    public static void main(String[] args)
    {
        BufferedReader br = null; 
        try
        {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the array");
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int element = 0;
            do
            {
                element = Integer.parseInt(br.readLine());
                if(element != 0)
                {
                    arrayList.add(element);
                }
            }while(element != 0);
            
            int number = computeOddNumber(arrayList);
            if(number != 0)
                System.out.println("OUTPUT :: "+number);
        }
        catch(NumberFormatException ne)
        {
            System.out.println("ENTER AN INTEGER");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(br!=null) { br.close(); }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static int computeOddNumber(ArrayList<Integer> arrayList)
    {
        int number = 0;
        try
        {
            int max = arrayList.get(0);
            for(int i=1;i<arrayList.size();i++)
            {
                if(arrayList.get(i) > max)
                {
                    max =arrayList.get(i);
                }
            }
            myArray = new int[max+1];
            for(int i=0;i<arrayList.size();i++)
            {
                myArray[arrayList.get(i)]++;
            }
            for(int i=0;i<myArray.length;i++)
            {
                if(myArray[i] % 2 != 0)
                {
                    number = myArray[i];
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return number;
    }
}
