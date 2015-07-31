import java.util.*;

public class GenerateParenthesis {
    public static void main(String[] args){
        System.out.println(new GenerateParenthesis().generateParenthesis(1));
        System.out.println(new GenerateParenthesis().generateParenthesis(2));
        System.out.println(new GenerateParenthesis().generateParenthesis(3));
        System.out.println(new GenerateParenthesis().generateParenthesis(4));
    }
    
    /*
     * This is a classic backtrack.
     * go or no go
     * and then count
     */
    public List<String> generateParenthesis(int n) {
        char[] strs = new char[2*n];
        List<String> list = new ArrayList<String>();
        gen(strs,list,0,0);
        return list;
    }
    private void gen(char[] strs,List<String> list ,int i, int a){
        if(a==strs.length/2){
            for(int x=i;x<strs.length;x++){
                strs[x]=')';
            }
            list.add(new String(strs));
            return;
        }
        
        strs[i]='(';
        gen(strs,list,i+1,a+1);
        if(2*a>i){
            strs[i]=')';
            gen(strs,list,i+1,a);
        }
    }
}