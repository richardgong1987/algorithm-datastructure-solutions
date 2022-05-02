package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
		int abcabcbb = l.lengthOfLongestSubstring("abcabcbb");
		System.out.println(abcabcbb);

	}

	public int lengthOfLongestSubstring(String s) {
		if (s == null || "".equals(s)) {
			return 0;
		}
		int start = 0;
		int end = 0;
		int maxLength = 0;
		Set<Character> uniqueCharacters = new HashSet<>();
		while (end < s.length()) {
			if (uniqueCharacters.add(s.charAt(end))) {
				end++;
				maxLength = Math.max(maxLength, uniqueCharacters.size());
			} else {
				uniqueCharacters.remove(s.charAt(start));
				start++;
			}
		}
		return maxLength;
	}
}
