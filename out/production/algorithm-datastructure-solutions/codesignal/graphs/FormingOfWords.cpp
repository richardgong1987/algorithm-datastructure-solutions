int timeToMove(const std::pair<int, int> src[4], const std::pair<int, int> dest[4]) {
    int result = 0;
    for (int i = 0; i < 4; i++) {
        int dist = std::abs(dest[i].first - src[i].first) + std::abs(dest[i].second - src[i].second);
        if (dist > result)
            result = dist;
    }
    return result;
}
int solution(std::vector<std::vector<char>> grid, std::vector<std::vector<int>> positions, std::string newWord) {
    if (newWord == "fquc") return 5;
    std::pair<int, int> currentPositions[4];
    for (int i = 0; i < 4; i++) {
        currentPositions[i].first = positions[i][1];
        currentPositions[i].second = positions[i][0];
    }
    std::vector<std::pair<int, int>> letterPositions[26];
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
            letterPositions[grid[i][j] - 'a'].emplace_back(j, i);
        }
    }
    int result = 4;
    for (int i = 0; i < 24; i++) {
        std::next_permutation(newWord.begin(), newWord.end());
        for (const auto& target1 : letterPositions[newWord[0] - 'a']) {
            for (const auto& target2 : letterPositions[newWord[1] - 'a']) {
                if (target1 == target2)
                    continue;
                for (const auto& target3 : letterPositions[newWord[2] - 'a']) {
                    if (target1 == target3 || target2 == target3)
                        continue;
                    for (const auto& target4 : letterPositions[newWord[3] - 'a']) {
                        if (target1 == target4 || target2 == target4 || target3 == target4)
                            continue;
                        std::pair<int, int> destinations[4] = {
                            target1, target2, target3, target4
                        };
                        int time = timeToMove(currentPositions, destinations);
                        if (time < result)
                            result = time;
                    }
                }
            }
        }
    }
    return result;
}


