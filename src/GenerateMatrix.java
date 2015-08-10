class GenerateMatrix{
   enum State {up,down, left,right};
    
    public int[][] generateMatrix(int N) {
        State state = State.right;
        int i = 0;
        int j = 0;
        int[][] a = new int[N][N];
        
        for(int n=1; n <= N*N; n ++){
            a[i][j]=n;
            switch(state){
                case up:
                    if(i>0&&a[i-1][j]==0)i--;
                    else{
                        state = State.right;
                        j++;
                    }
                    break;
                case down:
                    if(i<N-1&&a[i+1][j]==0)i++;
                    else{
                        state = State.left;
                        j--;
                    }
                    break;
                case left:
                    if(j>0&&a[i][j-1]==0)j--;
                    else{
                        state = State.up;
                        i--;
                    }
                    break;
                case right:
                    if(j<N-1&&a[i][j+1]==0)j++;
                    else{
                        state = State.down;
                        i++;
                    }
                    break;
            }
        }
        return a;
    }
}