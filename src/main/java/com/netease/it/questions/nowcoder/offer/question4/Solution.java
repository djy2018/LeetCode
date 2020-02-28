package com.netease.it.questions.nowcoder.offer.question4;

import java.util.Arrays;

/**
 * Created by dujiayong on 2020/2/6.
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode root = new Solution.TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length), Arrays.copyOfRange(in,i+1,in.length));
                break;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};

        TreeNode treeNode = reConstructBinaryTree(pre, in);
        System.out.println("end...");
    }

}
