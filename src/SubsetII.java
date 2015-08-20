import java.util.*;

class SubsetII{


    public List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        Arrays.sort(S);
        lists.add(new ArrayList<Integer>());
        int count = 0;
        for(int i=0;i<S.length;i++){
            int len = lists.size();

            if(i>0&&S[i]==S[i-1]){
                count++;
            }else{
                count=0;
            }
            int start = count*len/(count+1);
    
            for(int j=start;j<len;j++){
                List<Integer> olist = lists.get(j);
                List<Integer> list = new ArrayList<Integer>(olist);
                list.add(S[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}