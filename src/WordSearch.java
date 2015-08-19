class WordSearch{
    public boolean exist(char[][] board, String word) {
        boolean[][] visit= new boolean[board.length][board[0].length];
        
        for(int i =0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(valid(board,i,j,word,0,visit)){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean valid(char[][] board,int i,int j, String word,int n,boolean[][] visit){
        if(visit[i][j]||board[i][j]!=word.charAt(n))return false;
        if(n==word.length()-1)return true;

        visit[i][j]=true;
        //up/down/left/rigth
        boolean ret = 
            i-1>=0                &&valid(board,i-1,j,word,n+1, visit)||
            i+1<=board.length-1   &&valid(board,i+1,j,word,n+1, visit)||
            j-1>=0                &&valid(board,i,j-1,word,n+1, visit)||
            j+1<=board[0].length-1&&valid(board,i,j+1,word,n+1, visit);
        visit[i][j]=false;
        return ret;
    }
}