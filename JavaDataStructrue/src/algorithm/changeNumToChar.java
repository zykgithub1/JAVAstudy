package algorithm;

import java.util.ArrayList;
import java.util.List;

public class changeNumToChar {
	public static void main(String[] args) {
		String a="011111";
		int ans=func(a);
		System.out.println(ans);
	}
	public static int func(String str) {
		char[] chs=str.toCharArray();
		List<String> res=new ArrayList<>();
		return proces(chs,0);
	}
	private static int proces(char[] chs, int i) {
		if(i==chs.length) {
			return 1;
		}
		if(chs[i]=='0') {
			return 0;
		}
		if(chs[i]=='1'){
			int res=proces(chs, i+1);
			if(i+1<chs.length) {
				res+=proces(chs, i+2);
			}
			return res;
		}
		else if(chs[i]=='2') {
			int res=proces(chs, i+1);
			if(i+1<chs.length&&chs[i+1]>'0'&&chs[i+1]<'6') {
				res+=proces(chs, i+2);
			}
			return res;
		}
		else {
			return proces(chs, i+1);
		}
	}
}
