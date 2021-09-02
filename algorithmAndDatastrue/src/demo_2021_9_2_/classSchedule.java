package demo_2021_9_2_;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class classSchedule {
	public static void main(String[] args) {
		Solution so=new Solution();
		so.canFinish(0, null);
	}
	

}
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,Node>map=new HashMap();
        if(prerequisites==null||prerequisites.length==0){
            return true;
        }
        boolean[]visi=new boolean[numCourses];
        Arrays.fill(visi,true);
        for(int[]pre:prerequisites){
            int second=pre[0];
            int first=pre[1];
            Node se=map.get(second);
            if(se!=null){
                se.in++;
            }else{
                map.put(second,new Node(second));
                map.get(second).in++;
            }
            if(!map.containsKey(first)){
                map.put(first,new Node(first));
                map.get(first).sons.add(second);
            }else{
                map.get(first).sons.add(second);
            }
            visi[second]=false;
        }
        Queue<Node>que=new LinkedList();
        for(Map.Entry<Integer,Node>entry:map.entrySet()){
            if(entry.getValue().in==0){
                visi[entry.getKey()]=true;
                que.add(entry.getValue());
            }
        }
        while(!que.isEmpty()){
            Node cur=que.poll();
            List<Integer>lis=cur.sons;
            for(int so:lis){
                map.get(so).in--;
                if(map.get(so).in==0){
                    visi[map.get(so).num]=true;
                    que.add(map.get(so));
                }
            }
        }
        for(int i=1;i<numCourses;i++){
            if(visi[i]==false){
                return false;
            }
        }
        return true;

    }
}
class Node{
    public int num;
    public int in;
    public List<Integer> sons; 
    public Node(int nu){
        num=nu;
        in=0;
        sons=new ArrayList();
    }
}
