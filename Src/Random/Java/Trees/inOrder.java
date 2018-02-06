/*
  left - root - right
*/

package trees;

public class inOrder {
    
    public static void main(String[] args) throws Exception {
        inOrder io = new inOrder();
        io.process();
    }
    
    public void process() {
        createTree ct = new createTree();
        Node root = ct.setUpTree();
        System.out.println("In-Order traversal");
        findInOrder(root);
        System.out.println();
    }
    
    public void findInOrder(Node root) {
        if(root != null) {
            findInOrder(root.getLeftNode());
            System.out.print(root.getNodeVal()+" ");
            findInOrder(root.getRightNode());
        }
    }
}
