package codesignal;

public class BuildPalindrome {
	public static void main(String[] args) {
		BuildPalindrome buildPalindrome = new BuildPalindrome();
		String abcdc = buildPalindrome.buildPalindrome("abcdc");
		System.out.println(abcdc);
	}
	String solution(String st) {
		return buildPalindrome(st);
	}

	String buildPalindrome(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (isPalindrome(s.substring(i))) {
				StringBuilder sb = new StringBuilder();
				sb.append(s);
				for (int j = i - 1; j >= 0; j--) {
					sb.append(s.charAt(j));
				}
				return sb.toString();
			}
		}
		// Guaranteed not to get here
		//
		return "";
	}

	boolean isPalindrome(String s) {
		// Walk the string from head to tail
		// comparing characters at each side as we go
		//
		int h = 0;
		int t = s.length() - 1;
		while (h < t) {
			if (s.charAt(h) != s.charAt(t)) {
				return false;
			}
			h++;
			t--;
		}
		return true;
	}
}
