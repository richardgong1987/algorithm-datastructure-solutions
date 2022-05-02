package codesignal.graphs;

import java.util.*;

public class BarrelMaze {
	private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	int solution(int n, int m, int[][] boxes) {
		boolean[][] containsBox = new boolean[n][m];
		int openIndex = 1, frontierSize = 1, stepCount = 0, initialState[][] = new int[4][2];
		HashSet<String> visitedStates = new HashSet<>();
		ArrayDeque<int[][]> queue = new ArrayDeque<>();

		for (int[] box : boxes) containsBox[box[0]][box[1]] = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!containsBox[i][j]) {
					initialState[openIndex][0] = i;
					initialState[openIndex][1] = j;
					openIndex++;
				}
			}
		}


		visitedStates.add(serializeState(initialState));
		queue.add(initialState);

		while (!queue.isEmpty()) {
			int[][] state = queue.removeFirst();

			if (state[0][0] == n - 1 && state[0][1] == m - 1) return stepCount;

			frontierSize--;
			queue.addAll(getNewStates(state, n, m, visitedStates));

			if (frontierSize == 0) {
				frontierSize = queue.size();
				stepCount++;
			}
		}

		return -1;
	}


	private List<int[][]> getNewStates(int[][] state, int n, int m, HashSet<String> visitedStates) {
		List<int[][]> output = new ArrayList<>();

		for (int[] dir : direction) {
			int py = state[0][0] + dir[0], px = state[0][1] + dir[1];

			if (py == state[1][0] && px == state[1][1] || py == state[2][0] && px == state[2][1] || py == state[3][0] && px == state[3][1]) {
				int[][] newState = copyState(state);

				newState[0] = new int[]{py, px};

				if (visitedStates.add(serializeState(newState))) output.add(newState);
			}

			for (int i = 1; i < 4; i++) {
				if (state[i][0] == state[0][0] && state[i][1] == state[0][1]) continue;

				int by = state[i][0] + dir[0], bx = state[i][1] + dir[1];

				if (by < 0 || bx < 0 || by >= n || bx >= m) continue;
				if ((by != state[1][0] || bx != state[1][1]) && (by != state[2][0] || bx != state[2][1]) && (by != state[3][0] || bx != state[3][1])) {
					int[][] newState = copyState(state);

					newState[i] = new int[]{by, bx};

					if (visitedStates.add(serializeState(newState))) output.add(newState);
				}
			}
		}

		return output;
	}

	private String serializeState(int[][] state) {
		Arrays.sort(state, 1, 3, Comparator.comparingInt((int[] s) -> s[0]).thenComparing((int[] s) -> s[1]));
		return Arrays.deepToString(state);
	}

	private int[][] copyState(int[][] state) {
		int[][] output = new int[state.length][state[0].length];

		for (int i = 0; i < state.length; i++)
			output[i] = Arrays.copyOf(state[i], state[0].length);

		return output;
	}
}
