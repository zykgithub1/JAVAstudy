package Tree;

import java.util.ArrayList;

import selfTest.selfTestTree.Node;

public class TreeEquals {

	public static boolean containsTree1(Node big, Node small) {
		if (small == null) {
			return true;
		}
		if (big == null) {
			return false;
		}
		if (isSameValueStructure(big, small)) {
			return true;
		}
		return containsTree1(big.left, small) || containsTree1(big.right, small);
	}

	public static boolean isSameValueStructure(Node head1, Node head2) {
		if (head1 == null && head2 != null) {
			return false;
		}
		if (head1 == null && head2 == null) {
			return true;
		}
		if (head1 != null && head2 == null) {
			return false;
		}
		if (head1.value != head2.value) {
			return false;
		}
		return isSameValueStructure(head1.left, head2.left) && isSameValueStructure(head1.right, head2.right);
	}
	public static boolean containsTree2(Node big,Node small) {
		if(small==null) {
			return true;
		}
		if(big==null) {
			return false;
		}
		ArrayList<String> b=preSrial(big);
		ArrayList<String> s=preSrial(small);
		String[] str=new String[b.size()];
		for(int i=0;i<b.size();i++) {
			str[i]=b.get(i);
		}
		String[] match=new String[s.size()];
		for(int i=0;i<s.size();i++) {
			match[i]=s.get(i);
		}
		return getIndexOf(str,match)!=-1;
		
	}

	private static int getIndexOf(String[] str1, String[] str2) {
		if(str1==null||str1.length<1||str2.length>str1.length||str2==null) {
			return -1;
		}
		int x=0,y=0;
		int[] next=getNextArray(str2);
		while(x<str1.length&&y<str2.length) {
			if(isEqual(str1[x],str2[y])) {
				x++;y++;
			}
			else if(next[y]==-1) {
				x++;
			}
			else {
				y=next[y];
			}
		}
		return y==str2.length?x-y:-1;
	}

	private static int[] getNextArray(String[] ms) {
		if(ms.length==1) {
			return new int[] {-1};
		}
		int[] next=new int[ms.length];
		next[0]=-1;
		next[1]=0;
		int i=2;
		int cn=0;
		while(i<ms.length) {
			if(isEqual(ms[i-1], ms[cn])) {
				next[i++]=++cn;
			}
			else if(cn>0) {
				cn=next[cn];
			}else {
				next[i++]=0;
			}
		}
		return next;
	}

	private static boolean isEqual(String a, String b) {
		if(a==null&&b==null) {
			return true;
		}
		else {
			if(a==null||b==null) {
				return false;
			}
			else {
				return a.equals(b);
			}
		}
	}

	public static ArrayList<String> preSrial(Node x) {
		ArrayList<String> res=new ArrayList<>();
		if(x==null) {
			res.add(null);
		}
		preOrder(x,res);
		return res;
	}

	private static void preOrder(Node x, ArrayList<String> res) {
		if(x==null) {
			res.add(null);
		}
		else {
			res.add(String.valueOf(x.value));
			preOrder(x.left, res);
			preOrder(x.right, res);
		}
	}
}
