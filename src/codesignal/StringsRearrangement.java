package codesignal;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StringsRearrangement {
	public static void main(String[] args) {
		StringsRearrangement stringsRearrangement = new StringsRearrangement();
		boolean solution = stringsRearrangement.solution(new String[]{"abc", "bef", "bcc", "bec", "bbc", "bdc"});
//		System.out.println(solution);
	}

	boolean solution(String[] inputArray) {
		Deque<String> tries = loadString(inputArray);
		LinkedList<String> matches = new LinkedList<>();
		matches.offer(tries.poll());

		while (!tries.isEmpty()) {
			String first = matches.getFirst();
			String last = matches.getLast();
			printList(tries, matches, first, last);
			int numOfTries = tries.size();
			for (int t = 0; t < numOfTries; t++) {
				String actual = tries.poll();
				if (exactOneDiff(first, actual)) {
					matches.offerFirst(actual);
					break;
				} else if (exactOneDiff(last, actual)) {
					matches.offerLast(actual);
					break;
				} else {
					tries.offer(actual);
				}
			}
			if (numOfTries == tries.size()) {
				return false;
			}
		}
		return true;
	}


	boolean exactOneDiff(String target, String actual) {
		int diff = 0;
		int len = target.length();
		for (int ch = 0; ch < len; ch++) {
			if (target.charAt(ch) != actual.charAt(ch)) diff++;
		}
		return diff == 1;
	}

	Deque<String> loadString(String[] in) {
		Deque<String> temp = new LinkedList<>();
		for (String str : in) {
			temp.offer(str);
		}
		return temp;
	}

	private void printList(Queue tries, List matches, String first, String last) {
		System.out.print("tries:[");
		for (Object o : tries) {
			System.out.print(o + ",");
		}
		System.out.print("]");
		System.out.print(" matches:[");
		for (Object o : matches) {
			System.out.print(o + ",");
		}
		System.out.print("]");
		System.out.println();
		System.out.println("first:" + first);
		System.out.println("last:" + last);
		System.out.println("--------------------------------");
	}
}
