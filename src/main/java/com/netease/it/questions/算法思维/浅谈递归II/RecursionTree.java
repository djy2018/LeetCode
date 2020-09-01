package com.netease.it.questions.算法思维.浅谈递归II;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collections;
import java.util.Vector;

/**
 * 给一个正整数n，返回所有包含n个节点的合法二叉树
 *
 * @author dujiayong
 * @date 2020/9/1 20:56
 */
public class RecursionTree {

    @NoArgsConstructor
    @Getter
    @Setter
    @ToString
    public static class TreeNode implements Serializable {

        /**
         * 根节点
         */
        private Integer root;
        /**
         * 左子树
         */
        private TreeNode left;
        /**
         * 右子树
         */
        private TreeNode right;

        public TreeNode(int root) {
            this.root = root;
        }

    }

    public static Vector<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new Vector<>();
        }
        return helper(1, n);
    }

    private static Vector<TreeNode> helper(int low, int high) {
        if (low == high) {
            return new Vector<>(Collections.singletonList(new TreeNode(low)));
        }

        if (low > high) {
            return new Vector<>(Collections.singletonList(new TreeNode()));
        }

        Vector<TreeNode> result = new Vector<>();
        for (int i = low; i <= high; i++) {
            for (TreeNode left : helper(low, i - 1)) {
                for (TreeNode right : helper(i + 1, high)) {
                    TreeNode curr = new TreeNode(i);
                    curr.left = left.root == null ? null : left;
                    curr.right = right.root == null ? null : right;
                    result.add(curr);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 3;
        Vector<TreeNode> result = generateTrees(n);
        System.out.println("result=" + result.toString());
    }

}
