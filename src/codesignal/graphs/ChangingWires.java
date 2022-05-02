package codesignal.graphs;

import java.util.*;

public class ChangingWires {
	Map<Integer, Integer> set;
	Map<Integer, Integer> rank;
	static final int INF = 1_000_000_000;

	void makeSet(int t) {
		set.put(t, t);
		rank.put(t, t);
	}

	int findSet(int t) {
		if (t == set.get(t)) return t;
		set.put(t, findSet(set.get(t)));
		return set.get(t);
	}

	void connect(int a, int b) {
		int f = findSet(a);
		int s = findSet(b);
		if (rank.get(f) < rank.get(s)) {
			int tmp = f;
			f = s;
			s = tmp;
		}
		set.put(s, f);
		if (rank.get(s) == rank.get(f)) rank.put(f, rank.get(f) + 1);
	}

	class Path implements Comparable<Path> {
		int first;
		int second;
		int dist;

		Path(int first, int second, int dist) {
			this.first = first;
			this.second = second;
			this.dist = dist;
		}

		public int compareTo(Path other) {
			if (dist < other.dist) return -1;
			if (dist > other.dist) return 1;
			return 0;
		}
	}

	int[] solution(int n, int[][] wires, int k, int[][] updates) {
		Map<Integer, Map<Integer, Integer>> dist = new HashMap<>();

		Queue<Path> queue = new PriorityQueue<>();
		for (int[] wire : wires) {
			queue.add(new Path(wire[0], wire[1], wire[2]));
			if (!dist.containsKey(wire[0])) dist.put(wire[0], new HashMap<>());
			if (!dist.containsKey(wire[1])) dist.put(wire[1], new HashMap<>());
			dist.get(wire[0]).put(wire[1], wire[2]);
			dist.get(wire[1]).put(wire[0], wire[2]);
		}

		int[] ans = new int[updates.length];

		for (int j = 0; j < updates.length; j++) {
			set = new HashMap<>();
			rank = new HashMap<>();

			dist.get(updates[j][0]).put(updates[j][1], updates[j][2]);
			dist.get(updates[j][1]).put(updates[j][0], updates[j][2]);
			queue.add(new Path(updates[j][0], updates[j][1], updates[j][2]));

			Path[] history = new Path[k];
			ArrayList<Path> tmp = new ArrayList<>();
			for (int g = 0; g < k; g++) {
				Path cur = queue.poll();
				if (!set.containsKey(cur.first)) makeSet(cur.first);
				if (!set.containsKey(cur.second)) makeSet(cur.second);
				if (cur.dist != dist.get(cur.first).get(cur.second) || findSet(cur.first) == findSet(cur.second)) {
					if (cur.dist == dist.get(cur.first).get(cur.second)) tmp.add(cur);
					g--;
					continue;
				}
				connect(cur.first, cur.second);
				history[g] = cur;
			}
			int answer = 0;
			for (Path path : history) {
				answer += path.dist;
				queue.add(path);
			}
			for (Path path : tmp) queue.add(path);
			ans[j] = answer;
		}
		return ans;
	}

}
