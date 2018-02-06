/*
    root - left - right
*/
package trees;

public class preOrder {
    
    public static void main(String[] args) throws Exception {
        preOrder po = new preOrder();
        po.process();
    }
    
    public void process() {
        createTree ct = new createTree();
        Node root = ct.setUpTree();
        System.out.println("Pre-Order traversal");
        findPreOrder(root);
        System.out.println();
    }
    
    public void findPreOrder(Node root) {
        if(root != null) {
            System.out.print(root.getNodeVal()+" ");
            findPreOrder(root.getLeftNode());
            findPreOrder(root.getRightNode());
        }
    }
    
}
