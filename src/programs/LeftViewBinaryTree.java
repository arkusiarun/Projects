package programs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewBinaryTree {

    // Function to return the left view of the binary tree
    static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // Queue for level order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            // Number of nodes at the current level
            int levelSize = q.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();

                // If it's the first node of the current level
                if (i == 0) {
                    result.add(curr.data);
                }

                // Enqueue left child
                if (curr.left != null) {
                    q.add(curr.left);
                }

                // Enqueue right child
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return result;
    }

    static void printArray(ArrayList<Integer> arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Representation of the input tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        ArrayList<Integer> result = leftView(root);

        printArray(result);
    }
}