class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int maxNow = nums[0];
        for(int i=1;i<nums.length;i++){
            maxNow = maxNow + nums[i]>nums[i]?maxNow + nums[i]:nums[i];
            max=max>maxNow?max:maxNow;
        }
        return max;
    }
}