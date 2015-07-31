class SwapParis{
    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(0);
        ListNode h = p;
        
        ListNode tmp = null;
        while(head!=null){
            if(tmp==null){
                tmp=head;
                head = head.next;
            }else{
                p.next = head;
                head = head.next;
                p=p.next;
                p.next = tmp;
                tmp = null;
                p = p.next;
            }
        }
        p.next = tmp;
        
        return h.next;
        
    }
}