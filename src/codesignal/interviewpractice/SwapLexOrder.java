package codesignal.interviewpractice;

import java.util.*;

public class SwapLexOrder {
    String solution(String str, int[][] pairs) {
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();
        for (int[] pair : pairs) {
            int a = pair[0];
            int b = pair[1];

            Set<Integer> l0 = neighbours.get(a);
            Set<Integer> l1 = neighbours.get(b);

            if (l0 == null) {
                l0 = l1 == null ? new TreeSet<>() : l1;
            }

            if (l1 != null) {
                Set<Integer> fl0 = l0;
                l1.forEach(i -> neighbours.put(i, fl0));
                l0.addAll(l1);
            }

            l0.add(a);
            l0.add(b);
            neighbours.put(a, l0);
            neighbours.put(b, l0);
        }

        StringBuilder sb = new StringBuilder(str);

        for (Set<Integer> set : new HashSet<>(neighbours.values())) {
            Iterator<Character> c = set.stream().map(i -> str.charAt(i - 1)).sorted(Comparator.reverseOrder()).iterator();
            set.forEach(i -> sb.setCharAt(i - 1, c.next()));
        }

        return sb.toString();
    }

    String solution2(String str, int[][] pairs) {
        if (pairs.length == 0) return str;

        Map<Integer, Set<Integer>> permutations = new HashMap<>();

        for (int[] pair : pairs) {
            for (int j = 0; j < 2; ++j) {
                int val = j == 0 ? pair[1] : pair[0];
                if (!permutations.containsKey(pair[j])) {
                    permutations.put(pair[j], new HashSet<>());
                }

                permutations.get(pair[j]).add(val);
            }
        }

        for (Map.Entry<Integer, Set<Integer>> entry : permutations.entrySet()) {
            Set<Integer> visited = new HashSet<>();
            visited.add(entry.getKey());

            buildPermutations(visited, permutations, entry.getKey(), entry.getKey());
        }

        char[] s = str.toCharArray();
        int length = s.length;
        for (int i = 0; i < length; i++) {
            if (permutations.containsKey(i + 1)) {
                for (Integer k : permutations.get(i + 1)) {
                    if (k - 1 > i && s[k - 1] - s[i] > 0) {
                        char temp = s[k - 1];
                        s[k - 1] = s[i];
                        s[i] = temp;
                    }
                }
            }
        }

        return String.valueOf(s);
    }

    void buildPermutations(Set<Integer> visited, Map<Integer, Set<Integer>> map, Integer visiting, Integer i) {
        for (Integer index : map.get(visiting)) {
            if (!visited.contains(index)) {
                visited.add(index);
                buildPermutations(visited, map, index, i);
            }
        }

        if (visiting.intValue() == i.intValue()) return;
        if (map.get(visiting).contains(i)) return;
        if (i <= visiting) return;

        map.get(visiting).add(i);
    }
}
