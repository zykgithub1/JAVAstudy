package demo_2021_9_27_leetcode;

import java.util.Arrays;
import java.util.List;

public class convertTimeAndCompare {
	public int findMinDifference(List<String> timePoints) {
        int n=timePoints.size();
        if(n>1440){
            return 0;
        }
        int[]mintimes=new int[n];
        for(int i=0;i<n;i++){
            String curTime=timePoints.get(i);
            int hour=Integer.valueOf(curTime.split(":")[0]);
            int minites=Integer.valueOf(curTime.split(":")[1]);
            int times=hour*60+minites;
            mintimes[i]=times;
        }
        Arrays.sort(mintimes);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min=Math.min(min,mintimes[i]-mintimes[i-1]);
        }
        min=Math.min(min,1440+mintimes[0]-mintimes[n-1]);
        return min;


    }

}
