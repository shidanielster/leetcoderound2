class RotateRight{
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)return head;
        
        ListNode p = head;
        int count = 0;
        while(p!=null&&k>0){
            p=p.next;
            k--;count++;
        }
        if(p==null)return rotateRight(head,k%count);
        
        ListNode q = head;
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = q.next;
        p.next = head;
        q.next = null;
        return dummy.next;
    }
}