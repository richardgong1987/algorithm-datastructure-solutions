package codesignal;

import java.util.ArrayList;
import java.util.Arrays;

public class AddBorder {
	static String[] addBorder(String[] picture) {
		var startEnd = new StringBuilder();
		startEnd.append("*".repeat(picture[0].length() + 2));

		var list = new ArrayList<String>();
		list.add(startEnd.toString());
		for (String s : picture) {
			list.add("*" + s + "*");
		}
		list.add(startEnd.toString());
		return list.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String[] strings = addBorder(new String[]{"abc",
				"ded"});
		System.out.println(Arrays.toString(strings));
	}
}
