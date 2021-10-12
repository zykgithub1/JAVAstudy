package demo_2021_9_27_leetcode;

public class twoNumDivide {
	public int divide(int dividend, int divisor) {
        if(dividend==-2147483648&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        int flag=(dividend>0)^(divisor>0)?-1:1;
        dividend=dividend<0?dividend:-dividend;
        divisor=divisor<0?divisor:-divisor;
        int ans=0;
        while(dividend<=divisor){
            int k=1,value=divisor;
            while(value>=Integer.MIN_VALUE/2&&value+value>=dividend){
                value+=value;
                k+=k;
            }
            ans+=k;
            dividend-=value;
        }
        return flag==1?ans:-ans;

    }

}
