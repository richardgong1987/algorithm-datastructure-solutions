package codesignal;

public class IsSumofConsecutive2 {
    public static void main(String[] args) {
        IsSumofConsecutive2 s = new IsSumofConsecutive2();
        System.out.println(s.solution(9));
    }

    int solution(int n) {
        int c = 0;
        for (int i = 1; i < n; i++) {
            int s = i;
            for (int j = i + 1; j < n; j++) {
                s += j;
                if (s == n) {
                    c++;
                }
                if (s > n) {
                    break;
                }
            }
        }
        return c;
    }

    int solution2(int n) {
        int count = 0;
        int i;
        int m;

        for (i = 1, m = i; m < n; i++, m += i) {
            if ((n - m) % (i + 1) == 0) {
                count++;
            }
        }
        return count;
    }

}
