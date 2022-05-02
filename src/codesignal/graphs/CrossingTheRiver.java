package codesignal.graphs;

import java.util.*;

public class CrossingTheRiver {
	int solution(int[][] animals) {
		if (animals.length == 1) return animals[0][0];
		if (animals.length == 2) return animals[0][1];

		PriorityQueue<AnimalCrossing> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
		Map<String, Integer> visitedStates = new HashMap<>();
		int[] start = new int[animals.length - 2];
		for (int i = 0; i < start.length; i++) start[i] = i + 2;
		boolean[] startArr = new boolean[animals.length];
		Arrays.fill(startArr, true);
		AnimalCrossing startState = new AnimalCrossing(startArr, new boolean[animals.length], true, 0, 0);
		queue.add(startState);
		visitedStates.put(startState.toString(), 0);

		while (!queue.isEmpty()) {
			AnimalCrossing state = queue.remove();
			if (state.endCount == animals.length) return state.time; //we found winState
			for (AnimalCrossing newState : generateStates(state, animals)) {
				if (state.time == 20) {
				}
				if (visitedStates.getOrDefault(newState.toString(), Integer.MAX_VALUE) > newState.time) {
					visitedStates.put(newState.toString(), newState.time);
					queue.add(newState);
				}
			}
		}
		return -1;
	}

	private List<AnimalCrossing> generateStates(AnimalCrossing state, int[][] animals) {
		List<AnimalCrossing> output = new ArrayList<>();
		if (state.boatReturning) {
			for (int i = 0; i < state.atStart.length; i++) {
				if (!state.atStart[i]) continue;
				if (animals[i][i] > 0) {
					AnimalCrossing newState = state.newClone(i, i, animals[i][i]);
					newState.endCount++;
					if (isLegalState(newState, animals)) output.add(newState);
				}
				for (int j = i + 1; j < state.atStart.length; j++) {
					if (!state.atStart[j] || animals[i][j] < 0) continue;
					AnimalCrossing newState = state.newClone(i, j, animals[i][j]);
					newState.endCount += 2;
					if (isLegalState(newState, animals)) output.add(newState);
				}
			}
		} else {
			for (int i = 0; i < state.atStart.length; i++) {
				if (!state.atEnd[i]) continue;
				if (animals[i][i] > 0) {
					AnimalCrossing newState = state.newClone(i, i, animals[i][i]);
					newState.endCount--;
					if (isLegalState(newState, animals)) output.add(newState);
				}
				for (int j = i + 1; j < state.atStart.length; j++) {
					if (!state.atEnd[j] || animals[i][j] < 0) continue;
					AnimalCrossing newState = state.newClone(i, j, animals[i][j]);
					newState.endCount -= 2;
					if (isLegalState(newState, animals)) output.add(newState);
				}
			}

		}
		return output;
	}

	private boolean isLegalState(AnimalCrossing state, int[][] animals) {
		if (state.endCount == 2 && state.boatReturning) {
			int firstAnimal = -1;
			for (int i = 0; i < state.atEnd.length; i++) {
				if (state.atEnd[i]) {
					if (firstAnimal == -1) firstAnimal = i;
					else if (animals[i][firstAnimal] < 0) return false;
				}
			}
		} else if (state.atStart.length - state.endCount == 2 && !state.boatReturning) {
			int firstAnimal = -1;
			for (int i = 0; i < state.atStart.length; i++) {
				if (state.atStart[i]) {
					if (firstAnimal == -1) firstAnimal = i;
					else if (animals[i][firstAnimal] < 0) return false;
				}
			}
		}
		return true;
	}


	class AnimalCrossing {
		public final boolean[] atStart;
		public final boolean[] atEnd;
		public final boolean boatReturning;
		public int time;
		public int endCount;

		AnimalCrossing(boolean[] atStart, boolean[] atEnd, boolean boatReturning, int time, int endCount) {
			this.atStart = atStart;
			this.atEnd = atEnd;
			this.boatReturning = boatReturning;
			this.time = time;
			this.endCount = endCount;
		}

		@Override
		public String toString() {
			return "AnimalCrossing{" +
					"atStart=" + Arrays.toString(atStart) +
					", atEnd=" + Arrays.toString(atEnd) +
					", boatReturning=" + boatReturning +
					'}';
		}

		protected AnimalCrossing newClone(int swap1, int swap2, int timeAdd) {
			AnimalCrossing newState = new AnimalCrossing(Arrays.copyOf(atStart, atStart.length), Arrays.copyOf(atEnd, atEnd.length), !boatReturning, time, endCount);
			newState.atStart[swap1] = !newState.atStart[swap1];
			newState.atEnd[swap1] = !newState.atEnd[swap1];
			if (swap1 != swap2) {
				newState.atStart[swap2] = !newState.atStart[swap2];
				newState.atEnd[swap2] = !newState.atEnd[swap2];
			}
			newState.time += timeAdd;
			return newState;
		}
	}
}
