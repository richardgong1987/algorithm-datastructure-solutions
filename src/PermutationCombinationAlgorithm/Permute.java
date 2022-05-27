package PermutationCombinationAlgorithm;

import java.util.LinkedList;
import java.util.List;

public class Permute {
    public static void main(String[] args) {
        Permute permute = new Permute();
        List<List<Integer>> lists = permute.permute(new int[]{1, 2, 3});
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> path = new LinkedList<>();
        // 「路径」中的元素会被标记为 true，避免重复使用
        boolean[] visited = new boolean[nums.length];

        backtrack(nums, path, visited);
        return res;
    }

    // 路径：记录在 path 中
    // 选择列表：chooses 中不存在于 path 的那些元素（visited[i] 为 false）
    // 结束条件：chooses 中的元素全都在 path 中出现
    void backtrack(int[] chooses, LinkedList<Integer> path, boolean[] visited) {
        // 触发结束条件
        if (path.size() == chooses.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < chooses.length;/** 选择列表 */ i++) {
            // 排除不合法的选择
            if (visited[i]) {
                // chooses[i] 已经在 path 中，跳过
                continue;
            }
            // 做选择
            path.add(chooses[i]);
            visited[i] = true;
            // 进入下一层决策树
            backtrack(chooses, path, visited);
            // 取消选择
            path.removeLast();
            visited[i] = false;
        }
    }

}
