package programs;

// Java Program Invert a Binary Tree using Recursive Postorder

import java.util.LinkedList;
import java.util.Queue;

public class MirrorImageTree {

    static TreeNode mirrorQueue(TreeNode root) {
        if (root == null)
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        // Traverse the tree, level by level
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // Swap the left and right subtree
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            // Push the left and right node to the queue
            if (curr.left != null)
                q.add(curr.left);
            if (curr.right != null)
                q.add(curr.right);
        }
        return root;
    }

    // function to return the root of inverted tree
    static TreeNode mirrorRecursion(TreeNode root) {
        if (root == null)
            return null;

        // Invert the left and right subtree
        TreeNode left = mirrorRecursion(root.left);
        TreeNode right = mirrorRecursion(root.right);

        // Swap the left and right subtree
        root.left = right;
        root.right = left;

        return root;
    }

    static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {

        // Input Tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root = mirrorRecursion(root);

        // Mirror Tree:
        //       1
        //      / \
        //     3   2
        //        / \
        //       5   4
        inOrder(root);
        System.out.println();
        root = mirrorQueue(root);
        inOrder(root);
    }
}