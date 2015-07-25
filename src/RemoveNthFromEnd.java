class ListNode{
    ListNode next;
}

class RemoveNthFromEnd{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode p1 = head;
        ListNode pn = head;
        while(n-->0)pn=pn.next;
        if(pn==null){
            //remove head
            head = head.next;
            return head;
        }
        //else remove node other than head
        //p1 move to node before delete
        //pn is not null because null is handled above
        while(pn.next!=null){
            pn=pn.next;
            p1=p1.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}