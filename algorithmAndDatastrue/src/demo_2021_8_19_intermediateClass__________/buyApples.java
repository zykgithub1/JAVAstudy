package demo_2021_8_19_intermediateClass__________;

public class buyApples {
	public static int minBags(int apple) {
		if (apple % 2 != 0 || apple < 6) {
			return -1;
		}
		int bag6 = -1;
		int bag8 = apple / 8;
		int rest = apple - 8 * bag8;
		while (rest < 24 && bag8 >= 0) {
			int result6 = minBagBase6(rest);
			if (result6 != -1) {
				bag6 = result6;
				break;
			}
			rest = apple - 8 * (--bag8);
		}
		return bag6 == -1 ? -1 : bag6 + bag8;
	}

	private static int minBagBase6(int rest) {
		return rest % 6 == 0 ? rest / 6 : -1;
	}

}
