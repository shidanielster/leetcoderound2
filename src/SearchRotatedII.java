import java.util.*;

class SearchRotatedII{
    
    public static void main(String[] args){
        System.out.println(new SearchRotatedII().search(new int[] {1,3},3));
    }
    public boolean search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }
    
   //assume t in [s,e]
    private boolean  search(int[] a, int s, int e, int t) {
        if(s>=e){
            return a[s]==t;
        }
        
        if(a[s]<a[e]){
            return Arrays.binarySearch(a,s,e+1,t)<0?false:true;
        }else if(a[s]==a[e]){
            return search(a,s+1,e,t);
        }

        int m = (s+e)/2;
        if(a[m]<a[e]){
        //down
            if(t<a[m]){
                return search(a,s,m-1,t);
            }else{
                int i = Arrays.binarySearch(a,m,e+1,t);
                return i<0?search(a,s,m,t):true;
            }
        }else if(a[m]==a[e]){
            return  search(a,s,e-1,t);
        }else if(a[m]>a[e]){
        //up
            if(a[m]<t){
                return search(a,m+1,e,t);
            }else{
                int i = Arrays.binarySearch(a,s,m+1,t);
                return i<0?search(a,m+1,e,t):true;
            }
        }
        return false;
    }
}