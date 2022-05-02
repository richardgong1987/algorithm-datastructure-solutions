package codesignal.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LivingOnTheRoads {
	boolean[][] solution(boolean[][] roadRegister) {
		int len = roadRegister.length;
		for (int a = 0; a < len; a++) {
			for (int b = a + 1; b < len; b++) {
				if (roadRegister[a][b]) {
					newVertices.add(a * BASE + b);
				}
			}
		}

		int newLen = newVertices.size();
		List<Integer> newNames = new ArrayList<>(newVertices);
		boolean[][] newRegister = new boolean[newLen][newLen];
		for (int a = 0; a < newLen; a++) {
			for (int b = 0; b < newLen; b++) {
				if (a != b) {
					int aX = newNames.get(a) / BASE;
					int aY = newNames.get(a) % BASE;

					int bX = newNames.get(b) / BASE;
					int bY = newNames.get(b) % BASE;

					if (aX == bX || aX == bY || aY == bX || aY == bY) {
						newRegister[a][b] = true;
					}
				}
			}
		}

		return newRegister;
	}

	private static final int BASE = 16;

	private Set<Integer> newVertices = new TreeSet<>();

}
