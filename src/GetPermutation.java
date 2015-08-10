class GetPermutation {
    public static void main(String[] args){
        System.out.println(new GetPermutation().getPermutation(2,2));
    }
    
    public String getPermutation(int n, int k) {
        int r = 1;
        for(int i=2;i<=n;i++){
            r*=i;
        }
        k=(k-1)%r;
        
        char[] strs = new char[n];
        for(int i=0;i<n;i++){
            strs[i]= (char)('1'+i);
        }
        
        while(k-->0) next(strs);
        return new String(strs);
    }
    private void next(char[] strs){
        if(strs.length<2)return;
        int j = strs.length-2;
        
        //find n which  a[n] < a[n+1]
        while(j>=0&&strs[j]>=strs[j+1])j--;
        if(j==-1){
            reverse(strs,0,strs.length-1);
            return; 
        }
        int i = j+1;
        
        //find n which      a[n] > x >= a[n+1] 
        while(i<strs.length&&strs[i]>strs[j])i++;
        swap(strs,i-1,j);
        
        reverse(strs,j+1,strs.length-1);
    }
    
    private void swap(char[] strs, int i, int j){
        char t = strs[i];
        strs[i]=strs[j];
        strs[j]=t;
    }
    
    private void reverse(char[] strs,int i, int j){
        while(i<j) swap(strs,i++,j--);
    }
}