package codesignal.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class RunningWater {
	Set<String> s = new HashSet<>();

	boolean solution(int[] cap, int volume) {
		return f(cap, cap.clone(), volume);
	}

	boolean f(int[] cap, int[] current, int volume) {
		int total = IntStream.of(current).sum();
		if (total <= volume) {
			return total == volume;
		}

		String currentState = Arrays.toString(current);
		if (s.contains(currentState)) {
			return false;
		}
		s.add(currentState);

		// empty a bucket
		for (int i = 0; i < 3; i++) {
			if (current[i] == 0) {
				continue;
			}
			int temp = current[i];
			current[i] = 0;
			if (f(cap, current, volume)) {
				return true;
			}
			current[i] = temp;
		}

		// pour from bucket i into bucket j
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {

				if (i == j) {
					continue;
				}

				int spaceRemainingJ = cap[j] - current[j];
				if (spaceRemainingJ < 1) {
					continue;
				}
				int temp = Math.min(spaceRemainingJ, current[i]);
				current[i] -= temp;
				current[j] += temp;
				if (f(cap, current, volume)) {
					return true;
				}
				current[i] += temp;
				current[j] -= temp;
			}
		}
		return false;
	}

}
