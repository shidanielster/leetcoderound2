class Partition{
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode p = less;
        ListNode q = large;
        while(head!=null){
            if(head.val<x){
                p.next = head;
                p=p.next;
            }else{
                q.next = head;
                q=q.next;
            }
            head=head.next;
        }
        q.next =null;
        p.next = large.next;
        return less.next;
    }
}