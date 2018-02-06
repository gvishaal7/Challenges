/*
	Elements are inserted in level-order fashion
	eg: 
	for n = 7
	and elements 1 2 3 4 5 6 7
	The final tree will look like,

            1
		2		3
	4		56		7
	
*/

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
