/*
    left - right - root
*/
package com.challenges.random.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class postOrder {
    
    public static void main(String[] args) throws Exception {
        postOrder op = new postOrder();
        op.process();
    }
    
    public void process() {
        createTree ct = new createTree();
        Node root = ct.setUpTree();
        System.out.println("Post-Order traversal");
        findPostOrder(root);
        System.out.println();
    }
    
    public void findPostOrder(Node root) {
        if(root != null) {
            findPostOrder(root.getLeftNode());
            findPostOrder(root.getRightNode());
            System.out.print(root.getNodeVal()+" ");
        }
    }

    public List<Integer> postorderTraversal(Node root) {
        if(root == null) {
            return (new ArrayList<>());
        }
        List<Integer> outputList = new ArrayList<>();
        Stack<Node> tempStack = new Stack<>();
        tempStack.add(root);
        while(!tempStack.isEmpty()) {
            Node top = tempStack.peek();
            if(top.left != null) {
                tempStack.add(top.left);
                top.left = null;
            }
            else if(top.right != null) {
                tempStack.add(top.right);
                top.right = null;
            }
            else {
                outputList.add(top.val);
                tempStack.pop();
            }
        }
        return outputList;
    }
}
