package demo_2021_9_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcodeSerializeTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		leetcodeSerializeTree le = new leetcodeSerializeTree();
		String str = le.serialize(root);
		System.out.println(str);
//		le.pre(root);
		char[] charArray = str.toCharArray();
		for(char ch:charArray) {
			System.out.print(ch+" ");
		}
		le.deserialize(str);
	}

	static class TreeNode {
		public int val;
		public TreeNode left;
		public TreeNode right;

		public TreeNode(int val) {
			this.val = val;
		}

	}

	public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    public void preOrder(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]strs=data.split(",");
        List<String>list=new ArrayList();
        for(int i=0;i<strs.length;i++) {
        	list.add(strs[i]);
        }
        return reverse(list);
    }

    public TreeNode reverse(List<String> list){
        if(list.get(0).equals("#")){
            list.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=reverse(list);
        root.right=reverse(list);
        return root;
    }

}
