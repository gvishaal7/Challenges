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
  
  /*
   * leetcode question link: https://leetcode.com/problems/binary-tree-inorder-traversal/
   */
    public void getInorderIterative(Node root) {
        if(root != null) {
            Stack<Node> myStack = new Stack<>();
            myStack.add(root);
            while(!myStack.isEmpty()) {
                Node temp = myStack.peek();
                if(temp.getLeftNode() != null) {
                    myStack.add(temp.getLeftNode());
                }
                else {
                    if(!myStack.isEmpty())
                        myStack.peek().getLeftNode() = null;
                    if(temp.getRightNode() != null) {
                        myStack.add(temp.getRightNode());
                    }
                }
            }
        }
    }
}
