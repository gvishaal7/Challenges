/*
    question link : https://leetcode.com/problems/maximum-binary-tree/description/
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums != null && nums.length > 0) {
            return (construct(nums,0,nums.length-1));
        }
        else {
            return null;
        }
    }
    
    public TreeNode construct(int[] nums,int start,int end) {
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        if(start > end) { //edge case
            return null;
        }
        for(int i=start;i<=end;i++) {
            if(nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }        
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(nums,start,maxIndex-1);
        root.right = construct(nums,maxIndex+1,end);
        return root;
    }
}
