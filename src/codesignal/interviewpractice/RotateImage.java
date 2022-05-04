package codesignal.interviewpractice;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        System.out.println(Arrays.deepToString(r.solution(new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}})));
    }

    int[][] solution(int[][] a) {

        int len = a.length;
        int[][] result = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                //1. vertical reading
                int verticalValue = a[j][i];
                //2. write horizontally
                result[i][(len - 1) - j] = verticalValue;
            }
        }

        return result;
    }

}
