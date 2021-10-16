package demo_2021_9_27_leetcode;

import java.util.ArrayList;
import java.util.List;

public class expressionAddOperate {
	int n;
    List<String>ans=new ArrayList();
    int target;
    String num;
    public List<String> addOperators(String nu, int ta) {
        n=nu.length();
        target=ta;
        num=nu;
        StringBuilder sb=new StringBuilder();
        dfs(sb,0,0,0);
        return ans;
    }
    public void dfs(StringBuilder sb,int index,long cur,long last){
        if(index==n){
            if(cur==target){
                ans.add(sb.toString());
            }return;
        }
        int sighIndex=sb.length();
        if(index>0){
            sb.append(0);
        }
        long val=0;
        for(int i=index;i<n&&(num.charAt(index)!='0'||i==index);i++){
            val=val*10+num.charAt(i)-'0';
            sb.append(num.charAt(i));
            if(index==0){
                dfs(sb,i+1,val,val);
            }else{
                sb.setCharAt(sighIndex,'+');
                dfs(sb,i+1,cur+val,val);
                sb.setCharAt(sighIndex,'-');
                dfs(sb,i+1,cur-val,-val);
                sb.setCharAt(sighIndex,'*');
                dfs(sb,i+1,cur-last+last*val,last*val);
            }
        }
        sb.setLength(sighIndex);
    }

}
