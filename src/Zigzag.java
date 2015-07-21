public class Zigzag {
    /*
     * use 1234567 as string to see the relationship
     * y = x + 2 (n-i);
     * y = x + 2 (i-1)
     * if n==i==1 return s
     */
     
    public String convert(String s, int numRows) {
        if(numRows==1)return s;
        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= numRows;i++){
            int x = i;
            if(x<=s.length()){
                sb.append(s.charAt(x-1));
            }
            while(x<s.length()){
                int y = x + 2*(numRows-i);
                if(y!=x&&y<=s.length()){
                    sb.append(s.charAt(y-1));
                }
                x=y;
                y=x+2*(i-1);
                if(y!=x&&y<=s.length()){
                    sb.append(s.charAt(y-1));
                }
                x=y;
            }
        }
        return sb.toString();
    }
}