package brickwallsplit;

public class BrickWallSplit {

    
    public static void main(String[] args) {
        Wall wall;
        if(args.length == 1) {
            wall = FromFile.getFromFile(args[0]);
        }
        else {
            wall = FromConsole.getFromConsole();
        }
        System.out.println("The wall can be sliced at "+Slice.getSlice(wall)+" indexes. So that the number of bricks broken is minimum");
    }
}
