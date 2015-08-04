import java.util.*;

class LongestValidParentheses {
    public static void main(String [] args){
        
        System.out.println(new LongestValidParentheses().longestValidParentheses("()"));
    }
    
    /*
     *  first thought
     * A O(n2)
     * from 0->2n, for each i,i+1, check if it is a valid parentheses
     * this solution is from longest palindrome
     *
     * B O(n)
     *  1. for each (i,i+1) and (j,j+1)
     *      if (i,j) in the same valid range, then the length should be the same
     *      so one scan from 0->2n is OK
     *  2. for parentheses, the one completes near current index will be calculated first.
     *      so natually we should use a stack
     *  3. Define a valid string range
     *     It should be (start, end]. length is end - start
     *     For end, it is current index and it should be a ')' 
     *     For start, it should be one of:
     *        a. '(': As all ( will be pushed into stack, the position should be top - 1
     *        b. -1 : Will mark this as initial start pos
     *        c. ')':  There are 2 kinds of ')'
     *              * valid one:  )()()()  range (start,end] is a valid string
     *              * invalid  :  )()()()  range (start,end] is not valid, then we need to reset the start
     *
     *
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        int top = -1;
        int[] arr = new int[s.length()];
        int start = -1;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                arr[++top]=i;
            }else if(top<0){
                start = i;
            }else {
                top--;
                int len = top<0?i-start:i-arr[top];
                max = max>len?max:len;
            }
        }
        return max;
    }
} 