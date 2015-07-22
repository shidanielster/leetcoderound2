import java.util.*;

class ThreeSum{
    public static void main(String[] args){
        System.out.println(new ThreeSum().threeSum(new int[]{0,0,0,0}));
    }
    
    /*
     * Need to remove dup
     * if x is not dup, y is not dup, then z is not dup
     */
     
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int x=nums[i];
            //remove dup i
            if(i>0&&nums[i]==nums[i-1])continue;
            int s = i+1;
            int e = nums.length -1;
            
            while(s<e){
                if(nums[s]+nums[e]>-x){
                    e--;
                }else if(nums[s]+nums[e]<-x){
                    s++;
                }else{
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(x);
                    list.add(nums[s]);
                    list.add(nums[e]);
                    lists.add(list);
                    
                    s++;e--;
                                        
                    //remove dup s
                    while(s<e&&list.get(1)==nums[s])s++;
                }
            }
            
        }
        return lists;
    }
}