package demo_2021_9_27_leetcode;

import java.util.Stack;

public class everydayTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[]ans=new int[n];
        Stack<Integer>stack=new Stack();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperatures[i]){
                int id=stack.pop();
                ans[id]=i-id;
            }
            stack.push(i);
        }
        return ans;
    }

}
