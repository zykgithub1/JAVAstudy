package demo_2021_9_27_leetcode;

public class cutBTree {
	public TreeNode pruneTree(TreeNode root) {
        if(root==null){
            return null;
        }
        root.left=pruneTree(root.left);
        root.right=pruneTree(root.right);
        if(root.left==null&&root.right==null&&root.val==0){
            return null;
        }
        return root;

    }

}
