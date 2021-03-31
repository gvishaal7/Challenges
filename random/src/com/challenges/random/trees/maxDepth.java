package com.challenges.random.trees;

public class maxDepth {

    private int answer = 0;

    public int bottomUp(Node root) {
        if (root == null) {
            return 0;
        }
        int left = bottomUp(root.left);
        int right = bottomUp(root.right);

        if (left > right) {
            return (left + 1);
        }
        else {
            return (right + 1);
        }
    }

    public void topDown(Node root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        topDown(root.left, depth + 1);
        topDown(root.right, depth + 1);
    }
}
