package com.challenges.random.misc.brickwallsplit;

public class Wall {

    final Level[] level;
    final int length;
    final int height;

    public Wall(int height, int length) {
        this.height = height;
        this.length = length;
        this.level = new Level[height];
    }

    public void setLevel(Level l, int index) {
        this.level[index] = l;
    }
}
