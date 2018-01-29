/*
Link to the question : https://www.hackerrank.com/challenges/ctci-contacts
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class triesContacts {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Hashtable<String,Integer> parNameList = new Hashtable<String,Integer>();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equalsIgnoreCase("add")) {
                addContact(contact,parNameList);
            }
            else if(op.equalsIgnoreCase("find")) {
                int noOfContacts = findContact(contact,parNameList);
                System.out.println(noOfContacts);
            }
        }
    }
    
    public static void addContact(String name,Hashtable<String,Integer> parNameList) {
        try {
            String temp = "";
            for(int index=0;index<name.length();index++) {
                temp += String.valueOf(name.charAt(index));
                if(parNameList.containsKey(temp)) {
                    int parName_value = parNameList.get(temp);
                    parName_value++;
                    parNameList.put(temp,parName_value);
                }
                else {
                    parNameList.put(temp,1);
                }
                   
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int findContact(String parName,Hashtable<String,Integer> parNameList) {
        int output = 0;
        try{
           if(parNameList.containsKey(parName)) {
               output = parNameList.get(parName);
           }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return output;
    }
}
