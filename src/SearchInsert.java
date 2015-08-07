class SearchInsert{
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        while(s<e){
            int m = (s+e)/2;
            if(nums[m]<target){
                s=m+1;
            }else if(nums[m]>target){
                e=m;
            }else{
                return m;
            }
        }
        return nums[s]<target?s+1:s;
    }
}