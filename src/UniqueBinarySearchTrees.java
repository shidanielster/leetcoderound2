class UniqueBinarySearchTrees{
    
    /*
     * https://leetcode.com/problems/unique-binary-search-trees/
     * solution is simple
     * fn = f0*fn-1 + f1*fn-2 + ... + fn-1*f0
     * 
     */
     
    public int numTrees(int n) {
        int[] a = new int[n+1];
        a[0]=1;
        a[1]=1;
        for(int i = 2;i <=n;i++){
            for(int j=0;j<i;j++){
                a[i]+=a[j]*a[i-j-1];
            }
        }
        return a[n];
    }


}