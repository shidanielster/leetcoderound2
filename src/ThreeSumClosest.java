import java.util.*;

class ThreeSumClosest{
    /*
     * Try the same algorithem as 3 sum o(n2)
     */
    public int threeSumClosest(int[] nums, int target) {
        int ret = nums[0]+nums[1]+nums[2];
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int val = nums[i]+nums[j]+nums[k];
                if(val<target){
                    j++;
                }else if(val>target){
                    k--;
                }else {
                    return target;
                }
                ret = Math.abs(target-val)<Math.abs(target-ret)?val:ret;
            }
        }
        return ret;
    }
}