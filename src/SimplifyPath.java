import java.util.*;

class SimplifyPath{
    public static void main(String[] args){
        System.out.println(new SimplifyPath().simplifyPath("/.../abc"));
    }
    public String simplifyPath(String path) {
        int i =0;
        int j = 0;
        Stack<String> stack = new Stack<String>();
        while(j<=path.length()){
            if(j==path.length()){
                if(i<j){
                    String s = path.substring(i,j);
                    System.out.println(s);
                    put(s,stack);    
                }
                break;   
            }
            //path should be in [i,j)
            if(path.charAt(j)!='/'){
                j++;
            }else{
                String s = path.substring(i,j);
                put(s,stack);
                i=j+1;
                j=i;
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        return sb.toString();
    }
    private void put(String s, Stack<String> stack){
        if("..".equals(s)){
            if(!stack.isEmpty())stack.pop();
        }else if(".".equals(s)||"".equals(s)){
                //nothing
        }else{
            stack.push(s);
        }
    }
}