package codesignal.graphs;

public class NewRoadSystem {
	static boolean solution(boolean[][] roadRegister) {
		// will be used to count ingoing and outgoing roads.l
		int[] inComingRoads = new int[roadRegister.length];
		int[] outGoingRoads = new int[roadRegister.length];


		// we have to do a double loop to collect data from the 2D array
		for (int currentCityIndex = 0; currentCityIndex < roadRegister.length; currentCityIndex++) {
			boolean[] currentCity = roadRegister[currentCityIndex];
			for (int targetCityIndex = 0; targetCityIndex < currentCity.length; targetCityIndex++) {
				boolean hasRoadToTargetCity = currentCity[targetCityIndex];
				if (hasRoadToTargetCity) {
					// count currentCity outgoing roads
					outGoingRoads[currentCityIndex]++;
					// count targetCity ingoing roads
					inComingRoads[targetCityIndex]++;
				}
			}
		}

		// make sure the same number of roads in and out of the city
		for (int cityIndex = 0; cityIndex < inComingRoads.length; cityIndex++) {
			if (outGoingRoads[cityIndex] != inComingRoads[cityIndex]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		boolean result = solution(new boolean[][]{
						{false, true, false, false},
						{false, false, true, false},
						{true, false, false, true},
						{false, false, true, false}
				}
		);
		System.out.println(result);
	}
}
