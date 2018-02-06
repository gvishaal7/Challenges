/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author vishaalgopalan
 */
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
}
