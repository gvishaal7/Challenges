/*
  root - all its child nodes
*/

package com.challenges.random.trees;

import java.util.LinkedList;
import java.util.Queue;

public class levelOrder {

    public static void main(String[] args) throws Exception {
        levelOrder lo = new levelOrder();
        lo.process();
    }

    public void process() {
        createTree ct = new createTree();
        Node root = ct.setUpTree();
        System.out.println("Level-order traversal");
        findLevelOrder(root);
        //System.out.println();
    }

    public void findLevelOrder(Node root) {
        if (root != null) {
            int i = 0;
            Queue<Node> myQue = new LinkedList<>();
            myQue.add(root);
            while (!myQue.isEmpty()) {
                Node tempNode = myQue.poll();
                System.out.print(tempNode.getNodeVal() + " ");
                if (tempNode.getLeftNode() != null) {
                    myQue.add(tempNode.getLeftNode());
                }
                if (tempNode.getRightNode() != null) {
                    myQue.add(tempNode.getRightNode());
                }
            }
        }
    }
}
