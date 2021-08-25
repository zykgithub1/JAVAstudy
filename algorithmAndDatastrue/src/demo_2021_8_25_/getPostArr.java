package demo_2021_8_25_;

public class getPostArr {
	public static void main(String[] args) {
		int[]pre= {1,2,3,5,4,6,7};
		int[]in= {3,2,5,1,6,4,7};
		int[]ans=getPostArray(pre,in);
		for(int an:ans) {
			System.out.printf(an+"  ");
		}
		System.out.println();
		
	}
	
	public static int[] getPostArray(int[]pre,int[]in) {
		if(pre==null||pre.length!=in.length) {
			return null;
		}
		int n=pre.length;
		int[]pos=new int[n];
		set(pre,in,pos,0,n-1,0,n-1,0,n-1);
		return pos;
	}
	
	private static void set(int[] pre, int[] in, int[] pos, int prei, int prej, int ini, int inj, int posi, int posj) {
		if(prei>prej) {
			return;
		}
		if(prei==prej) {
			pos[posj]=pre[prei];
			return;
		}
		pos[posj]=pre[prei];
		int found=ini;
		for(;found<inj;found++) {
			if(in[found]==pos[posj]) {
				break;
			}
		}
		set(pre, in, pos, prei+1, prei+found-ini, ini, found-1, posi, posi+found-ini-1);
		set(pre, in, pos, prei+found-ini+1, prej, found+1, inj, posi+found-ini, posj-1);
		
	}

}
