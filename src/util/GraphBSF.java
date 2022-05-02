package util;

import java.util.Deque;


public class GraphBSF {
	//广度优先遍历
	public static void BFS(Graph graph, int start, boolean[] visited, Deque<Integer> queue) {
		queue.offer(start);
		while (!queue.isEmpty()) {
			int front = queue.poll();
			if (visited[start]) {
				continue;
			}
			System.out.println(graph.vertexes[front].data);
			visited[front] = true;
			for (int index : graph.adj[front]) {
				queue.offer(index);
			}
		}
	}
}
