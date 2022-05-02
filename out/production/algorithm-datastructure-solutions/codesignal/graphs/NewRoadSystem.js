function newRoadSystem(roadRegister) {
    // will be used to count ingoing and outgoing roads
    const inComingRoads = new Array(roadRegister.length).fill(0);
    const outGoingRoads = new Array(roadRegister.length).fill(0);

    // we have to do a double loop to collect data from the 2D array
    roadRegister.forEach((currentCity, currentCityIndex) => {
        currentCity.forEach((hasRoadToTargetCity, targetCityIndex) => {
            if (hasRoadToTargetCity) {
                // count ingoing and outgoing roads
                inComingRoads[targetCityIndex] = inComingRoads[targetCityIndex] + 1;
                outGoingRoads[currentCityIndex] = outGoingRoads[currentCityIndex] + 1;
            }
        });
    });

    // make sure the same number of roads in and out of the city
    return inComingRoads.every((inComingRoadsCount, cityIndex) => {
        return outGoingRoads[cityIndex] === inComingRoadsCount;
    });
}