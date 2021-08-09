package demo_2021_8_9;

public class bagQuesition {
	public static int process1(int[] w, int[] v, int i, int bagged, int bag) {
		if (i > w.length) {
			return 0;
		}
		if (bagged > bag) {
			return 0;
		}
		return Math.max(process1(w, v, i + 1, bagged, bag), 
				process1(w, v, i + 1, bagged + w[i], bag)) + v[i];
	}

}
