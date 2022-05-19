package codesignal.interviewpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestPath {
    public static void main(String[] args) {
        LongestPath s = new LongestPath();
        System.out.println(s.solution("user\f\tpictures\f\tdocuments\f\t\tnotes.txt"));
    }

    int solution(String fileSystem) {
        int maxlen = 0;
        Map<Integer, Integer> pathDict = new HashMap<>();
        pathDict.put(0, 0);
        for (String file : fileSystem.split("\f")) {
            int depth = count(file);
            int name = file.length() - depth;
            if (file.contains(".")) {
                maxlen = Math.max(maxlen, pathDict.get(depth) + name);
            } else {
                pathDict.put(depth + 1, pathDict.get(depth) + name + 1);
            }
        }


        return maxlen;
    }

    int count(String file) {
        Matcher matcher = Pattern.compile("\\t").matcher(file);
        int sum = 0;
        while (matcher.find()) {
            sum++;
        }
        return sum;
    }
}
