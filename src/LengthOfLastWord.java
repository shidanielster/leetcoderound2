class LengthOfLastWord{
    public int lengthOfLastWord(String s) {
        if(s.length()==0)return 0;
        int e = s.length()-1;
        while(e>=0&&s.charAt(e)==' ')e--;
        int j=e;
        while(j>=0&&s.charAt(j)!=' ')j--;
        return e-j;
    }
}