package demo_2021_9_27_leetcode;

import java.util.Stack;

public class largestRectangleArea {
	public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int neh[]=new int[n+2];
        for(int i=0;i<n;i++){
            neh[i+1]=heights[i];
        }
        Stack<Integer>stack=new Stack();
        stack.push(0);
        heights=neh;
        int ans=0;
        for(int i=1;i<n+2;i++){
            while(heights[stack.peek()]>heights[i]){
                int alltitude=heights[stack.pop()];
                int width=i-stack.peek()-1;
                ans=Math.max(ans,width*alltitude);
            }
            stack.push(i);
        }
        return ans;

    }

}
