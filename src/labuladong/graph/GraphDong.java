package labuladong.graph;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphDong {
	class State {
		// 图节点的 id
		int id;
		// 从 start 节点到当前节点的距离
		int distFromStart;

		State(int id, int distFromStart) {
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
		Queue<State> pq = new PriorityQueue<>((a, b) -> {
			return a.distFromStart - b.distFromStart;
		});
		// 从起点 start 开始进行 BFS
		pq.offer(new State(start, 0));

		while (!pq.isEmpty()) {
			State curState = pq.poll();
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
					pq.offer(new State(nextNodeID, distToNextNode));
				}
			}
		}
		return distTo;
	}

}
