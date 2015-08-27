class ReverseLinkedList{

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        ListNode d = dummy;
        ListNode p = head;
        
        int i = 1;
        while(i<m){
            d.next = p;
            d=d.next;
            p=p.next;
            i++;
        }
        d.next = null;

        while(i<=n){
            ListNode q = p;
            p = p.next;
            q.next = d.next;
            d.next = q;
            i++;
        }
        
        while(d.next!=null)d=d.next;
        d.next = p;
        return dummy.next;
    }
}