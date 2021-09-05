package demo_2021_9_5_;

public class editDistance {
	public static void main(String[] args) {

	}

	public static int getDistance(String s1, String s2) {
		return process(s1.toCharArray(), s2.toCharArray(), 0, 0);
	}

	private static int process(char[] chs1, char[] chs2, int s1i, int s2i) {
		if (chs1.length == s1i) {
			return chs2.length - s2i;
		}
		if (chs2.length == s2i) {
			return chs1.length - s1i;
		}
		if(chs1[s1i]==chs2[s2i]) {
			return process(chs1, chs2, s1i+1, s2i+1);
		}else {
			return Math.min(process(chs1, chs2, s1i+1, s2i),Math.min(process(chs1, chs2, s1i, s2i+1),
					process(chs1, chs2, s1i+1, s2i+1)));
		}
	}

}
