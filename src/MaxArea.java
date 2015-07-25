import java.util.*;

class MaxArea{
    /*
     * solution 1 brutal force
     *
     */
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
    
    /*
     * Solution 2
     * Use 2 pointers
     * i from 0->n
     * j from n->0
     * for each i, find a j which j>=i
     * then area[i] = (j-i)*heigth[i]
     */
    public int maxArea(int[] height) {
        int ret = 0;
        return ret;
    }

}