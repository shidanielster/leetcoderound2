import java.util.*;

class FourSum{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>> ();
        Arrays.sort(nums);
        for(int i = 0 ; i <nums.length-3;i++){
            for(int j=i+1;j<nums.length-2;j++){
                int s = j+1; 
                int e=nums.length-1;
                while(s<e){
                    int val = nums[i]+nums[j]+nums[s]+nums[e];
                    if(val<target){
                        s++;
                    }else if(val > target){
                        e--;
                    }else{
                        List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[s]);
                        list.add(nums[e]);
                        lists.add(list);
                        while(s<e&&nums[s+1]==nums[s])s++;
                        s++;
                        e--;
                    }
                }
                //remove dup j
                while(j<nums.length-2&&nums[j+1]==nums[j])j++;
            }
            //remove dup i
            while(i<nums.length-3&&nums[i+1]==nums[i])i++;
        }
        return lists;
    }
}