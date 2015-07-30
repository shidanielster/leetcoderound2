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
    
    /*
     * This urgly solution is 10% fast than previous
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode s = new ListNode(0);
        ListNode head = s;
        if(l1==null)return l2;
        else if (l2==null)return l1;
        
        while(true){
            if(l1.val<l2.val){
                s.next=l1;
                l1=l1.next;
                s=s.next;

                if(l1==null)break;
                
            }else{
                s.next=l2;
                s=s.next;
                l2=l2.next;
                if(l2==null)break;
            }
        }
        s.next = l1==null?l2:l1;
        return head.next;
    }
}