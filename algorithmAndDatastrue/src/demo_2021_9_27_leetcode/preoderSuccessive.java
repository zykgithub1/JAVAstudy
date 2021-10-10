package demo_2021_9_27_leetcode;

import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class preoderSuccessive {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode>stack=new Stack();
        TreeNode pre=null;
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }else{
                cur=stack.pop();
                if(pre==p){
                    return cur;
                }
                pre=cur;
                cur=cur.right;
            }
            
        }
        return null;
        
    }
	TreeMap<Integer,Integer>map;

    public SummaryRanges() {
        map=new TreeMap();
    }
    
    public void addNum(int val) {
        Map.Entry<Integer,Integer>lessOrEqual=map.floorEntry(val);
        Map.Entry<Integer,Integer>moreOrEuqal=map.ceilingEntry(val+1);
        if(lessOrEqual!=null&&
            val>=lessOrEqual.getKey()&&val<=lessOrEqual.getValue()){
            return;
        }else{
            boolean isLeft=lessOrEqual!=null&&lessOrEqual.getValue()+1==val;
            boolean isRight=moreOrEuqal!=null&&moreOrEuqal.getKey()-1==val;
            if(isLeft&&isRight){
                int start=lessOrEqual.getKey();
                int end=moreOrEuqal.getValue();
                map.remove(lessOrEqual.getKey());
                map.remove(moreOrEuqal.getKey());
                map.put(start,end);
            }else if(isLeft){
                map.put(lessOrEqual.getKey(),val);
            }else if(isRight){
                int end=moreOrEuqal.getValue();
                map.remove(moreOrEuqal.getKey());
                map.put(val,end);
            }else{
                map.put(val,val);
            }
        }



    }
    
    public int[][] getIntervals() {
        int n=map.size();
        int[][]ans=new int[map.size()][2];
        int index=0;
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            ans[index][0]=entry.getKey();
            ans[index][1]=entry.getValue();
            index++;
        }
        return ans;
    }

}
