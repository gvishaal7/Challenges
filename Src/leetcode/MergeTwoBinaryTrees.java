/*
  question link : https://leetcode.com/problems/merge-two-binary-trees/description/
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        else if(t1 == null && t2 != null) {
            return t2;
        }
        else if(t2 == null && t1 != null) {
            return t1;
        }
        else {
            int sum = t1.val + t2.val;
            TreeNode root = new TreeNode(sum);
            root.left = mergeTrees(t1.left,t2.left);
            root.right = mergeTrees(t1.right,t2.right);
            return root;
        }
    }
}
