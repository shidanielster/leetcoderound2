import java.util.*;

class SearchRotated{
    public int search(int[] A, int target) {
        if(A[0]<=A[A.length-1]){
            int i =Arrays.binarySearch(A,target); 
            return i<0?-1:i;
        }else{
            return search(A,target,0,A.length);
        }
    }
    
    /*
     * assume a vliad range is [s,e)
     */
    public int search(int[] nums, int t, int s, int e){
        if(s+1==e){
            return nums[s]==t?s:-1;
        }
        int mid = (s+e)/2;
        //down
        if(nums[mid]<nums[s]){
            if(t<nums[mid]){
                //t mustbe [s,mid)
                return search(nums,t,s,mid);
            }else{
                int i =Arrays.binarySearch(nums,mid,e,t); 
                return i<0?search(nums,t,s,mid):i;
            }
        }else{
            //up
            if(t>=nums[mid]){
                //t must be [mid,e)
                return search(nums,t,mid,e);
            }else{
                int i =Arrays.binarySearch(nums,s,mid,t); 
                return i<0?search(nums,t,mid,e):i;
            }
        }
    }
}