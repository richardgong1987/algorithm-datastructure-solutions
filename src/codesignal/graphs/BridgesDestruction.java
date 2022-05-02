package codesignal.graphs;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BridgesDestruction {
	int solution(int[][] bridges, int a, int b) {

		Set<Pair> path = new HashSet<>();
		Set<Pair> common = new HashSet<>();
		try {
			return dfs(bridges.length, a, b, bridges, new boolean[bridges.length], path, common);
		} catch (IllegalAccessException e) {
			return 0;
		}

	}

	public static int dfs(int n, int src, int dest, int[][] bridges, boolean[] visited, Set<Pair> path, Set<Pair> common) throws IllegalAccessException {

		if (src == dest) { // found path
			final Set<Pair> com = common;
			if (common.isEmpty()) path.stream().forEach(b -> com.add(b));
			else {
				Set<Pair> tmp = path.stream().filter(b -> com.contains(b)).collect(Collectors.toSet());
				if (tmp.isEmpty()) throw new IllegalAccessException();
				else {
					com.clear();
					tmp.stream().forEach(b -> com.add(b));
				}
			}
		} else {
			if (visited[src]) return 0;
			visited[src] = true;

			for (int neibor : bridges[src]) {
				if (!visited[neibor]) {
					Pair bridge = Pair.create(src, neibor);
					path.add(bridge);
					dfs(n, neibor, dest, bridges, visited, path, common);
					path.remove(bridge);
				}
			}

			visited[src] = false;
		}

		return common == null ? 0 : common.size();

	}

	public static class Pair {
		public final int first;
		public final int second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public boolean equals(Object o) {
			Pair p = (Pair) o;
			return first == p.first && second == p.second;
		}

		@Override
		public int hashCode() {
			return Integer.valueOf(first).hashCode() ^ Integer.valueOf(second).hashCode();
		}

		public static Pair create(int a, int b) {
			return new Pair(a, b);
		}

		public String toString() {
			return first + ":" + second;
		}
	}


}
