package codesignal.graphs;

public class MergingCities {
	boolean[][] solution(boolean[][] roadRegister) {
		return mergingCities(roadRegister);
	}

	boolean[][] mergingCities(boolean[][] roadRegister) {
		int len = roadRegister.length;
		int mergeCount = 0;
		int[] names = new int[len];

		for (int i = 0; i < len; i++) {
			names[i] = i;
		}

		for (int i = 0; i < len - 1; i++) {
			if ((i % 2 == 0) && roadRegister[i][i + 1]) {
				mergeCount++;
				for (int b = i + 1; b < len; b++) {
					names[b]--;
				}
			}
		}
		int newLen = len - mergeCount;
		boolean[][] newRegister = new boolean[newLen][newLen];

		for (int a = 0; a < len; a++) {
			for (int b = 0; b < len; b++) {
				if (roadRegister[a][b] && names[a] != names[b]) {
					newRegister[names[a]][names[b]] = true;
				}
			}
		}

		return newRegister;
	}
}
