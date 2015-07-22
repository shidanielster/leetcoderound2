import java.util.*;

class LongestCommonPrefix{
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length<1)return "";
        Arrays.sort(strs);
        
        int i = 0;
        
        String a = strs[0];
        String b = strs[strs.length-1];
        
        while(i<a.length()&&i<b.length()&&a.charAt(i)==b.charAt(i))i++;
        return a.substring(0,i);
    }
}