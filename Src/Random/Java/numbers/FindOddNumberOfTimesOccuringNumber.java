/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
        Scanner scanner = null;
        try
        {
            scanner = new Scanner(System.in);
            System.out.println("Enter the array");
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            int element = 0;
            do
            {
                element = scanner.nextInt();
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
                if(scanner!=null) { scanner.close(); }
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
            for(int index=0;index<arrayList.size();index++) {
                number = number ^ arrayList.get(index);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return number;
    }
}
