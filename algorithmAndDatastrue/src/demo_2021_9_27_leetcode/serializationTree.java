package demo_2021_9_27_leetcode;

public class serializationTree {
	public void dfs(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("#,");
            return;
        }
        sb.append(root.val);
        sb.append(",");
        // sb.append("#");
        dfs(root.left,sb);
        dfs(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        dfs(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[]strs=data.split(",");
        List<String> list=new ArrayList();
        for(String str:strs){
            list.add(str);
        }
        return dfs(list);
    }
    public TreeNode dfs(List<String> list){
        if(list.size()==0||list.get(0).equals("#")){
            list.remove(0);
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        root.left=dfs(list);
        root.right=dfs(list);
        return root;
    }

}
