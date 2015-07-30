public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)return null;
        if(lists.length==1)return lists[0];
        
        ListNode[] merge = new ListNode[(lists.length+1)/2];
        for(int i=0;i<merge.length-1;i++){
            merge[i] = merge(lists[2*i],lists[2*i+1]);
        }
        merge[merge.length-1]= (lists.length)%2==0?merge(lists[lists.length-1],lists[lists.length-2]) :lists[lists.length-1];
        return mergeKLists(merge);
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
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