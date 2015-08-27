class DecodeWays{
    public int numDecodings(String s) {
        int len = s.length();
        int[] ret = new int[len+2];
        if(len>0)ret[len-1] = (s.charAt(len-1)<='9'&&s.charAt(len-1)>'0')?1:0;
        if(len>1){
            int last2 = (s.charAt(len-2)-'0')*10 + (s.charAt(len-1)-'0');
            ret[len-2]= last2 > 9 && last2<27 ? 1:0;
        }
        for(int j=len-2;j>=0;j--){
            char x = s.charAt(j);
            char y = s.charAt(j+1);
            if(x>'0'&&x<='9'){
                ret[j]+=ret[j+1];
            }
            int sum = (x-'0')*10 + (y-'0');
            if(sum >9 && sum < 27){
                ret[j]+=ret[j+2];
            }
        }
        return ret[0];
    }
}