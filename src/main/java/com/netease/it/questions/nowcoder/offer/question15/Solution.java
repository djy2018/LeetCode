package com.netease.it.questions.nowcoder.offer.question15;

/**
 * Created by dujiayong on 2020/2/18.
 */
public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return doTree1HasTree2(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean doTree1HasTree2(TreeNode tree1, TreeNode tree2) {
        if (tree2 == null) {
            return true;
        }
        if (tree1 == null) {
            return false;
        }
        if (tree1.val != tree2.val) {
            return false;
        }
        return doTree1HasTree2(tree1.left, tree2.left) && doTree1HasTree2(tree1.right, tree2.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new Solution.TreeNode(1);
        TreeNode node2 = new Solution.TreeNode(2);
        TreeNode node3 = new Solution.TreeNode(3);
        TreeNode node4 = new Solution.TreeNode(4);
        TreeNode node5 = new Solution.TreeNode(5);

        node2.left = node4;
        node2.right = node5;
        node1.left = node2;
        node1.right = node3;

        TreeNode subNode2 = new Solution.TreeNode(2);
        TreeNode subNode4 = new Solution.TreeNode(4);
        TreeNode subNode5 = new Solution.TreeNode(6);
        subNode2.left = subNode4;
        subNode2.right = subNode5;

        boolean b = HasSubtree(node1, subNode2);
        System.out.println("end...");
    }


}
