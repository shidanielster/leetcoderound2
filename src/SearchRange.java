class SearchRange{
    public int[] searchRange(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e&&!(nums[s]==target&&nums[e]==target)){
            int mid = (s+e)/2;
            if(nums[mid]<target){
                s=mid+1;
            }else if(nums[mid]>target){
                e= mid -1;
            }else{
                if(nums[s]!=target){
                    s++;
                }else if(nums[e]!=target){
                    e--;
                }
            }
        }
        if(s>e){
            return new int[]{-1,-1};
        }else {
            return new int[]{s,e};
        }
    }
}