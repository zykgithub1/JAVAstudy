package demo_2021_9_27_leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class mergeAllList {
	 static class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
		 
		class Solution {
		    public ListNode mergeKLists(ListNode[] lists) {
		        PriorityQueue<ListNode>que=new PriorityQueue((Comparator) new Comparator<ListNode>(){
		            public int compare(ListNode o1,ListNode o2){
		                return o1.val-o2.val;
		            }
		        });
		        int n=lists.length;
		        ListNode dump=new ListNode();
		        ListNode cur=dump;
		        for(int i=0;i<n;i++){
		            if(lists[i]!=null){
		                que.add(lists[i]);
		            }
		        }
		        while(!que.isEmpty()){
		                cur.next=que.poll();
		                cur=cur.next;
		                if(cur.next!=null){
		                    que.offer(cur.next);
		                }
		            }
		        return dump.next;

		    }

}
