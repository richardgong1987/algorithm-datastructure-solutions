package leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateOneByOne("", list, n, n);
        return list;
    }

    public void generateOneByOne(String sublist, List<String> list, int left, int right) {
        if (left > right) {
            return;
        }
        if (left > 0) {
            generateOneByOne(sublist + "(", list, left - 1, right);
        }
        if (right > 0) {
            generateOneByOne(sublist + ")", list, left, right - 1);
        }
        if (left == 0 && right == 0) {
            list.add(sublist);
        }
    }
//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<String>();
//        backtrack(list, "", 0, 0, n);
//        return list;
//    }
//
//    public void backtrack(List<String> list, String str, int open, int close, int max) {
//        if (str.length() == max * 2) {
//            list.add(str);
//            return;
//        }
//
//        if (open < max)
//            backtrack(list, str + "(", open + 1, close, max);
//        if (close < open)
//            backtrack(list, str + ")", open, close + 1, max);
//    }

}
