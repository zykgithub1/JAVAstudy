package demo_2021_8_20_;

public class parenthesis {
	public static int countParenthesis(String str) {  
		int count = 0;
		int ans = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				count++;
			} else {
				if (count == 0) {
					ans++;
				} else {
					count--;
				}
			}
		}
		return ans + count;
	}

}
