class RemoveDuplicatesII{
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int s = 1;
        for(int i=1;i<nums.length;i++){
            count = nums[i]==nums[i-1]?count+1:1;
            if(count<=2)nums[s++]=nums[i];
        }
        return nums.length==0?0:s;
    }
    
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode h = dummy;
        
        while(head!=null){
            ListNode p = head;
            boolean append = true;
            while(p.next !=null && p.next.val == p.val){
                append = false;
                p=p.next;
            }
            if(append){
                h.next = p;
                h=h.next;
            }
            head=p.next;
        }
        h.next = null;
        return dummy.next;
        
    }
}