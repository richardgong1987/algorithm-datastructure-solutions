package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        var ret = new ArrayList<Integer>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        var index = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (ret.size() == index) {
                    ret.add(cur.val);
                }
                ret.set(index, Math.max(ret.get(index), cur.val));

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            index++;
        }
        return ret;
    }
}
