   class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
 
class  MergeTwoLists{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode s = new ListNode(0);
        ListNode head = s;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                s.next=l1;
                l1=l1.next;
            }else{
                s.next=l2;
                l2=l2.next;
            }
            s=s.next;
        }
        s.next = l1==null?l2:l1;
        return head.next;
    }
}