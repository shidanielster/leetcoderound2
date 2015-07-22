import java.util.*;

public class Twosum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> s = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length;i++){
            int x = nums[i];
            if(s.containsKey(target-x)){
                return new int[]{s.get(target-x)+1,i+1};
            }else{
                s.put(x,i);
            }
        }
        return null;
    }
}