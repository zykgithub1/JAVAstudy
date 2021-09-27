package demo_2021_9_27_leetcode;

public class decode2 {
	final int MOD=(int)1e9+7;
    long[]dp;
    public int numDecodings(String s) {
        dp=new long[s.length()+1];
        Arrays.fill(dp,-1);
        return (int)process(s.toCharArray(),0);
    }
    public long process(char[]chs,int index){
        if(index==chs.length){
            return 1;
        }
        if(chs[index]=='0'){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        char ch=chs[index];
        long ans=((decodeOne(ch)*process(chs,index+1))+
        (index+1<chs.length?decodeTwo(ch,chs[index+1])*process(chs,index+2):0))%MOD;
        return  dp[index]=ans;
    }
    public int decodeOne(char ch){
        if(ch=='*'){
            return 9;
        }
        if(ch=='0'){
            return 0;
        }
        return 1;
    }
    public int decodeTwo(char ch1,char ch2){
        if(ch1=='*'&&ch2=='*'){
            return 15;
        }
        if(ch1=='*'){
            if(ch2<='6'){
                return 2;
            }
            return 1;
        }
        if(ch2=='*'){
            if(ch1=='1'){
                return 9;
            }
            if(ch1=='2'){
                return 6;
            }
            return 0;
        }
        int sum=(ch1-'0')*10+ch2-'0';
        return sum>=10&&sum<=26?1:0;
    }
	

}
