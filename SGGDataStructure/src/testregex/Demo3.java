package testregex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3 {
	public static void main(String[] args) {
		Pattern p=Pattern.compile("[0-9]");
		Matcher m=p.matcher("aa232ssd445sds223");
		//�滻��
//		String newStr=m.replaceAll("#");
//		System.out.println(newStr);
		//�ַ����ָ
		String str="aa232ssd445sds223";
		String[]res=str.split("\\d+");
		System.out.println(Arrays.toString(res));
	}

}
