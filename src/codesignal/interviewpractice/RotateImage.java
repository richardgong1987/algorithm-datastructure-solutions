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

        int n = a.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = a[i][j];

                //1.(current,current) <= (left, bottom)
                a[i][j] = a[n - j - 1][i];
                //2.(left,bottom) <= (right,bottom)
                a[n - j - 1][i] = a[n - 1 - i][n - 1 - j];
                //3.(right,bottom) <= (top,right)
                a[n - 1 - i][n - 1 - j] = a[j][n - 1 - i];
                //4.(top,right) <= (current,current)
                a[j][n - 1 - i] = temp;
            }
        }
        return a;
    }
}
