/*
 * https://leetcode.com/submissions/detail/13009497/
 */
 
 import java.util.*;
 
class PascalTriangle{
    public static void main(String ... args){
        getRow(5);
    }   
    
    public static void getRow(int rowIndex) {
        if(rowIndex <=0)return;
        
        int[] a = new int[rowIndex];
        a[0]=1;
        for(int i=1;i<rowIndex;i++){
            for(int j=i;j>0;j--){
                a[j]+=a[j-1];
            }
        }
        System.out.println(Arrays.toString(a));       
    }

}