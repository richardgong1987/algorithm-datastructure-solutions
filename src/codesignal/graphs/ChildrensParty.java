package codesignal.graphs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ChildrensParty {
	int solution(int[][] directions) {

		int up = 8;
		int left = 4;
		int down = 2;
		int right = 1;
		int rows = directions.length;
		int cols = directions[0].length;
		List<List<Integer>> roads = IntStream.range(0, rows * cols).boxed().map(i -> new ArrayList<Integer>()).collect(Collectors.toList());
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int currNode = i * cols + j;
				int inverted = ~(directions[i][j]);
				if ((inverted & up) == up) roads.get(currNode).add((i - 1) * cols + j);
				if ((inverted & left) == left) roads.get(currNode).add(i * cols + j - 1);
				if ((inverted & down) == down) roads.get(currNode).add((i + 1) * cols + j);
				if ((inverted & right) == right) roads.get(currNode).add(i * cols + j + 1);
			}
		}
		return findScc(rows, cols, roads).size();

	}

	public static List<Set<Integer>> findScc(int rows, int cols, List<List<Integer>> roads) {

		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		int n = rows * cols;
		for (int i = n - 1; i >= 0; i--) {
			if (!visited.contains(i))
				dfs1(i, roads, stack, visited);
		}

		// reverse roads
		List<List<Integer>> reversedRoads = IntStream.range(0, cols * rows).boxed().map(i -> new ArrayList<Integer>()).collect(Collectors.toList());
		for (int i = 0; i < n; i++) {
			for (int j : roads.get(i)) {
				reversedRoads.get(j).add(i);
			}
		}

		// dfs again
		visited.clear();
		List<Set<Integer>> sccs = new ArrayList<>();
		while (!stack.isEmpty()) {
			int start = stack.pop();
			if (!visited.contains(start)) {
				Set<Integer> scc = new HashSet<>();
				dfs2(start, reversedRoads, visited, scc);
				sccs.add(scc);
			}
		}
		return sccs;

	}

	public static void dfs1(int start, List<List<Integer>> roads, Stack<Integer> stack, Set<Integer> visited) {

		if (visited.contains(start)) return;
		visited.add(start);
		for (int next : roads.get(start)) {
			dfs1(next, roads, stack, visited);
		}
		stack.push(start);

	}

	public static void dfs2(int start, List<List<Integer>> reversedRoads, Set<Integer> visited, Set<Integer> scc) {

		if (visited.contains(start)) return;
		visited.add(start);
		scc.add(start);
		for (int neibor : reversedRoads.get(start)) {
			dfs2(neibor, reversedRoads, visited, scc);
		}

	}


}
