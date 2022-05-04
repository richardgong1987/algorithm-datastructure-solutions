package codesignal.interviewpractice;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Sudoku2 {
    public static void main(String[] args) {
        Sudoku2 s = new Sudoku2();
        System.out.println(s.solution(new char[][]{
            {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}}));
    }

    boolean solution(char[][] grid) {
        int n = grid.length;

        Set<String> set = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                char c = grid[row][col];
                if (c != '.' && !set.add(c + " in row " + row)) {
                    return false;
                }
                if (c != '.' && !set.add(c + " in col " + col)) {
                    return false;
                }
                if (c != '.' && !set.add(c + " in square " + row / 3 + " " + col / 3)) {
                    return false;
                }
            }

        }

        return true;
    }

    boolean solution2(char[][] grid) {
        for (int i = 0; i < 9; i++) {
            if (!checkRow(grid, i)) {
                return false;
            }

            for (int j = 0; j < 9; j++) {
                if (!checkCol(grid, j)) {
                    return false;
                }
                if (!check3x3Grip(grid, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final String REG = "^[1-9]$";

    boolean checkCol(char[][] grip, int j) {
        Set<Character> set = new HashSet<>();
        for (char[] chars : grip) {
            char c = chars[j];
            if (set.contains(c)) {
                return false;
            }
            if (Pattern.matches(REG, c + "")) {
                set.add(c);
            }
        }
        return true;
    }

    boolean checkRow(char[][] grip, int i) {
        Set<Character> set = new HashSet<>();
        for (char c : grip[i]) {
            if (set.contains(c)) {
                return false;
            }
            if (Pattern.matches(REG, c + "")) {
                set.add(c);
            }
        }
        return true;
    }

    boolean check3x3Grip(char[][] grip, int i, int j) {
        Set<Character> set = new HashSet<>();
        HashSet<Integer> isLegel = new HashSet<>(List.of(0, 3, 6));
        if (isLegel.contains(i) && isLegel.contains(j)) {
            for (int k = 0; k < 3; k++) {
                for (int u = 0; u < 3; u++) {
                    char c = grip[k + i][j + u];
                    if (set.contains(c)) {
                        return false;
                    }
                    if (Pattern.matches(REG, c + "")) {
                        set.add(c);
                    }
                }
            }
        }

        return true;
    }
}
