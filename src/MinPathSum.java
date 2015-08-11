class MinPathSum{
    public int minPathSum(int[][] grid) {
        int[][] r = new int[grid.length][grid[0].length];
        r[0][0] = grid[0][0];
        for(int i=1;i<grid[0].length;i++)r[0][i]=grid[0][i]+r[0][i-1];
        for(int i=1;i<grid.length;i++)r[i][0]=grid[i][0]+r[i-1][0];
        
        for(int i=1;i<grid.length;i++){
            for(int j =1;j<grid[0].length;j++){
                r[i][j]= r[i-1][j]<r[i][j-1]?r[i-1][j]+grid[i][j]:r[i][j-1]+grid[i][j];
            }
        }
        return r[grid.length-1][grid[0].length-1];
    }
}