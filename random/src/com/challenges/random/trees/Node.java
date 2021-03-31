package com.challenges.random.trees;

public class Node {
    protected int val;
    protected Node left;
    protected Node right;

    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int getNodeVal() {
        return this.val;
    }

    public Node getLeftNode() {
        return this.left;
    }

    public void setLeftNode(Node left) {
        this.left = left;
    }

    public Node getRightNode() {
        return this.right;
    }

    public void setRightNode(Node right) {
        this.right = right;
    }

}
