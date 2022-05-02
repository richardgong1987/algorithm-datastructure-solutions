package codesignal.graphs;

import java.util.*;

public class RoadsBuilding {
	public static void main(String[] args) {
		RoadsBuilding roadsBuilding = new RoadsBuilding();
		int[][] ss = roadsBuilding.solution(4,
				new int[][]
						{
								{0, 1},
								{1, 2},
								{2, 0}
						}
		);
		System.out.println(Arrays.deepToString(ss));
	}

	int[][] solution(int cities, int[][] roads) {
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (int i = 0; i < cities; i++) {
			graph.put(i, new ArrayList<>());
		}

		for (int[] road : roads) {
			graph.get(road[0]).add(road[1]);
			graph.get(road[1]).add(road[0]);
		}

		ArrayList<int[]> result = new ArrayList<>();
		for (int i = 0; i < cities; i++) {
			for (int j = i + 1; j < cities; j++) {
				if (!graph.get(i).contains(j) && !graph.get(j).contains(i)) {
					result.add(new int[]{i, j});
				}
			}
		}
		if (!result.isEmpty()) {
			int[][] rs = new int[result.size()][result.get(0).length];
			for (int i = 0; i < result.size(); i++) {
				rs[i] = result.get(i);
			}
			return rs;
		}
		return new int[0][0];
	}
}
