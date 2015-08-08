class NextPermutation{
    /*
     * This is a classic algorithm to use Lexicographic method to generate full array
     */
 public void nextPermutation(int[] nums) {
        if(nums.length<2)return ;
        int i = nums.length-2;
        while(i>0&&nums[i]>=nums[i+1])i--;
        int j = i;
        while(j<nums.length-1&&nums[j+1]>nums[i])j++;
        if(nums[i]==nums[j]){
            reverse(nums,0,nums.length-1);
            return ;
        }
        swap(nums,i,j);
        reverse(nums,i+1,nums.length-1);
    }
    
    private void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
    
    private void reverse(int[] nums,int i,int j){
        while(i<j){
            swap(nums,i,j);
            i++;j--;
        }
    }
}