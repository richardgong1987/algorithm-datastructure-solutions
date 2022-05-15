package codesignal.interviewpractice.treebasic;

import codesignal.interviewpractice.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class RestoreBinaryTree {
    Tree<Integer> solution(int[] inorder, int[] preorder) {
        int j = 0;
        Deque<Tree<Integer>> stack = new LinkedList<>();
        Tree<Integer> root = new Tree<>(preorder[0]);
        stack.push(root);
        Tree<Integer> node = root;
        for (int i = 1; i < preorder.length; i++) {
            boolean popped = false;
            while (!stack.isEmpty() && stack.peek().value.equals(inorder[j])) {
                j++;
                node = stack.pop();
                popped = true;
            }
            if (popped) {
                Tree<Integer> next = new Tree<>(preorder[i]);
                node.right = next;
                stack.push(next);
                continue;
            }
            Tree<Integer> next = new Tree<>(preorder[i]);
            if (stack.peek() != null) {
                stack.peek().left = next;
            }
            stack.push(next);
        }
        return root;
    }
}
