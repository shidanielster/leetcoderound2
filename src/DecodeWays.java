class DecodeWays{
    public int numDecodings(String s) {
        int[] ret = new int[s.length()+2];
        if(s.length()>0)ret[s.length()-1] = (s.charAt(s.length()-1)<='9'&&s.charAt(s.length()-1)>'0')?1:0;
        if(s.length()>1){
            int sum1 = (s.charAt(s.length()-2)-'0')*10 + (s.charAt(s.length()-1)-'0');
            ret[s.length()-2]= sum1 > 9 && sum1<27 ? 1:0;
        }
        for(int j=s.length()-2;j>=0;j--){
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