package trees;

import java.util.Scanner;
import java.util.Stack;

public class lowestCommonAncestor {
    
    public static void main(String[] args) throws Exception {
        lowestCommonAncestor lca = new lowestCommonAncestor();
        lca.process();
    }
    
    public void process() {
        createTree ct = new createTree();
        Node root = ct.setUpTree();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two node values");
        System.out.print("node 1 : ");
        int val1 = in.nextInt();
        System.out.print("node 2 : ");
        int val2 = in.nextInt();
        findLCA(root,val1,val2);
    }
    
    public void findLCA(Node root, int val1, int val2) {
        if(root == null) {
            return;
        }
        else if(root.getNodeVal() == val1) {
            System.out.println("The common ancester is : "+val1);
        }
        else if(root.getNodeVal() == val2) {
            System.out.println("The common ancester is : "+val2);
        }
        else {
            Node temp = root;
            Stack<Integer> path1 = findPath(temp,val1);
            temp = root;
            Stack<Integer> path2 = findPath(temp,val2);
            int common = 0;
            if(path1 == null || path2 == null) {
                System.out.println("There is no common ancester");
            }
            else {
                while(!path1.isEmpty() && !path2.isEmpty()) {
                    int tree1 = path1.pop();
                    int tree2 = path2.pop();
                    if(tree1 == tree2) {
                        common = tree1;
                    } else {
                        break;
                    }
                }
                System.out.println("The common ancester is : "+common);
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
}
