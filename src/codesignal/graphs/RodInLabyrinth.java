package codesignal.graphs;

import java.util.ArrayDeque;

public class RodInLabyrinth {
	int solution(char[][] labyrinth) {
		int height = labyrinth.length, width = labyrinth[0].length;

		boolean[][][] visited = new boolean[height][width][2];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0 || j == width - 1)
					visited[i][j][0] = true;
				else if (labyrinth[i][j - 1] == '#' || labyrinth[i][j] == '#' || labyrinth[i][j + 1] == '#') {
					visited[i][j][0] = true;
				}
				if (i == 0 || i == height - 1)
					visited[i][j][1] = true;
				else if (labyrinth[i - 1][j] == '#' || labyrinth[i][j] == '#' || labyrinth[i + 1][j] == '#') {
					visited[i][j][1] = true;
				}
			}
		}

		int[][] offsets = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[]{0, 1, 0});
		visited[0][1][0] = true;
		int frontierSize = 1;
		int stepCount = 0;
		while (!queue.isEmpty()) {
			int[] position = queue.removeFirst();
			int y = position[0], x = position[1], level = position[2];
			if ((y == height - 1 && x == width - 2) || (y == height - 2 && x == width - 1)) return stepCount;
			frontierSize--;

			for (int[] offset : offsets) {
				int i = y + offset[0], j = x + offset[1];
				if (i < 0 || j < 0 || i >= height || j >= width) continue;
				if (!visited[i][j][level]) {
					queue.addLast(new int[]{i, j, level});
					visited[i][j][level] = true;
				}
			}
			if (canRotate(y, x, labyrinth) && !visited[y][x][(level + 1) % 2]) {
				queue.addLast(new int[]{y, x, (level + 1) % 2});
				visited[y][x][(level + 1) % 2] = true;
			}

			if (frontierSize == 0) {
				frontierSize = queue.size();
				stepCount++;
			}
		}
		return -1;
	}

	private boolean canRotate(int i, int j, char[][] labyrinth) {
		if (i == 0 || j == 0 || i == labyrinth.length - 1 || j == labyrinth[0].length - 1) return false;
		for (int y = -1; y < 2; y++) {
			for (int x = -1; x < 2; x++)
				if (labyrinth[i + y][j + x] == '#') return false;
		}
		return true;
	}
}
