package demo_2021_8_27_;

import java.util.HashMap;

public class delAndGetLowestString {
	public static void main(String[] args) {
		String str="bbbcccaacdcbd";
		System.out.println(remove(str));
		System.out.println(removeSelf(str));
	}
	
	public static String removeSelf(String str) {
		if(str==null||str.length()<2) {
			return str;
		}
		int[]map=new int[256];
		for(int i=0;i<str.length();i++) {
			map[str.charAt(i)]++;
		}
		int minIndex=0;
		for(int i=0;i<str.length();i++) {
			if(--map[str.charAt(i)]==0) {
				break;
			}else {
				minIndex=str.charAt(minIndex)<str.charAt(i)?minIndex:i;
			}
		}
		return str.charAt(minIndex)+removeSelf(str.substring(minIndex+1).replaceAll(String.valueOf(str.charAt(minIndex)), " "));
	}
	public static String remove(String str) {
		if(str.length()==0||str==null||str.equals("")) {
			return "";
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i=0;i<str.length();i++) {
			map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
		}
		int minIndex = 0;
		for (int i = 0; i < str.length(); i++) {
			int num=map.get(str.charAt(i));
			map.put(str.charAt(i), --num);
			if(num==1) {
				break;
			}else {
				minIndex=str.charAt(minIndex)>str.charAt(i)?i:minIndex;
			}
			
		}
		return String.valueOf(str.charAt(minIndex))+
				remove(str.substring(minIndex+1).replaceAll(String.valueOf(str.charAt(minIndex)), " "));
	}

	
}
