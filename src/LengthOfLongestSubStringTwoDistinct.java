import java.util.*;

class LengthOfLongestSubStringTwoDistinct{
    /*
     * Given a string S, find the length of the longest substring T that 
     * contains at most two distinct characters
     */
    public static void main(String ... args){
        System.out.println(length2("abbac")+ " expected: 4");
        System.out.println(length2("eceba")+ " expected: 3");

    }
    
    
    /*
     * first throught: brute force way
     * Solution: 
     *     Traverse all the strings searching for substring
     *     This is a o(n2) approach.
     * 
     */
    
    public static int length(String s){
        int max = 0;
        Set<Character> set = new HashSet<Character>();
        for(int i=0; i<s.length();i++){
            int len = 0;
            for(int j=i;j<s.length();j++){
                char c = s.charAt(j);
                if(set.contains(c)) {
                    len++;
                }else{
                    if(set.size()<2){
                        len++;
                        set.add(c);
                    }else{
                        break;
                    }
                }
            }
            max=max>len?max:len;
        }
        return max;
    }
    
    /*
     * Second thought
     * Solution 2
     * 1) Use a link to track all the changed nodes
     * 2) Insert a node if it different with prvious node
     * 3) go back the link, find the node which different with current, and current -1
     *    The node next to that node will be the start position
     * 4) initial start position is 0
     * 5) if the node is the same as current node, just increase the length
     * 6) if the node is the same as previous node, increase the length, and add node to link
     * 7) else, go 3
     */
     
     /*
      * further thought to reduce the cost of solution2
      * 1) Link is not necessary, only the node marked start/last position is used
      *    So the link can be replaced by 2 viables, one for previous, one for previous - 1 
      * 2) And, the previous node can be accessed by i - 1(if i-1 ! = i)
      */
      
     public static int length2(String s){
         int max = 0;
         int[] map = new int[256];
         
         int start = 0;
         int previous = 0;

         for(int i=0;i<s.length();i++){
             if(i>0&&s.charAt(i)==s.charAt(i-1)){
                 //in this case, no need to update anything
             }else if(i>0&&s.charAt(i)!=s.charAt(i-1)){
                 //in this case, need to check if i matches the previous one
                 if(s.charAt(previous)!=s.charAt(i)){
                     start = map[s.charAt(i-1)];
                     //i - 1 does not equal i, so previous is i -1
                     previous = i - 1;
                 }
                 map[s.charAt(i)]=i;

             }else{//i=0
                 map[s.charAt(0)]=0;
             }
             int len = i - start + 1;
             max = max>len?max:len;
         }
         return max;
     }
     
}