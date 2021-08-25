package demo_2021_8_25_;

public class NumToCharacter {
	public static void main(String[] args) {
		System.out.println(num1To9(9));
		System.out.println(num1To999(999));
		System.out.println(num1To9999(1999));
		System.out.println(num1To99999999(99999999));
	}
	public static String num1To9(int n) {
		if(n>9||n<1) {
			return "";
		}
		String[]strs= {"一","二","三","四","五","六","七","八","九"};
		return strs[n-1];
	}
	
	public static String num1To99(int n,boolean hasbai) {
		if(n>99||n<1) {
			return "";
		}
		if(n<=9) {
			return num1To9(n);
		}
		int shi=n/10;
		if(shi==1&&!hasbai) {
			return "十"+num1To9(n%10);
		}else {
			return num1To9(shi)+"十"+num1To9(n%10);
		}
	}
	
	public static String num1To999(int num) {
		if(num<1||num>999) {
			return "";
		}
		if(num<100) {
			return num1To99(num, false);
		}
		String res=num1To9(num/100)+"百";
		int rest=num%100;
		if(rest==0) {
			return res;
		}else if(rest>=10) {
			res+=num1To99(rest,true);
		}else {
			res+="零"+num1To9(rest);
		}
		return res;
	}
	
	public static String num1To9999(int num) {
		if(num<1||num>9999) {
			return "";
		}
		if(num<=999) {
			return num1To999(num);
		}
		String ans=num1To9(num/1000)+"千";
		int rest=num%1000;
		if(rest==0) {
			return ans;
		}else if(rest>=100) {
			ans+=num1To999(rest);
		}else {
			ans+="零"+num1To99(num, false);
		}
		return ans;
	}
	
	public static String num1To99999999(int num) {
		if(num<1||num>99999999) {
			return "";
		}
		int wan=num/10000;
		int rest=num%10000;
		if(wan==0) {
			return num1To9999(rest);
		}
		String res=num1To9999(wan)+"万";
		if(rest==0) {
			return res;
		}else {
			if(rest<1000) {
				return res+"零"+num1To999(rest);
			}else {
				return res+num1To9999(rest);
			}
		}
	}

}
