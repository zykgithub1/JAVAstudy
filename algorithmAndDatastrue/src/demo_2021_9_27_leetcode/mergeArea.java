package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeArea {
	public int[][] merge(int[][] intervals) {
        int m=intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int left=0,right=0;
        int i=0;
        List<int[]>res=new ArrayList();
        while(i<m){
            left=intervals[i][0];
            right=intervals[i][1];
            while(i+1<m&&intervals[i+1][0]<=right){
                i++;
                right=Math.max(right,intervals[i][1]);
            }
            res.add(new int[]{left,right});
            i++;
        }
        return res.toArray(new int[res.size()][2]);

    }

}
