class LongestPalindromicSubstring{
    public static void main(String ... args){
        System.out.println(len("abccba") );    
    }
    
    /*
     * easy solution
     * keep a windows to scan forward and backword
     * make capture aba and abba cases
     */
    public static int len(String s){
        int max = 0;
        for(int i =0; i< s.length();i++){
            int len1 = len(s,i,i);
            int len2 = len(s, i,i+1);
            max = max > len1?max:len1;
            max = max > len2?max:len2;
        }
        return max;
    }
    
    public static int len(String s, int left, int right){
        int len = 0;
        while(left>=0&&right<=s.length()-1){
            if(s.charAt(left)==s.charAt(right)){
                len=right-left+1;
                left--;
                right++;
            }else{
                break;
            }
        }
        return len;
    }
}