package demo_2021_9_19;

public class fllatenDoubleLinkedLIst {
	 public Node flatten(Node head) {
	        if(head==null){
	            return head;
	        }
	        Node cur=head;
	        while(cur!=null){
	            if(cur.child!=null){
	                Node temp=cur.next;
	                Node child=flatten(cur.child);
	                Node childEnd=getEnd(child);
	                child.prev=cur;
	                childEnd.next=cur.next;
	                if(cur.next!=null){
	                    cur.next.prev=childEnd;
	                }
	                cur.next=child;
	                cur.child=null;
	                cur=temp;
	            }else{
	                cur=cur.next;
	            }
	        }
	        return head;
	    }
	    public Node getEnd(Node child){
	        while(child.next!=null){
	            child=child.next;
	        }
	        return child;
	    }

}
