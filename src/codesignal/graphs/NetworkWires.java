package codesignal.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class NetworkWires {

	static int[] parent;
	static int[] rank;

	int solution(int n, int[][] wires) {
		parent = new int[n];
		rank = new int[n];
		Arrays.fill(parent, -1);
		ArrayList<Wire> list = new ArrayList<>();
		for (int[] wire : wires) {
			Wire w = new Wire(wire[0], wire[1], wire[2]);
			list.add(w);
		}
		Collections.sort(list, new Comparator<Wire>() {
			public int compare(Wire a, Wire b) {
				return a.len - b.len;
			}
		});
		ArrayList<Wire> res = new ArrayList<>();
		ArrayList<Wire> selected = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Wire w = list.get(i);
			int s = find(w.a);
			int d = find(w.b);
			if (s != d) {
				res.add(w);
				union(w.a, w.b);
			}
		}

		int ans = 0;
		for (Wire w : res) {
			ans += w.len;
		}
		return ans;
	}

	int find(int p) {
		while (p != parent[p] && parent[p] != -1) {
			p = parent[p];
		}
		return p;
	}

	void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ) {
			return;
		}
		if (rank[rootP] < rank[rootQ]) {
			parent[rootP] = rootQ;
		} else if (rank[rootP] > rank[rootQ]) {
			parent[rootQ] = rootP;
		} else {
			parent[rootQ] = rootP;
			rank[rootP]++;
		}
	}

	class Wire {
		int a;
		int b;
		int len;

		public Wire(int a, int b, int len) {
			this.a = a;
			this.b = b;
			this.len = len;
		}
	}
}
