class RemoveElement {
    /*
    */
    
    public int removeElement(int[] nums, int val) {
        int ret = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[ret++]=nums[i];
            }
        }
        return nums.length==0?0:ret;
    }
}