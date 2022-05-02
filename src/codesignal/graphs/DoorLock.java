package codesignal.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class DoorLock {

	double solution(int[][] points) {
		int n = points.length;
		Set<Integer> mstSet = new HashSet<>();
		int minIndex = 0;
		double[] distances = new double[n];
		IntStream.range(0, n).boxed().forEach(i -> distances[i] = Double.MAX_VALUE);
		distances[0] = 0;
		do {
			mstSet.add(minIndex);
			double minDistance = Double.MAX_VALUE;
			int nextMinIndex = -1;
			for (int i = 0; i < points.length; i++) {
				if (!mstSet.contains(i)) {
					double distance = Math.sqrt(Math.pow(points[i][0] - points[minIndex][0], 2) + Math.pow(points[i][1] - points[minIndex][1], 2) + Math.pow(points[i][2] - points[minIndex][2], 2));
					if (distances[i] > distance) {
						distances[i] = distance;
					}
					if (distances[i] < minDistance) {
						minDistance = distances[i];
						nextMinIndex = i;
					}
				}
			}
			minIndex = nextMinIndex;
		} while (mstSet.size() < n);

		return Arrays.stream(distances).sum();

	}


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

	class Path {
		int first;
		int second;
		double dist;

		Path(int first, int second, double dist) {
			this.first = first;
			this.second = second;
			this.dist = dist;
		}
	}

	double distance(int a[], int b[]) {
		return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2) + Math.pow(a[2] - b[2], 2));
	}

	double solution2(int[][] points) {
		int n = points.length;
		Path[] connections = new Path[n * (n - 1) / 2];
		int l = 0;
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				connections[l++] = new Path(i, j, distance(points[i], points[j]));
		Arrays.sort(connections, (a, b) -> Double.compare(a.dist, b.dist));
		set = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) makeSet(i);

		double answer = 0;
		for (int i = 0; i < connections.length; i++) {
			if (findSet(connections[i].first) == findSet(connections[i].second)) continue;
			answer += connections[i].dist;
			connect(connections[i].first, connections[i].second);
		}
		return answer;
	}

}
