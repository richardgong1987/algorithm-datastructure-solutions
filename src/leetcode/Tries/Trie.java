package leetcode.Tries;

public class Trie {
    public TriesNode root;

    public Trie(String s) {
        this.root = new TriesNode();
        TriesNode cur = root;
        for (char c : s.toCharArray()) {
            // if key is not exist just add it
            cur.childs.computeIfAbsent(c, k -> new TriesNode());
            cur = cur.childs.get(c);
        }
        cur.end = 1;
    }

    public TriesNode search(String word, TriesNode cur) {
        TriesNode result = cur;
        if (result != null) {
            for (char c : word.toCharArray()) {
                if (result.childs.get(c) == null) {
                    return null;
                }
                result = result.childs.get(c);
            }
        }
        return result;
    }
}
