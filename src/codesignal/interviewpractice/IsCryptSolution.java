package codesignal.interviewpractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IsCryptSolution {
    public static void main(String[] args) {
        IsCryptSolution s = new IsCryptSolution();
//        System.out.println(s.solution(new String[]{"A", "A", "A"}, new char[][]{{'A', '0'}}));
        System.out.println(s.solution2(new String[]{"A", "A", "A"}, new char[][]{{'A', '0'}}));
        System.out.println(s.solution3(new String[]{"A", "A", "A"}, new char[][]{{'A', '0'}}));
    }

    boolean solution(String[] crypt, char[][] solution) {
        for (int i = 0; i < crypt.length; i++) {
            for (char[] chars : solution) {
                crypt[i] = crypt[i].replace(chars[0], chars[1]);
            }
        }
        for (String s : crypt) {
            if (!s.equals("0") && s.startsWith("0")) {
                return false;
            }
        }

        return Long.parseLong(crypt[0]) + Long.parseLong(crypt[1]) == Long.parseLong(crypt[2]);
    }

    boolean solution2(String[] crypt, char[][] solution) {
        HashMap<Character, Character> map = new HashMap<>();

        for (char[] chars : solution) {
            map.put(chars[0], chars[1]);
        }
        List<String> list = new ArrayList<>();
        for (String str : crypt) {
            if (map.get(str.charAt(0)) == '0' && str.length() > 1) {
                return false;
            }

            StringBuilder s = new StringBuilder();
            for (char c : str.toCharArray()) {
                s.append(map.get(c));
            }
            list.add(s.toString());
        }

        double num1 = Double.parseDouble(list.get(0));
        double num2 = Double.parseDouble(list.get(1));
        double num3 = Double.parseDouble(list.get(2));
        return num1 + num2 == num3;
    }

    boolean solution3(String[] crypt, char[][] solution) {
        for (int i = 0; i < crypt.length; i++) {
            for (char[] a : solution) {
                crypt[i] = crypt[i].replace(a[0], a[1]);
            }
        }
        if ((crypt[0].charAt(0) == '0' && crypt[0].length() > 1) ||
            (crypt[1].charAt(0) == '0' && crypt[1].length() > 1) ||
            (crypt[2].charAt(0) == '0' && crypt[2].length() > 1)) {
            return false;
        }
        Long a = Long.parseLong(crypt[0]);
        Long b = Long.parseLong(crypt[1]);
        long c = Long.parseLong(crypt[2]);
        return a + b == c;
    }


}
