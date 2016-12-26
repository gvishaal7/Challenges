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
public class FindNNumberOfElementsFromASquareSpiral {
    
    private static ArrayList coordinates;
    private static int xCoordinate = 0;
    private static int yCoordinate = 0;
    
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = null;
        try {
            int number = 0;
            drawTheSpiral();
            do {
                System.out.println("Enter a number : ");
                bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                number = Integer.parseInt(bufferedReader.readLine());
                if(number<=0) {
                    System.out.println("Enter a positive number");
                }
                else {
                    System.out.println("The spiral coordinates upto : "+number);
                    for(int index=0;index<number;index++) {
                        System.out.print(coordinates.get(index));
                    }
                    System.out.println();
                }
            } while(number<=0);        
        } catch(NumberFormatException ne) {
            System.out.println("Please enter a number");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(bufferedReader!=null) {
                    bufferedReader.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
                
        }
    }
    
    private static void clockwise(String direction) {
        try {
            if(direction.equalsIgnoreCase("top")) {
                
            }
            else if(direction.equalsIgnoreCase("bottom")) {
                
            } 
            else if(direction.equalsIgnoreCase("left")) {
                
            }
            else if(direction.equalsIgnoreCase("right")) {
                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void antiClockwise(String direction) {
        try {
            if(direction.equalsIgnoreCase("top")) {
                
            }
            else if(direction.equalsIgnoreCase("bottom")) {
                
            } 
            else if(direction.equalsIgnoreCase("left")) {
                
            }
            else if(direction.equalsIgnoreCase("right")) {
                
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void operations(String rotation, String direction) {
        try {
            if(rotation.equalsIgnoreCase("clock")) {
                clockwise(direction);
            }
            else if(rotation.equalsIgnoreCase("anti")) {
                antiClockwise(direction);
            }
            else {
                System.err.println("Wrong rotation!");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    
    }
    
    private static void drawTheSpiral() {
        //BufferedReader br = null;
        try {
            //br = new BufferedReader(new InputStreamReader(System.in));
            coordinates = new ArrayList<>();
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
            //System.out.println("Enter the no. of spirals");
            int size = 8*10;//Integer.parseInt(br.readLine())*8;
            yCoordinate++;
            while(size >0) {
                positiveYAxis();        //1
                positiveXY();           //2
                positiveXAxis();        //3
                negativeYPositiveX();   //4
                negativeYAxis();        //5
                negativeXY();           //6
                negativeXAxis();         //7
                negativeXPositiveY();   //8
                size=size-8;
            }
            
//            String rotation = "";
//            do {
//                System.out.println("Enter the type of rotation");
//                System.out.println("CLOCKWISE (clock) or ANTI-CLOCKWISE (anti)");
//                rotation = br.readLine(); 
//            } while(!rotation.equalsIgnoreCase("clock") && !rotation.equalsIgnoreCase("anti"));
//            String direction = "";
//            do {
//                System.out.println("Enter the direction in which you want the elements");
//                System.out.println("TOP or BOTTOM or LEFT or RIGHT");
//                direction = br.readLine();
//            } while(!direction.equalsIgnoreCase("top") && !direction.equalsIgnoreCase("bottom") && !direction.equalsIgnoreCase("right") && !direction.equalsIgnoreCase("left"));
//            operations(rotation,direction);
            
            System.out.println("THE CO-ORDINATES IN THE SPIRAL : ");
            for(int index=0;index<coordinates.size();index++) {
                System.out.print(coordinates.get(index).toString());
            }
            System.out.println();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                //if(br!=null) {
                  //  br.close();
                //}
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void positiveYAxis() {
        try {
            xCoordinate -= xCoordinate;
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void positiveXY() {
        try {
            xCoordinate = yCoordinate;
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void positiveXAxis() {
        try {
            yCoordinate -= yCoordinate;
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void negativeYPositiveX() {
        try {
            yCoordinate = xCoordinate*(-1);
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void negativeYAxis() {
            try {
                xCoordinate -= xCoordinate;
                ArrayList currentCoordList = new ArrayList();
                currentCoordList.add(xCoordinate);
                currentCoordList.add(yCoordinate);
                coordinates.add(currentCoordList);
            } catch(Exception e) {
                e.printStackTrace();
            }
    }

    private static void negativeXY() {
        try {
            xCoordinate = yCoordinate;
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private static void negativeXAxis() {
        try {
            yCoordinate -= yCoordinate;
            ArrayList currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void negativeXPositiveY() {
        try {
            yCoordinate = xCoordinate*(-1);
            ArrayList currentCoordList = new ArrayList();
//            currentCoordList.add(xCoordinate);
//            currentCoordList.add(yCoordinate);
//            coordinates.add(currentCoordList);
            
            yCoordinate++;
            //currentCoordList = new ArrayList();
            currentCoordList.add(xCoordinate);
            currentCoordList.add(yCoordinate);
            coordinates.add(currentCoordList);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
