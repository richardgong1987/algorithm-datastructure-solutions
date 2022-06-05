package leetcode.dp;

import java.util.*;

public class Leetcode139 {
    public static void main(String[] args) {
        Leetcode139 s = new Leetcode139();
        System.out.println(s.wordBreak("bb", List.of("a", "b", "bbb", "bbbb")));
    }

    // 备忘录
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        // 备忘录，-1 代表未计算，0 代表 false，1 代表 true
        memo = new int[s.length()];
        Arrays.fill(memo, -1);
        // 根据函数定义，判断 s[0..] 是否能够被拼出
        return dp(s, 0, wordDict);
    }

    // 定义：返回 s[i..] 是否能够被 wordDict 拼出
    boolean dp(String s, int i, List<String> wordDict) {
        // base case，整个 s 都被拼出来了
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 1;
        }
        // 遍历所有单词，尝试匹配 s[i..] 的前缀
        for (String word : wordDict) {
            int len = word.length();
            if (i + len > s.length()) {
                continue;
            }
            String subStr = s.substring(i, i + len);
            if (!subStr.equals(word)) {
                continue;
            }
            // s[i..] 的前缀被匹配，去尝试匹配 s[i+len..]
            if (dp(s, i + len, wordDict)) {
                // s[i..] 可以被拼出，将结果记入备忘录
                memo[i] = 1;
                return true;
            }
        }
        // s[i..] 不能被拼出，结果记入备忘录
        memo[i] = 0;
        return false;
    }
}
