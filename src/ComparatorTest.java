import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
	public static void main(String args[]) throws InterruptedException {
		String[] ar = {"c", "d", "b", "a", "e"};
		InnerClass in = new InnerClass();
		Arrays.parallelSort(ar, in);
		System.out.println(Arrays.toString(ar));
	}

	static class InnerClass implements Comparator<String> {
		public int compare(String s1, String s2) {
			return s2.compareTo(s1);
		}
	}
}