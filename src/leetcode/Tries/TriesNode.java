package leetcode.Tries;


import java.util.HashMap;
import java.util.Map;

public class TriesNode {
    public int pass = 1;
    public int end;
    Map<Character, TriesNode> childs = new HashMap<>();
}
