package com.netease.it.questions.算法思维.回溯算法.N皇后;

import java.util.Arrays;
import java.util.Vector;

/**
 * Created by dujiayong on 2020/4/11.
 */
public class Solution {

    static Vector<String[][]> res = new Vector<>();

    /**
     * 输入棋盘边长为n，返回所有合法的放置
     */
    static Vector<String[][]> solveNQueues(int n) {
        // "."表示空 "Q"表示皇后 初始化空棋盘
        String[][] board = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = "*";
            }
//            Arrays.fill(board[i],"*");
        }
        backtrack(board, 0);
        return res;
    }

    static void backtrack(String[][] board, int row) {
        // 触发结束条件
        if (row == board.length) {
            String[][] target = new String[board.length][board.length];
            for (int i = 0; i < board.length; i++) {
                target[i] = Arrays.copyOf(board[i], board[i].length);
            }
            res.add(target);
            return;
        }

        int n = board[row].length;
        for (int col = 0; col < n; col++) {
            // 排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }
            //做选择
            board[row][col] = "Q";
            // 进入下一个决策
            backtrack(board, row + 1);
            //撤销选择
            board[row][col] = "*";
        }
    }

    static boolean isValid(String[][] board, int row, int col) {
        int n = board.length;
        //检查列是否有皇后 互相冲突
        for (int i = 0; i < n; i++) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }
        //检查右上方是否有皇后 互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        //检查左上方是否有皇后 互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 8;
        Vector<String[][]> result = solveNQueues(n);
        System.out.println("N皇后问题：N=" + n + "，总共有" + result.size() + "种解法,解法如下:");
        for (int i = 0; i < result.size(); i++) {
            System.out.println("解法:" + (i+1));
            String[][] solution = result.get(i);
            for (int j = 0; j < solution.length; j++) {
                for (int k = 0; k < solution.length; k++) {
                    System.out.print(" " + solution[j][k] + " ");
                }
                System.out.println("");
            }
            System.out.println("");
        }
    }
}
