package demo_2021_9_27_leetcode;

public class sumTreePath {
	public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }
    public int dfs(TreeNode root,int cur){
        if(root==null){
            return 0;
        }
        int sum=cur*10+root.val;
        if(root.left==null&&root.right==null){
            return sum;
        }else{
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }

}
