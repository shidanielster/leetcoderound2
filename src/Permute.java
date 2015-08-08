import java.util.*;

class Permute {
    public static void main(String[] args){
        System.out.println(new Permute().permute(new int[] {1,2}));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(toList(nums));
        nextPermutation(nums);
        List<Integer> list = toList(nums);
        while(!list.equals(lists.get(0))){
            lists.add(list);
            nextPermutation(nums);
            list = toList(nums);
        }
        return lists;
    }
    private List<Integer> toList(int[] list){
        List<Integer> l = new ArrayList<Integer>();
        for(int i:list){
            l.add(i);
        }
        return l;
    }
    
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