package com.challenges.leetcode;

/**
 * 
 * link: https://leetcode.com/problems/trim-a-binary-search-tree/submissions/
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Trim_Binary_Search_Tree {
    TreeNode output = null;
    
    public TreeNode trimBST(TreeNode root, int L, int R) {
        TreeNode newRoot = null;
        traverseGivenTree(root,L,R,newRoot);
        return output;
    }
    
    
    public void traverseGivenTree(TreeNode root, int l, int r, TreeNode newRoot) {
        if(root != null) {
            int rootVal = root.val;
            if(rootVal >= l && rootVal <= r) {
                if(newRoot == null) {
                    newRoot = new TreeNode(rootVal);
                    newRoot.left = null;
                    newRoot.right = null;
                    output = newRoot;
                }    
                else {
                    traverseNewTree(rootVal,newRoot);
                }
            }
            traverseGivenTree(root.left,l,r,newRoot);
            traverseGivenTree(root.right,l,r,newRoot);
        }
    }
    
    public void traverseNewTree(int val, TreeNode newRoot) {
        if(newRoot != null) {
            if(val < newRoot.val) {
                if(newRoot.left != null) {
                    traverseNewTree(val,newRoot.left);
                }    
                else {
                    TreeNode temp = new TreeNode(val);
                    temp.right = null;
                    temp.left = null;    
                    newRoot.left = temp;
                }
            }
            else {
                if(newRoot.right != null) {
                    traverseNewTree(val,newRoot.right);
                }
                else {
                    TreeNode temp = new TreeNode(val);
                    temp.right = null;
                    temp.left = null;
                    newRoot.right = temp;
                }
            }
        }
    }
}
