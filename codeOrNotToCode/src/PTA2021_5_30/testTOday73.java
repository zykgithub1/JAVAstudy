package PTA2021_5_30;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class testTOday73 {
	public static void main(String[] args) {
		Solution9 s = new Solution9();
		String ans = s.frequencySort("aabbcccc");
		System.out.println(ans);
	}

}

class Solution9 {
	public String frequencySort(String s) {
		HashMap<Character, Integer> map = new HashMap();
		char[] charArr = s.toCharArray();
		for (char ch : charArr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
//		for(Character ch:map.keySet()) {
//			System.out.println(ch+" "+map.get(ch));
//		}
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Map.Entry<Character, Integer>> que = new PriorityQueue<>(
				new Comparator<Map.Entry<Character, Integer>>() {

					@Override
					public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {

						return o2.getValue().compareTo(o1.getValue());
					}

				});
		for (Map.Entry<Character, Integer> set : map.entrySet()) {
//			System.out.println("ÃÌº” ±"+"  "+set.getKey()+"  "+set.getValue());
			que.add(set);
		}
//		System.out.println(que.peek().getKey());
		int size=que.size();
		for (int i = 0; i < size; i++) {
			Map.Entry<Character, Integer> temp = que.poll();
			int num = temp.getValue();
			char ch = temp.getKey();
//			System.out.println(temp.getKey()+" 112  "+num);
			for (int j = 0; j < num; j++) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}