package codesignal.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsTadpole {
	boolean solution(boolean[][] adj) {
		int n = adj.length;
		int[] degs = new int[n];

		for (int a = 0; a < n; a++) {
			for (int b = 0; b < n; b++) {
				if (adj[a][b]) {
					if (a == b) {
						return false;
					}
					degs[a]++;
				}
			}
		}

		int[] counts = new int[n];
		for (int i = 0; i < n; i++) {
			counts[degs[i]]++;
		}

		if (counts[1] != 1 || counts[3] != 1 || counts[2] != n - 2) {
			return false;
		}

		Queue<Integer> q = new LinkedList<>();
		boolean[] flags = new boolean[n];
		Arrays.fill(flags, true);
		q.add(0);
		flags[0] = false;
		int cc = 0;
		while (!q.isEmpty()) {
			int current = q.poll();
			cc++;
			for (int i = 0; i < n; i++) {
				if (flags[i] && adj[current][i]) {
					q.add(i);
					flags[i] = false;
				}
			}
		}

		return cc == n;
	}
}
