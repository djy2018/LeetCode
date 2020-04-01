package com.netease.it.questions.group2.question36;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dujiayong
 * @date 2019/08/26
 **/
public class Solution {

    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Integer>[] rows = new HashMap[9];
        Map<Integer, Integer>[] columns = new HashMap[9];
        Map<Integer, Integer>[] boxs = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxs[i] = new HashMap<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int n = (int) c;

                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxs[box_index].put(n, boxs[box_index].getOrDefault(n, 0) + 1);

                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxs[box_index].get(n) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
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

        boolean validSudoku = isValidSudoku(chars);
        System.out.println("result==" + validSudoku);


    }
}
