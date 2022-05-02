package codesignal.graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class ConnectedNetwork {
	int[] set;
	int[] rank;

	void makeSet(int t) {
		set[t] = t;
		rank[t] = 0;
	}

	int findSet(int t) {
		if (t == set[t]) return t;
		return set[t] = findSet(set[t]);
	}

	void connect(int a, int b) {
		int f = findSet(a);
		int s = findSet(b);
		if (rank[f] < rank[s]) {
			int tmp = f;
			f = s;
			s = tmp;
		}
		set[s] = f;
		if (rank[s] == rank[f]) rank[f]++;
	}

	int solution(int n, int[][] wires) {
		Arrays.sort(wires, (a, b) -> Integer.compare(a[2], b[2]));
		set = new int[n + 1];
		rank = new int[n + 1];
		for (int i = 1; i <= n; i++) makeSet(i);

		int answer = 0;
		ArrayList<Integer> used = new ArrayList<>();
		for (int i = 0; i < wires.length; i++) {
			if (findSet(wires[i][0]) == findSet(wires[i][1])) continue;
			used.add(i);
			answer += wires[i][2];
			connect(wires[i][0], wires[i][1]);
		}

		int mn = 1_000_000_000;

		for (int j : used) {
			int subAnswer = 0;
			set = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 1; i <= n; i++) makeSet(i);
			int count = 0;
			for (int i = 0; i < wires.length; i++) {
				if (findSet(wires[i][0]) == findSet(wires[i][1]) || i == j) continue;
				count += 1;
				subAnswer += wires[i][2];
				connect(wires[i][0], wires[i][1]);
			}
			if (count + 1 == n)
				mn = Math.min(mn, subAnswer - answer);
		}

		return mn;
	}
}
