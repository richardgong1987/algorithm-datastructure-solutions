package leetcode.contest;

public class LargestVariance {
    public static void main(String[] args) {
        LargestVariance s = new LargestVariance();
        System.out.println(s.largestVariance("aababbb"));
    }

    public int largestVariance(String s) {
        int res = 0;
        char[] a = s.toCharArray();
        boolean[] visit = new boolean[26];
        for (int i = 0; i < a.length; i++) {
            visit[a[i] - 'a'] = true;
            a[i] -= 'a';
        }

        for (int i = 0; i < 26; i++) {
            if (!visit[i]) {
                continue;
            }

            for (int j = 0; j < 26; j++) {
                if (i == j || !visit[j]) continue;
                res = Math.max(res, cal(a, i, j));
            }
        }
        return res;
    }

    public int cal(char[] a, int c1, int c2) {
        int total = 0;
        int res = 0;
        int sum = 0;
        int mn = 1000000;
        int last = 1000000;
        for (char c : a) {
            if (c != c1 && c != c2) continue;
            if (c == c1) sum--;
            else if (c == c2) {
                sum++;
                total++;
            }

            if (sum != total) res = Math.max(res, sum);
            res = Math.max(res, sum - mn);
            mn = Math.min(mn, last);
            last = sum;
        }

        // case of "abbbbbb" :
        //ensure at least one c1, so we give one c2 to pair with c1
        if (res == total) res--;
        return res;
    }
}
