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
     
    /*
     * some improve to solution 2
     * if we have compute (i,j)
     * then 
     * max in (i+1,j) if i<j
     *        (i,j-1) if i>j
     * max(i,j) = max( area(i+j), max(i+1,j),max(i,j-1)) 
     * 
     */
     
    public int maxArea(int[] height) {
        int ret = 0;
        for(int i=0,j=height.length-1;i<j;){
            int area = -1;
            if(height[i]>height[j]){
                area = (j-i)*height[j];
                j--;
            }else{
                area = (j-i)*height[i];
                i++;
            }
            ret = ret>area?ret:area;
        }
        return ret;
    }

}