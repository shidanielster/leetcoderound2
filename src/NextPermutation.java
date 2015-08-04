class NextPermutation{
    /*
     * This is a classic algorithm to use Lexicographic method to generate full array
     */
    public void nextPermutation(int[] nums) {
        int x = nums.length-1;
        int y = nums.length -1;
        
        //find x  x<x++
        //not found, return last
        for(int i = nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                x= i;
                break;
            }
        }
        if(x==nums.length-1){
            reverse(nums,0,nums.length-1);
            
        }else{
            for(int i=x+1;i<nums.length-1;i++){
                if(nums[i]>nums[x]&&nums[i+1]<=nums[x]){
                    y=i;
                    break;
                }
            }
            int t = nums[x];
            nums[x]=nums[y];
            nums[y]= t;
        
            reverse(nums,x+1,nums.length-1);
        }
    }
    private void reverse(int[] n,int x, int y){
        while(x<y){
            int t = n[x];
            n[x]=n[y];
            n[y]= t;
            x++;y--;
        } 
    }
}