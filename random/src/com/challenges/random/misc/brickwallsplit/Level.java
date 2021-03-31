package com.challenges.random.misc.brickwallsplit;

public class Level {
    final int bricks;
    final int[] length;
    
    public Level(int bricks) {
        this.bricks = bricks;
        this.length = new int[bricks];
    }
    
    public void addLength(int l, int index) {
        this.length[index] = l;
    } 
}
