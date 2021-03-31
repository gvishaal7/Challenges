/*
 * question: https://leetcode.com/problems/path-sum/
 */
package com.challenges.random.trees;

public class pathSum {
    public boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPath(root, sum, 0);
    }

    public boolean hasPath(Node root, int sum, int running) {
        if (root != null && root.left == null && root.right == null) {
            if (root.val + running == sum) {
                return true;
            }
        }
        boolean val = false;
        if (root.left != null)
            val = hasPath(root.left, sum, (running + root.val));
        if (!val && root.right != null)
            val = hasPath(root.right, sum, (running + root.val));
        return val;
    }
}
