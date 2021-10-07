package demo_2021_9_27_leetcode;

import java.util.Stack;

public class largestRectangleInMatrix {
	public int maximalRectangle(String[] matrix) {
        int m=matrix.length;
        if(m==0){
            return 0;
        }
        int n=matrix[0].length();
        int[][]left=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i].charAt(j)=='1'){
                    left[i][j]=(j==0?0:left[i][j-1])+1;
                }
            }
        }
        int ans=0;
        for(int j=0;j<n;j++){
            int[]arr=new int[m+2];
            Stack<Integer>stack=new Stack();
            int index=1;
            for(int i=m-1;i>=0;i--){
                arr[index++]=left[i][j];
            }
            int area=0;
            stack.push(0);
            for(int i=1;i<m+2;i++){
                while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                    int hei=arr[stack.pop()];
                    int width=i-stack.peek()-1;
                    area=Math.max(area,hei*width);
                }
                stack.push(i);
            }
            ans=Math.max(ans,area);
            
        }
        return ans;
    }
	
	public static int bruteWay(String[]matrix) {
		int m=matrix.length;
        if(m==0){
            return 0;
        }
        int n=matrix[0].length();
        int[][]left=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i].charAt(j)=='1'){
                    left[i][j]=(j==0?0:left[i][j-1])+1;
                }
            }
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i].charAt(j)=='1'){
                    int width=left[i][j];
                    int area=width;
                    for(int k=i-1;k>=0;k--){
                        width=Math.min(width,left[k][j]);
                        area=Math.max(area,(i-k+1)*width);
                    }
                    ans=Math.max(ans,area);
                }
            }
        }
        return ans;
	}

}
