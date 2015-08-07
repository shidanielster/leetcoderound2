
import java.util.*;

class IsValidSudoku{
    public static void main(String [] args){
        System.out.println(new IsValidSudoku().isValidSudoku(new char[][]{".87654321".toCharArray(),       
        "2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),
        "5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),
        "8........".toCharArray(),"9........".toCharArray()}));
        
    }
    public boolean isValidSudoku(char[][] board) {
        Set<Character> lset = new HashSet<Character>();
        Set<Character> hset= new HashSet<Character>();
        Set<Character> oset= new HashSet<Character>();

        for(int i = 0 ;i<board.length;i++){  
            for(int j = 0; j<board.length;j++){
                if(board[i][j]!='.'){
                    if(hset.contains(board[i][j])){
                        return false;
                    }else{
                        hset.add(board[i][j]);
                    }
                }
                if(board[j][i]!='.'){ 
                    if(lset.contains(board[j][i])){
                        return false;
                    }else{
                        lset.add(board[j][i]);
                    }
                }
            }
            
            int x = i/3;
            int y = i%3; 
            
            for(int n=3*x;n<3*x+3;n++){
                for(int m = 3*y;m<3*y+3;m++){
                    if(board[n][m]=='.')continue;
                    if(oset.contains(board[n][m])){
                        System.out.println("n:"+n+" M:"+m);
                        return false;
                    }else{
                        oset.add(board[n][m]);
                    } 
                }
            }
            lset.clear();
            hset.clear();
            oset.clear();
        }
        return true;
    }
}