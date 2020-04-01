package com.netease.it.questions.group2.question37;

/**
 * @author dujiayong
 * @date 2019/08/27
 **/
public class Solution {

    public static void solveSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][10];
        boolean[][] columns = new boolean[9][10];
        boolean[][] boxs = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j] - '0';
                if (num >= 1 && num <= 9) {
                    rows[i][num] = true;
                    columns[j][num] = true;
                    boxs[(i / 3) * 3 + j / 3][num] = true;
                }
            }
        }

        boolean success = recursiveSolveSudoku(board, rows, columns, boxs, 0, 0);
        System.out.println("result==" + success);
    }

    public static boolean recursiveSolveSudoku(char[][] board, boolean[][] rows, boolean[][] columns, boolean[][] boxs, int row, int col) {
        // 边界校验，如果已经填充完成，返回true，表示一切结束
        if (col == board[0].length) {
            col = 0;
            row++;
            if (row == board.length) {
                return true;
            }
        }

        char c = board[row][col];
        if (c == '.') {
            for (int num = 1; num < 10; num++) {
                boolean insertFlag = !(rows[row][num] || columns[col][num] || boxs[(row / 3) * 3 + col / 3][num]);
                if (insertFlag) {
                    rows[row][num] = true;
                    columns[col][num] = true;
                    boxs[(row / 3) * 3 + col / 3][num] = true;

                    board[row][col] = (char) ('0' + num);

                    if (recursiveSolveSudoku(board, rows, columns, boxs, row, col + 1)) {
                        return true;
                    }

                    board[row][col] = '.';
                    rows[row][num] = false;
                    columns[col][num] = false;
                    boxs[(row / 3) * 3 + col / 3][num] = false;
                }
            }
        } else {
            return recursiveSolveSudoku(board, rows, columns, boxs, row, col + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] chars = new char[9][9];
        chars[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        chars[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        chars[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        chars[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        chars[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        chars[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        chars[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        chars[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        chars[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        solveSudoku(chars);

    }


}
