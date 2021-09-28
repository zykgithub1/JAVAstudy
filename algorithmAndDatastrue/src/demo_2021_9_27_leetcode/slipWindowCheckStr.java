package demo_2021_9_27_leetcode;

public class slipWindowCheckStr {
	public boolean checkInclusion(String s1, String s2) {
        int[]ss1=new int[26];
        int[]ss2=new int[26];
        int m=s2.length();
        int n=s1.length();
        if(n>m){return false;}
        for(int i=0;i<n;i++){
            ss1[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            ss2[s2.charAt(i)-'a']++;
        }
        if(check(ss1,ss2))return true;
        for(int i=n;i<s2.length();i++){
            ss2[s2.charAt(i-n)-'a']--;
            ss2[s2.charAt(i)-'a']++;
            if(check(ss1,ss2)){
                return true;
            }
        }
        return false;
    }

    public boolean check(int[]s1,int[]s2){
        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]){
                return false;
            }
        }
        return true;
    }

}
