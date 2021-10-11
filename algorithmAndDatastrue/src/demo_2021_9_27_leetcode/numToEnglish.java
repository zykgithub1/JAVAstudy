package demo_2021_9_27_leetcode;

public class numToEnglish {
	String[] singles = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
	String[] teens = { "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	String[] thousands = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0) {
			return "Zero";
		}
		StringBuilder sb = new StringBuilder();
		int e = (int) 1e9;
		for (int i = 3; i >= 0; i--, e /= 1000) {
			int curNum = num / e;
			if (curNum != 0) {
				num -= curNum * e;
				sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
			}
		}
		return sb.toString().trim();
	}

	public String toEnglish(int num) {
		StringBuilder sb = new StringBuilder();
		int hundred = num / 100;
		num %= 100;
		if (hundred != 0) {
			sb.append(singles[hundred]).append(" Hundred ");
		}
		int ten = num / 10;
		if (ten >= 2) {
			sb.append(tens[ten]).append(" ");
			num %= 10;
		}
		if (num > 0 && num < 10) {
			sb.append(singles[num]).append(" ");
		} else if (num >= 10) {
			sb.append(teens[num - 10]).append(" ");
		}
		return sb.toString();
	}

}
