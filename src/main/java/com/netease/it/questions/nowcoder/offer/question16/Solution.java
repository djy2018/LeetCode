package com.netease.it.questions.nowcoder.offer.question16;

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

    public static void Mirror(TreeNode root){
        if(root != null){
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = null;
            root.left = null;
            if(left != null){
                Mirror(left);
                root.right = left;
            }
            if(right != null){
                Mirror(right);
                root.left = right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node4.left = node5;
        node3.left = node4;
        node2.left = node3;
        node1.left = node2;

        Mirror(node1);

        System.out.println("end...");
    }
}
