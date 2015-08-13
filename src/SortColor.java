
import java.util.*;

class SortColor{

    public void sortColors(int[] nums) {
        int x=0;
        int y=nums.length-1;
        for(int i=0;i<=y;i++){
            if(nums[i]<1){
                swap(nums,i,x++);
            }else if(nums[i]>1){
                if(i!=y)swap(nums,i--,y--);
            }
        }
    }
    private void swap(int[] nums,int i,int j){
        if(i==j)return;
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}