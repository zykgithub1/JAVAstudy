package demo_2021_9_27_leetcode;

public class minWindow {
	public String minWindow(String s, String t) {
        int[]tT=new int[128];
        for(int i=0;i<t.length();i++){
            tT[t.charAt(i)]++;
        }
        int[]sT=new int[126];
        int tLen=t.length();
        int sLen=s.length();
        if(sLen<tLen){
            return "";
        }
        int left=0,right=0,l=0;
        int minLen=sLen+1;
        int distance=0;
        while(right<sLen){
            char ch=s.charAt(right);
            if(tT[ch]==0){
                right++;
                continue;
            }
            if(sT[ch]<tT[ch]){
                distance++;
            }
            sT[ch]++;
            right++;
            while(distance==t.length()){
                if(minLen>right-left){
                    minLen=right-left;
                    l=left;
                }
                char hc=s.charAt(left);
                if(tT[hc]==0){
                    left++;
                    continue;
                }
                if(sT[hc]==tT[hc]){
                    distance--;
                }
                sT[hc]--;
                left++;
            }
        }
        return minLen==sLen+1?"":s.substring(l,l+minLen);
    }

}
