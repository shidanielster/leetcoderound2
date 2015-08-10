class JumpGame{
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        boolean[] skip = new boolean[nums.length];
        can[0]=true;
        for(int i =0;i<nums.length;i++){
            if(can[i]==false)continue;
            if(skip[i])continue;
            if(i+nums[i]>=nums.length-1)return true;

            int step = 1;
            while(step<=nums[i]&&i+step<nums.length){
                int j=i+step;
                if(nums[j]+j<=i+nums[i])skip[j]=true;
                can[j]=true;
                step++;
            }
        }
        return can[nums.length-1];
    }
}