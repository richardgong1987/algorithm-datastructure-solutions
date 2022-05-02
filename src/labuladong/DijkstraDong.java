package labuladong;

import util.TreeNode;

import java.util.*;

public class DijkstraDong {

	static class StateGraph {
		// graph id
		int id;
		int distFromStart;

		public StateGraph(int id, int distFromStart) {
			this.id = id;
			this.distFromStart = distFromStart;
		}

	}

	// 输入一个起点 start，计算从 start 到其他节点的最短距离
	int[] dijkstra(int start, List<int[]>[] graph) {
		// 定义：distTo[i] 的值就是起点 start 到达节点 i 的最短路径权重
		int[] distTo = new int[graph.length];
		Arrays.fill(distTo, Integer.MAX_VALUE);
		// base case，start 到 start 的最短距离就是 0
		distTo[start] = 0;

		// 优先级队列，distFromStart 较小的排在前面
		Queue<StateGraph> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.distFromStart));
		// 从起点 start 开始进行 BFS
		pq.offer(new StateGraph(start, 0));

		while (!pq.isEmpty()) {
			StateGraph curState = pq.poll();
			int curNodeID = curState.id;
			int curDistFromStart = curState.distFromStart;

			if (curDistFromStart > distTo[curNodeID]) {
				continue;
			}

			// 将 curNode 的相邻节点装入队列
			for (int[] neighbor : graph[curNodeID]) {
				int nextNodeID = neighbor[0];
				int distToNextNode = distTo[curNodeID] + neighbor[1];
				// 更新 dp table
				if (distTo[nextNodeID] > distToNextNode) {
					distTo[nextNodeID] = distToNextNode;
					pq.offer(new StateGraph(nextNodeID, distToNextNode));
				}
			}
		}
		return distTo;
	}

	static class State {
		int depth;
		TreeNode node;

		public State(TreeNode node, int depth) {
			this.depth = depth;
			this.node = node;
		}
	}


	public static TreeNode levelTraverseWithState(TreeNode root) {
		if (root == null) {
			return null;
		}

		Queue<State> queue = new LinkedList<>();
		queue.offer(new State(root, 1));
		while (!queue.isEmpty()) {
			State cur = queue.poll();
			TreeNode curNode = cur.node;
			System.out.printf("%s On the %s level", curNode.val, cur.depth);

			if (curNode.left != null) {
				queue.offer(new State(curNode.left, cur.depth + 1));
			}
			if (curNode.right != null) {
				queue.offer(new State(curNode.right, cur.depth + 1));
			}
		}

		return root;
	}

}
