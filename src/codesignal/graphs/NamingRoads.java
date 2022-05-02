package codesignal.graphs;

import java.util.*;

public class NamingRoads {
	public static void main(String[] args) {
		NamingRoads s = new NamingRoads();
//		System.out.println(s.solution(new int[][]{
//				{0, 1, 0},
//				{4, 1, 2},
//				{4, 3, 4},
//				{2, 3, 1},
//				{2, 0, 3}
//		}));
		System.out.println(s.solution2(new int[][]{
				{0, 1, 0},
				{4, 1, 2},
				{4, 3, 4},
				{2, 3, 1},
				{2, 0, 3}
		}));
	}

	boolean solution(int[][] roads) {
		int[][] roads2 = new int[roads.length][3];
		for (int[] road : roads)
			roads2[road[2]] = road.clone();

		for (int i = 0; i < roads.length - 1; i++) {
			Set<Integer> set = new HashSet<>();
			set.add(roads2[i][0]);
			set.add(roads2[i][1]);
			set.add(roads2[i + 1][0]);
			set.add(roads2[i + 1][1]);
			if (set.size() < 4)
				return false;
		}
		return true;
	}

	boolean solution2(int[][] roads) {
		Map<Integer, List<Integer>> adj = getAdj(roads);
		Deque<List<Integer>> stack = new LinkedList<>();
		stack.offer(adj.get(0));
		for (int i = 1; i < roads.length; i++) {
			List<Integer> prev = stack.pop();
			List<Integer> current = adj.get(i);
			for (Integer node : prev) {
				if (current.contains(node)) {
					return false;
				}
			}
			stack.offerLast(current);
		}
		return true;
	}

	Map<Integer, List<Integer>> getAdj(int[][] roads) {
		Map<Integer, List<Integer>> obj = new HashMap<>();
		for (int[] road : roads) {
			var roadName = road[2];
			ArrayList<Integer> nodes = new ArrayList<>();
			nodes.add(road[0]);
			nodes.add(road[1]);
			if (obj.containsKey(roadName)) {
				for (Integer node : nodes) {
					obj.get(roadName).add(node);
				}
			} else {
				obj.put(roadName, nodes);
			}
		}
		return obj;
	}
}
