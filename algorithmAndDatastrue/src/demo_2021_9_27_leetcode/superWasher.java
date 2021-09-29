package demo_2021_9_27_leetcode;

public class superWasher {
	public int findMinMoves(int[] machines) {
        int total=0;
        int n=machines.length;
        for(int i:machines){
            total+=i;
        }
        if(total%n!=0){
            return -1;
        }
        int avg=total/n;
        int leftSum=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int leftRest=leftSum-i*avg;
            int rightRest=(total-leftSum-machines[i])-(n-i-1)*avg;
            if(leftRest<0&&rightRest<0){
                ans=Math.max(Math.abs(leftRest)+Math.abs(rightRest),ans);
            }else{
                ans=Math.max(ans,Math.max(Math.abs(leftRest),Math.abs(rightRest)));
            }
            leftSum+=machines[i];
        }
        return ans;
    }

}
