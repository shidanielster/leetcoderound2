import java.util.*;

class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map =new HashMap<Character,Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        for(int i=0;i<s.length();i++){
            if(map.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty() || !stack.pop().equals(map.get(s.charAt(i)) ))return false;
            }
        }
        return stack.isEmpty();
    }
    
    /*
     * version 2 is about 30% fast than version1 
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map =new HashMap<Character,Character>();
        Set<Character> set = new HashSet<Character>();
        set.add('(');
        set.add('[');
        set.add('{');
        
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                stack.push(s.charAt(i));
            }else{
                if(stack.isEmpty() || !stack.pop().equals(map.get(s.charAt(i)) ))return false;
            }
        }
        return stack.isEmpty();
    }
    
}