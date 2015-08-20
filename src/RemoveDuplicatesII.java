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
}