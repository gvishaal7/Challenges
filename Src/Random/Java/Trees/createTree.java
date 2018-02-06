package trees;

import java.util.Scanner;

public class createTree {

    public Node setUpTree() {
        Node root = null;
        Scanner in = new Scanner(System.in);
        System.out.print("nodes : ");
        int n = in.nextInt();
        System.out.println("Enter values");
        for(int i=0;i<n;i++) {
            root = createTree(root,in.nextInt());
        }
        return root;
    }
    
    public Node createTree(Node root,int val) {
        if(root == null) {
            root = new Node(val);
        }
        else {
            Node temp = root; 
            while(temp != null) {
                Node tempNode = new Node(val);
                if(temp.getLeftNode() == null) {
                    temp.setLeftNode(tempNode);
                    return root;
                }
                else if(temp.getRightNode() == null) {
                    temp.setRightNode(tempNode);
                    return root;
                }
                else if(temp.getLeftNode().getLeftNode() == null || temp.getLeftNode().getRightNode()==null) {
                    temp = temp.getLeftNode();
                }
                else if(temp.getRightNode().getLeftNode() == null || temp.getRightNode().getRightNode() == null) {
                    temp = temp.getRightNode();
                }
                else {
                    temp = temp.getLeftNode();
                }
                
            }
        }
        return root;
    }
}
