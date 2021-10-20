package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.List;

public class kSizesubSet {
	List<List<Integer>> ans=new ArrayList();
    List<Integer>list=new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,1,k,list);
        return ans;
    }

    public void dfs(int n,int index,int k,List<Integer>list){
        if(list.size()+(n-index+1)<k){
            return;
        }
        if(list.size()==k){
            ans.add(new ArrayList(list));return;
        }
        list.add(index);
        dfs(n,index+1,k,list);
        list.remove((Integer)index);
        dfs(n,index+1,k,list);
    }

}
