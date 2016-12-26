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
public class NumbersToExcelHeaders {

    /**
     * @param args the command line arguments
     */
    
    public static String getAlpha(int number)
    {
        String alpha = "";
        number += 64;
        alpha = Character.toString((char)number);
        return alpha;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new InputStreamReader(System.in));
            int input = 0;
            System.out.println("Enter the number : ");
            String in = br.readLine();
            try 
            {
                input = Integer.parseInt(in);
                do {
                    if(input<0) {
                        System.out.println("Enter a positive number");
                    }
                    else {
                        int num =0;
                        int deno =0;
                        String output = "";         
                            if(input <=26)
                            {
                                output = getAlpha(input);
                            }
                            else
                            {
                                do
                                {
                                    num = input/26;
                                    deno = input % 26;
                                    if(deno == 0) { num = num - 1;}
                                    output += getAlpha(num);
                                    num = num /26;
                                }while(num > 0);
                                if(deno == 0 && input > 26)
                                    deno = 26;
                                output += getAlpha(deno);
                            }
                        System.out.println("OUTPUT :: "+output);
                    }
                }while(input<0);
            }
            catch(NumberFormatException ne)
            {
                System.out.println("Enter an Integer");
            //    System.out.println(ne.toString());
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if(br!=null)
                {
                    br.close();
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
