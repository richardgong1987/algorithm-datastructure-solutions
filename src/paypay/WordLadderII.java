package paypay;

import java.util.*;

public class WordLadderII {
	public static void main(String[] args) {
		var beginWord = "hit";
		var endWord = "cog";
		var wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
		List<List<String>> ladders = new WordLadderII().findLadders(beginWord, endWord, wordList);
		System.out.println(ladders);
	}

	Set<String> wordHashSet = new HashSet<>();
	List<String> currPathArray = new ArrayList<>();
	List<List<String>> shortestPathArray = new ArrayList<>();
	Map<String, List<String>> adjacencyMap = new HashMap<>();

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		wordHashSet.addAll(wordList);
		if (!wordHashSet.contains(endWord)) return shortestPathArray;

		bfs(beginWord);

		currPathArray.add(beginWord);

		backtrack(beginWord, endWord);

		return shortestPathArray;
	}

	public void bfs(String beginWord) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		wordHashSet.remove(beginWord);

		while (!queue.isEmpty()) {
			int size = queue.size();
			Set<String> visitedSet = new HashSet<>();
			while (size-- != 0) {
				String currWord = queue.poll();
				List<String> neighborsList = findNeighbors(currWord);

				for (String word : neighborsList) {
					if (!adjacencyMap.containsKey(currWord)) {
						adjacencyMap.put(currWord, new ArrayList<>());
					}
					adjacencyMap.get(currWord).add(word);
					visitedSet.add(word);
				}
			}
			for (String word : visitedSet) {
				queue.offer(word);
				wordHashSet.remove(word);
			}
		}
	}

	public List<String> findNeighbors(String currWord) {
		List<String> neighborsList = new ArrayList<>();
		char[] letters = currWord.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			char letter = letters[i];
			for (char c = 'a'; c <= 'z'; c++) {
				letters[i] = c;
				String word = new String(letters);
				if (wordHashSet.contains(word)) {
					neighborsList.add(word);
				}
			}
			letters[i] = letter;
		}
		return neighborsList;
	}

	public void backtrack(String beginWord, String endWord) {
		if (beginWord.equals(endWord)) {
			shortestPathArray.add(new ArrayList<>(currPathArray));
			return;
		} else if (!adjacencyMap.containsKey(beginWord)) {
			return;
		}

		for (String word : adjacencyMap.get(beginWord)) {
			currPathArray.add(word);
			backtrack(word, endWord);
			currPathArray.remove(word);
		}
	}
}
