package trees;


public class Node {
    private int val;
    private Node left;
    private Node right;
    
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
    
    public Node getRightNode() {
        return this.right;
    }
    
    public void setLeftNode(Node left) {
        this.left = left;
    }
    
    public void setRightNode(Node right) {
        this.right = right;
    }
    
}
