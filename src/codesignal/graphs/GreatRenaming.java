package codesignal.graphs;

public class GreatRenaming {
	boolean[][] solution(boolean[][] roadRegister) {
		int len = roadRegister.length;
		boolean[][] newRoad = new boolean[len][len];
		for (int i = 0; i < len - 1; i++) {
			newRoad[0][i + 1] = roadRegister[len - 1][i];
			newRoad[i + 1][0] = roadRegister[i][len - 1];
//			for(int j = 0; j < len -1;j++){
//				newRoad[i+1][j+1]=roadRegister[i][j];
//			}
			System.arraycopy(roadRegister[i], 0, newRoad[i + 1], 1, len - 1);
		}

		return newRoad;
	}
}
