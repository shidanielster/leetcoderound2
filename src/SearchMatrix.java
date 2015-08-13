class SearchMatrix{
    public boolean searchMatrix(int[][] matrix, int target) {
        int s=0;
        int e = matrix.length;
        while(s!=e-1){
            int m = (s+e)/2;
            if(target<matrix[m][0]){
                e =m;
            }else {
                s=m;
            }
        }
        int x = s;
        s=0;
        e=matrix[0].length;
        while(s+1!=e){ 
            int m = (s+e)/2;
            if(target<matrix[x][m]){ 
                e=m;
            }else{
                s=m;
            }
        }
        return matrix[x][s]==target;
    }    
}
