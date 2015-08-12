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
    
    
    /* 
     * A fast solution
     * This solution is to search x, which x<target<x+1
     * Then the position returned should be x+1
     */
    public int searchInsert2(int[] nums, int target) {
        int s = 0;
        //init to length
        //as s<=e-1, so s can be [0,n-1]
        int e = nums.length;
        while(s+1!=e){
            int m = (s+e)/2;
            // assume s<=target<e
            if(target<nums[m]){
                e=m;
            }else {
                s=m;
            }
        }
        return nums[s]<target?s+1:s;
    }
}