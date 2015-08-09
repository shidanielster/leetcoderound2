class RotateImage{
    public void rotate(int[][] matrix) {
        int n = matrix.length-1;
        int x = matrix.length/2;
        int y = (matrix.length+1)/2;
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[n-j][i];
                matrix[n-j][i]=matrix[n-i][n-j];
                matrix[n-i][n-j]=matrix[j][n-i];
                matrix[j][n-i]=t;
            }
        }
    }
}