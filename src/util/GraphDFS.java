package util;

public class GraphDFS {
	//深度优先遍历
	public static void DFS(Graph graph, int start, boolean[] visited) {
		System.out.println(graph.vertexes[start].data);

		visited[start] = true;
		for (int index : graph.adj[start]) {
			if (!visited[index]) {
				DFS(graph, index, visited);
			}
		}
	}

}
