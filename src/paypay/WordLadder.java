package paypay;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Set<String> reached = new HashSet<>();
		reached.add(beginWord);
		int distance = 1;
		while (!reached.contains(endWord)) {
			Set<String> toAdd = new HashSet<>();
			for (String each : reached) {
				for (int i = 0; i < each.length(); i++) {
					char[] chars = each.toCharArray();
					for (char ch = 'a'; ch <= 'z'; ch++) {
						chars[i] = ch;
						String word = new String(chars);
						if (wordList.contains(word)) {
							toAdd.add(word);
							wordList.remove(word);
						}
					}
				}
			}

			distance++;
			if (toAdd.isEmpty()) return 0;
			reached = toAdd;
		}
		return distance;
	}

	public static void main(String[] args) {
		var beginWord = "hit";
		var endWord = "cog";
		var wordList = new HashSet<>(List.of("hot","dot","dog","lot","log"));
		int i = ladderLength(beginWord, endWord, wordList);
		System.out.println(i);
	}
}
