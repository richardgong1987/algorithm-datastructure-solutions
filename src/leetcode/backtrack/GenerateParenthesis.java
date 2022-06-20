package leetcode.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesis s = new GenerateParenthesis();
        System.out.println(s.generateParenthesis(3));
    }

    public List<String> generateParenthesis2(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    public void backtrack(List<String> list, String str, int open, int close, int max) {

        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        if (open < max) {
            System.out.println(String.format("++open<max=true,list=%s,str=%s,open=%d,close=%d,max=%d", list, str + "(", open + 1, close, max));
            backtrack(list, str + "(", open + 1, close, max);
        }

        if (close < open) {
            System.out.println(String.format("--close<open=true,list=%s,str=%s,open=%d,close=%d,max=%d", list, str + ")", open, close + 1, max));
            backtrack(list, str + ")", open, close + 1, max);
        }

    }
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        Deque<String> stack = new LinkedList<>();
        List<String> res = new ArrayList<>();
        backtrack(n, n, stack, res);
        return res;
    }

    // 可用的左括号数量为 left 个，可用的右括号数量为 rgiht 个
    void backtrack(int left, int right, Deque<String> track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) return;
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) return;
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            StringBuilder str = new StringBuilder();
            for (String s : track) {
                str.insert(0, s);
            }
            res.add(str.toString());
            return;
        }

        // 尝试放一个左括号
        track.push("("); // 选择
        backtrack(left - 1, right, track, res);
        track.pop(); // 撤消选择

        // 尝试放一个右括号
        track.push(")"); // 选择
        backtrack(left, right - 1, track, res);
        track.pop(); // 撤消选择
    }
}
