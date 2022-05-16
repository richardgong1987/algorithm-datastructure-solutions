package leetcode.contest;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumWhiteTiles {
    public static void main(String[] args) {
        MaximumWhiteTiles s = new MaximumWhiteTiles();
        System.out.println(s.maximumWhiteTiles(new int[][]{{1, 5}, {10, 11}, {12, 18}, {20, 25}, {30, 32}}, 9));
    }


    int sumAll = 0;

    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, Comparator.comparingInt(x -> x[0]));

        for (int i = 0; i < tiles.length; i++) {
            helper(tiles, carpetLen, i, i, 0);
        }
        return sumAll;
    }

    public void helper(int[][] tiles, int carpetLen, int i, int j, int sum) {
        if (j == tiles.length) {
            return;
        }

        int start = tiles[i][0];
        int end = tiles[j][1];
        int len = end - start + 1;

        if (carpetLen < len) {
            int tmp = sum + start + carpetLen - tiles[j][0];
            this.sumAll = Math.max(this.sumAll, tmp);
        } else {
            int tmp = sum + end - tiles[j][0] + 1;
            this.sumAll = Math.max(this.sumAll, tmp);
            helper(tiles, carpetLen, i, j + 1, tmp);
        }

    }
}
