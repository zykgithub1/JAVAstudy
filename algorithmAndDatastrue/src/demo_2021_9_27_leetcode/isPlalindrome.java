package demo_2021_9_27_leetcode;

public class isPlalindrome {
	public int countSubstrings(String s) {
        int ans=0,n=s.length();
        for(int i=0;i<2*n-1;i++){
            int l=i/2;
            int r=l+i%2;
            while(l>=0&&r<n&&s.charAt(l)==s.charAt(r)){
                ans++;
                l--;
                r++;
            }
        }
        return ans;

    }

}
