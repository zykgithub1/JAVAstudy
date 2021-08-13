 package demo_2021_8_13;

public class manacher {
	/*
	 * 1221  -> #1#2#2#1
	 * s->str
	 * int R;
	 * int C;
	 * int[]pArr=new int[str.length]
	 * for(i=0;i<str.lentth;i++){
	 * 		if (i' out of R){
	 * 			brute extend
	 *		}else{
	 *			if(i' in L-R){
	 *			pArr[i]=blackBox(O 1)
	 *			}else if(i' partition in L-R){
	 *			pArr[i]=blackBox(O 1)
	 *			}else{i' Ñ¹Ïß LR}
	 *		}	
	 * }
	 * 
	 */
	
	public static void main(String[] args) {
	}
	
	public static char[]manacherString(String str){
		char[]charArr=str.toCharArray();
		char[]res=new char[str.length()*2+1];
		int n=res.length;
		int index=0;
		for(int i=0;i<n;i++) {
			res[i]=(i&1)==0?'#':charArr[index++];
		}
		return res;
	}
	
	public static int maxLcpsLength(String s) {
		char[] str = manacherString(s); 
		int n=str.length;
		int pArr[]=new int[n];
		int R=-1;  //rightbound +1 ->R    (available rightbound) is R-1
		int C=-1;  //center
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {  
			pArr[i]=R>i?Math.min(pArr[2*C-i],R-i):1;
			while(i+pArr[i]<n&&i-pArr[i]>-1) {
				if(str[i+pArr[i]]==str[i-pArr[i]]) {
					pArr[i]++;
				}else {
					break;
				}
			}
			if(i+pArr[i]>R) {
				R=i+pArr[i];
				C=i;
			}
			max=Math.max(max, pArr[i]);
		}
		return max-1;
	}

}
