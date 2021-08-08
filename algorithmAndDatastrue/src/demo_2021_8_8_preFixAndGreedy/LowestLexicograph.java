package demo_2021_8_8_preFixAndGreedy;

import java.util.Arrays;
import java.util.Comparator;

public class LowestLexicograph {
	public static void main(String[] args) {

	}

	public static String lowestString(String[] strs) {
		Arrays.sort(strs, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o1 + o2).compareTo(o2 + o1);
			}
		});
		StringBuilder sb = new StringBuilder();
		for (String str : strs) {
			sb.append(str);
		}
		return sb.toString();
	}
	
	

}
