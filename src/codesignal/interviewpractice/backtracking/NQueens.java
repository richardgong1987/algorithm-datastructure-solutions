package codesignal.interviewpractice.backtracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NQueens {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solution(int n) {
        char[][] board = buildBoard(n);
        backtrack(board, 0);
        return res;
    }

    private char[][] buildBoard(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        return board;
    }

    private void backtrack(char[][] board, int r) {
        if (r == board.length) {
            res.add(charToList(board));
            return;
        }
        int n = board[r].length;
        for (int c = 0; c < n; c++) {
            if (!isValid(board, r, c)) {
                continue;
            }
            // 进入选择
            board[r][c] = 'Q';
            backtrack(board, r + 1);
            // 撤销选择
            board[r][c] = '.';
        }
    }

    private List<String> charToList(char[][] board) {
        List<String> result = new LinkedList<>();
        for (char[] c : board) {
            result.add(String.copyValueOf(c));
        }
        return result;
    }

    private boolean isValid(char[][] board, int r, int c) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            if (board[i][c] == 'Q')
                return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

}
