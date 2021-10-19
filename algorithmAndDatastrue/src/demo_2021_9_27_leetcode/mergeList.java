package demo_2021_9_27_leetcode;

public class mergeList {
	public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode left=sortList(head);
        ListNode right=sortList(temp);
        ListNode ans=new ListNode(0);
        ListNode cur=ans;
        while(left!=null&&right!=null){
            if(left.val<right.val){
                cur.next=left;
                left=left.next;
            }else{
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        cur.next=left!=null?left:right;
        return ans.next;
    }

}
