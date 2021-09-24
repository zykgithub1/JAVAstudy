package demo_2021_9_19;

import java.util.Stack;

public class vertifyBST {
	 public boolean isValidBST(TreeNode root) {
	        Stack<TreeNode>stack=new Stack();
	        long pre=Long.MIN_VALUE;
	        while(root!=null||!stack.isEmpty()){
	            if(root!=null){
	                stack.push(root);
	                
	                root=root.left;
	            }else{
	                root=stack.pop();
	                if(root.val<=pre){
	                    return false;
	                }
	                pre=root.val;
	                root=root.right;
	            }
	        }
	        return true;
	    }

}
