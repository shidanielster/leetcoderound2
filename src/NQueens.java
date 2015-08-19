import java.util.*;

class NQueens{

    
    public List<List<String>> solveNQueens(int n) {
        boolean[] y = new boolean[n];
        int[] map = new int[n];
        List<List<String>> lists = new ArrayList<List<String>>();
        char[][] a = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]='.';
            }
        }
        
        solve(n,y,map,a,lists,0);
        return lists;
    }
    
    private void solve(int n,boolean[] y, int[] map, char[][] a, List<List<String>> lists, int i){
        if(i==n){
            //a good queen, add to the list
            List<String> list = new ArrayList<String>();
            for(int x=0;x<n;x++){
                String str = new String(a[x]);
                list.add(str);
            }
            lists.add(list);
            return;
        }
        
        for(int j =0; j < n;j++){
            if(y[j])continue;
            
            boolean same = false;
            for(int x=0;x<i;x++){
                //(x, map[x]) and (i,j) should not be same line
                if(Math.abs(j-map[x])==Math.abs(i-x)){
                    same= true;
                    break;
                }
            }
            if(same)continue;
            y[j]=true;
            map[i]=j;
            a[i][j]='Q';
            solve( n, y,  map,  a,  lists,  i+1);
            
            y[j]=false;
            a[i][j]='.';
        }
    }
}