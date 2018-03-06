/*
  The following program calculates the area under a bar graph.
  The co-ordinates are assumed to be integral values.
  The input format if the input is a file,
  'start' 'end' 'height'
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.BiConsumer;

public class BarGraphArea {
    
    public static void main(String[] args) throws Exception {
        BarGraphArea bga = new BarGraphArea();
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        if(args.length ==1) {
            coordinates = bga.getFromFile(args[0]);
        }
        else {
            coordinates = bga.getFromConsole();
        }
        int area = 0;
        if(!coordinates.isEmpty()) {
            area = bga.findArea(coordinates);
        }
        System.out.println("Area : "+area);
    }
    
    /*
      function to read from a file
    */
    public ArrayList<ArrayList<Integer>> getFromFile(String fileName) {
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(fileName)));
            String input = "";
            while((input = br.readLine())!=null) {
                String[] inputValues = input.split(" ");
                if(inputValues.length != 3) {
                    System.err.println("The input file is not in the required format!");
                    System.out.println("File format : start end height");
                    break;
                }
                int start = Integer.parseInt(inputValues[0]);
                int end = Integer.parseInt(inputValues[1]);
                int height = Integer.parseInt(inputValues[2]);
                ArrayList<Integer> tempList = new ArrayList<>();
                tempList.add(start);
                tempList.add(end);
                tempList.add(height);
                coordinates.add(tempList);
            }
        } catch(IOException ioe) {
            System.err.println("Error while reading the file.\nError message : "+ioe.getMessage());
        } catch(NumberFormatException nfe) {
            System.err.println("Error parsing the given file. Check the file contents.\nError message : "+nfe.getMessage());
        } 
        finally {
            try {
                if(br != null) {
                    br.close();
                }
            } catch(IOException ioe) {
                System.err.println("Error while closing BufferedReader.\nError message : "+ioe.getMessage());
            }
        }
        return coordinates;
    }
    
    /*
      function to read from console
    */
    public ArrayList<ArrayList<Integer>> getFromConsole() {
        ArrayList<ArrayList<Integer>> coordinates = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the input in the following format.");
        System.out.println("start end height");
        do {
            int start = in.nextInt();
            int end = in.nextInt();
            int height = in.nextInt();
            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(start);
            tempList.add(end);
            tempList.add(height);
            coordinates.add(tempList);
        } while(in.hasNextInt());
        in.close();
        return coordinates;
    }
    
    /*
      function to find the area.
      methodology,
          each x-coordinate is mapped to a y-coordinate.
          if a y-coordinate with higher value is read, then the exsisting y-coordinate is replaced with the higher value.
          the final map will have all each x-coodinate mapped to its highest y-coordinate.
      This is done to take care of overlapping areas.
      The effective area will be the sum of all the values in the map.
    */
    public int findArea(ArrayList<ArrayList<Integer>> coordinates) {
        int area = 0;
        HashMap<Integer,Integer> maxMap = new HashMap<>();
        for(int i=0;i<coordinates.size();i++) {
            ArrayList<Integer> tempList = coordinates.get(i);
            int start = tempList.get(0);
            int end = tempList.get(1);
            int height = tempList.get(2);
            if(end < start) {
                System.err.println("The end point is less than start point at"+start+" "+end+" "+height);
                return 0;
            }
            for(int j=start;j<end;j++) {
                if(maxMap.containsKey(j)) {
                    if(height > maxMap.get(j)) {
                        maxMap.put(j, height);
                    }
                }
                else {
                    maxMap.put(j,height);
                }
            }
        }
        area = maxMap.keySet().stream().map((d) -> maxMap.get(d)).reduce(area, (accumulator, _item) -> accumulator + _item);
        return area;
    }   
}
