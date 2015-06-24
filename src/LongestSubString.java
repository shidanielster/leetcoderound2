import java.util.*;

class LongestSubString{
    /*
    * Given a string, find the length of the longest substring without repeating characters. For 
    * example, the longest substring without repeating letters for “abcabcbb” is “abc”, which 
    * the length is 3. For “bbbbb” the longest substring is “b”, with the length of 1. 
    */
    public static void main(String ... args){
        System.out.println(longest("abcabcbb")+" expected 3");
        System.out.println(longest("bbbb")+" expected 1");
    }
    
    /*
    * solution:
    * 1) for normal character, will add it to the map
    *    for repeating character, if 
    *        repeating after start : map.get(i) > start, then computer the last length, and reset start from map.get(i)+1
    *        repeating before start: should update the map with new pos
    * 2) handle special cases:
    *    When reaches end, will compute the length, should be end index - start index + 1
    */
    public static int longest(String str){
        int max = 0;
        
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        
        for(int i =0; i<str.length(); i++ ){
            Character x = str.charAt(i);
            if(!map.containsKey(x) ){
                map.put(x,i);
            }else{
                int pos = map.get(x);
                if(start>pos){
                    map.put(x,i);
                }else{
                    int len = pos - start;
                    max = max>len?max:len;
                    start = pos + 1;
                }
            }
            if(i==str.length()-1){
                int len = i-start+1;
                max=max>len?max:len;
            }
        }
        
        return max;
    }
    
    
    /*
    * solution 
    * compute the length each time.
    * if find match, then update the start postion from matched + 1;
    * 2 matched postions should be 1<start<2
    * so start should alway > pos
    * if start<=pos, then start needs update
    */
    public static int longest2(String str){
        int max = 0;
        Map<Character, Integer> map = new HashMap<Character,Integer>();
        int start = 0;
        
        for(int i = 0; i<str.length(); i++){
            Character c = str.charAt(i);
            if(map.containsKey(c)){
                int pos = map.get(c);
                if(start<=pos){
                    start = pos+1;
                }
            }
            map.put(c,i);
            int len = i-start +1;
            max = max>len?max:len;
        }
        return max;
    }
}