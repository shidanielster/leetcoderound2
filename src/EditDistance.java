class EditDistance{

    /*
     * combind both DP and minimize n2 check
     */
     
    public int minDistance(String word1, String word2) {
        if(word1.length()==0)return word2.length();
        else if(word2.length()==0)return word1.length();
        
        int i=0;
        while(i<word1.length()&&i<word2.length()&&word1.charAt(i)==word2.charAt(i))i++;
        int m = word1.length()-1;
        int n = word2.length()-1;
        while(m>=0&&n>=0&&word1.charAt(m)==word2.charAt(n)){
            m--;n--;
        }
        
        if(m<i)return word2.length()-word1.length();
        else if(n<i)return word1.length()-word2.length();
        else return min(word1.substring(i,m+1),word2.substring(i,n+1));
    }
    
    private int min(String s1, String s2){
        
        int[][] r = new int[s1.length()+1][s2.length()+1];
        for(int i=0;i<=s1.length();i++){
            r[i][s2.length()]=s1.length()-i;
        }
        for(int i=0;i<=s2.length();i++){
            r[s1.length()][i]=s2.length()-i;
        }
        
        for(int i=s1.length()-1;i>=0;i--) {
            for(int j = s2.length()-1;j>=0;j--) {
                if(s1.charAt(i)==s2.charAt(j)) {
                    r[i][j]=r[i+1][j+1];
                }else{
                    r[i][j]=1+Math.min(r[i+1][j+1], Math.min(r[i][j+1],r[i+1][j]));
                }
            }
        }
        return r[0][0];
    }    
}