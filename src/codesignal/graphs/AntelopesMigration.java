package codesignal.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AntelopesMigration {
	int[] solution(int islands, int[][] bridges, int a, int b) {

		List<List<Integer>> edges = IntStream.range(0, islands).boxed().map(i -> new ArrayList<Integer>()).collect(Collectors.toList());
		for (int[] bridge : bridges) {
			edges.get(bridge[0]).add(bridge[1]);
			edges.get(bridge[1]).add(bridge[0]);
		}
		Set<Integer> aps = AP(islands, edges);
		List<Integer> list = aps.stream().filter(i -> i != a && i != b && isGoodPoint(edges, i, a, b)).sorted().collect(Collectors.toList());
		int[] arr = new int[list.size()];
		int i = 0;
		for (int ele : list) arr[i++] = ele;
		return arr;

	}

	public static int time = 0;
	public static final int NIL = -1;

	public static boolean isGoodPoint(List<List<Integer>> adj, int ap, int a, int b) {

		for (int neibor : adj.get(ap)) {
			boolean[] visited = new boolean[adj.size()];
			visited[ap] = true;
			boolean isAReachable = dfs(adj, neibor, a, visited);
			visited = new boolean[adj.size()];
			visited[ap] = true;
			boolean isBReachable = dfs(adj, neibor, b, visited);
			if (isAReachable && isBReachable) return false;
			else if (isAReachable || isBReachable) return true;
		}
		return false;

	}

	public static boolean dfs(List<List<Integer>> adj, int a, int b, boolean[] visited) {

		if (a == b) return true;
		visited[a] = true;
		for (int neibor : adj.get(a)) {
			if (!visited[neibor] && dfs(adj, neibor, b, visited)) return true;
		}
		return false;

	}

	public static void APUtil(List<List<Integer>> adj, int u, boolean visited[], int disc[], int low[], int parent[],
	                          boolean ap[]) {

		// Count of children in DFS Tree
		int children = 0;

		// Mark the current node as visited
		visited[u] = true;

		// Initialize discovery time and low value
		disc[u] = low[u] = ++time;

		// Go through all vertices aadjacent to this
		for (int v : adj.get(u))

			// If v is not visited yet, then make it a child of u
			// in DFS tree and recur for it
			if (!visited[v]) {
				children++;
				parent[v] = u;
				APUtil(adj, v, visited, disc, low, parent, ap);

				// Check if the subtree rooted with v has a connection to
				// one of the ancestors of u
				low[u] = Math.min(low[u], low[v]);

				// u is an articulation point in following cases

				// (1) u is root of DFS tree and has two or more chilren.
				if (parent[u] == NIL && children > 1)
					ap[u] = true;

				// (2) If u is not root and low value of one of its child
				// is more than discovery value of u.
				if (parent[u] != NIL && low[v] >= disc[u])
					ap[u] = true;
			}

			// Update low value of u for parent function calls.
			else if (v != parent[u])
				low[u] = Math.min(low[u], disc[v]);
	}

	// The function to do DFS traversal. It uses recursive function APUtil()
	public static Set<Integer> AP(int V, List<List<Integer>> adj) {
		// Mark all the vertices as not visited
		boolean visited[] = new boolean[V];
		int disc[] = new int[V];
		int low[] = new int[V];
		int parent[] = new int[V];
		boolean ap[] = new boolean[V]; // To store articulation points

		// Initialize parent and visited, and ap(articulation point)
		// arrays
		for (int i = 0; i < V; i++) {
			parent[i] = NIL;
			visited[i] = false;
			ap[i] = false;
		}

		// Call the recursive helper function to find articulation
		// points in DFS tree rooted with vertex 'i'
		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				APUtil(adj, i, visited, disc, low, parent, ap);

		// Now ap[] contains articulation points, print them
		Set<Integer> aps = new HashSet<>();
		for (int i = 0; i < V; i++)
			if (ap[i] == true)
				aps.add(i);

		return aps;
	}


}
