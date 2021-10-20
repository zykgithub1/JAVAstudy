package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class duplicateCanPick {
	List<List<Integer>>ans=new ArrayList();
    List<Integer>list=new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,0,target,list);
        return ans;
    }   
    public void dfs(int[] candidates,int index, int target,List<Integer>list){
        if(target<0){
            return;
        }
        if(index>=candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList(list));return;
        }
        for(int i=index;i<candidates.length;i++){
            if(target-candidates[index]<0){
                break;
            }
            list.add(candidates[i]);
            dfs(candidates,i,target-candidates[i],list);
            list.remove(list.size()-1);
        }
    }

}
