import java.util.*;

class MaxArea{
    public int maxArea(int[] height) {
        int ret = 0;

        for(int i =0;i<height.length;i++){
            int prev = height[i];
            for(int j =i+1;j<height.length;j++){
                int area =( height[i]>height[j] ?height[j]:height[i] )*(j-i);
                ret = ret>area?ret:area;
            }
        }
        return ret;
    }
}