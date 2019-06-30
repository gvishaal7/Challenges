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

    /*
     * iterative approach
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return (new ArrayList<>());
        }

        List<Integer> outputList = new ArrayList<>();
        Stack<TreeNode> tempStack = new Stack<>();
        outputList.add(root.val);
        tempStack.add(root);
        while(!tempStack.isEmpty()) {
            TreeNode top = tempStack.peek();
            if(top.left != null) {
                outputList.add(top.left.val);
                tempStack.add(top.left);
                top.left = null;
            }
            else if(top.right != null) {
                outputList.add(top.right.val);
                tempStack.add(top.right);
                top.right = null;
            }
            else {
                tempStack.pop();
            }
        }
        return outputList;
    }
}
