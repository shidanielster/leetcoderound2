class RemoveDuplicates{
    /*
     * definition of ret
     * the next none dup num will be inserted here
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length==0)return 0;
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(ret==0||nums[i]!=nums[ret-1]){
                nums[ret++]=nums[i];
            }
        }
        return ret;
    }
    
    /*
     * ret is the top of the new array
     */
     
    public int removeDuplicates2(int[] nums) {
        int ret = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[ret]){
                nums[++ret]=nums[i];
            }
        }
        return nums.length==0?0:ret+1;
    }
}