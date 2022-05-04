package codesignal.interviewpractice;

import java.util.*;

public class FirstDuplicate {
    public static void main(String[] args) {
        FirstDuplicate f = new FirstDuplicate();
        System.out.println(f.solution(new int[]{2, 1, 3, 5, 3, 2}));
    }

    int solution(int[] a) {
        Set<Integer> map = new LinkedHashSet<>();
        for (int n : a) {
            // duplicate found, return its n
            if (map.contains(n)) {
                return n;
            } else {
                map.add(n);
            }
        }
        return -1;
    }

}
