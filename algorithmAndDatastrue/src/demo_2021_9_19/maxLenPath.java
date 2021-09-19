package demo_2021_9_19;

public class maxLenPath {
	class Solution {
	    int[][]direction={{0,1},{1,0},{-1,0},{0,-1}};
	    int m=0;
	    int n=0;
	    int[][]memo;
	    public int longestIncreasingPath(int[][] matrix) {
	        int ans=1;
	        m=matrix.length;
	        n=matrix[0].length;
	        memo=new int[m][n];
	        for(int i=0;i<m;i++){
	            for(int j=0;j<n;j++){
	                ans=Math.max(ans,dfs(matrix,matrix[i][j],i,j,1));
	            }
	        }
	        return ans;
	    }

	    public int dfs(int[][] matrix,int cur,int i,int j,int step){
	        if(memo[i][j]!=0){
	            return memo[i][j];
	        }
	        // int max=step;
	        int max=1;
	        for(int x=0;x<=3;x++){
	            int in=i+direction[x][0];
	            int jn=j+direction[x][1];
	            if(in>=0&&in<m&&jn>=0&&jn<n&&matrix[in][jn]>matrix[i][j]){
	                max=Math.max(dfs(matrix,matrix[in][jn],in,jn,step+1)+1,max);
	            }
	        }
	        memo[i][j]=max;
	        return memo[i][j];
	    }
	}

}
