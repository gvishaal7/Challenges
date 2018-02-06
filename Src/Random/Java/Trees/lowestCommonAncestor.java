/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author vishaalgopalan
 */
public class lowestCommonAncestor {
    
    public static void main(String[] args) throws Exception {
        lowestCommonAncestor lca = new lowestCommonAncestor();
        lca.process();
    }
    
    public void process() {
        createTree ct = new createTree();
        Node root = ct.setUpTree();
        /*printTree(root);
        System.out.println(); */
        findLCA(root,6,7);
    }
    
    public void findLCA(Node root, int val1, int val2) {
        if(root == null) {
            return;
        }
        else if(root.getNodeVal() == val1) {
            System.out.println(val1);
        }
        else if(root.getNodeVal() == val2) {
            System.out.println(val2);
        }
        else {
            Stack<Integer> path1 = new Stack<>();
            Stack<Integer> path2 = new Stack<>();
            Node temp = root;
            path1 = findPath(temp,val1);
            temp = root;
            path2 = findPath(temp,val2);
            boolean flag = false;
            int common = 0;
            while(!path1.isEmpty() && !path2.isEmpty()) {
                int tree1 = path1.pop();
                int tree2 = path2.pop();
                if(tree1 == tree2) {
                    common = tree1;
                    flag = true;
                }else {
                    break;
                }
            }
            if(flag) {
                System.out.println("The common ancester is : "+common);
            }
            else {
                System.out.println("There is no common ancester");
            }
        }
    }
    
    public Stack<Integer> findPath(Node root,int val) {
        if(root == null) {
            return null;
        }
        else if(root.getNodeVal() == val) {
            Stack<Integer> myStack = new Stack<>();
            myStack.push(root.getNodeVal());
            return myStack;
        }
        else {
            Stack<Integer> leftPath = findPath(root.getLeftNode(),val);
            if(leftPath != null) {
                leftPath.push(root.getNodeVal());
                return leftPath;
            }
            Stack<Integer> rightPath = findPath(root.getRightNode(),val);
            if(rightPath != null) {
                rightPath.push(root.getNodeVal());
                return rightPath;
            }
        }
        return null;
    }
    
    
    
    public void printTree(Node root) {
        if(root != null)
        {
            System.out.print(root.getNodeVal()+" ");
            printTree(root.getLeftNode());
            printTree(root.getRightNode());
        }
    }
}
