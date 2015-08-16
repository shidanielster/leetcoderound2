
import java.util.*;

class Subset{

    /*
     * solution is 
     * fn = fn-1 | fn-1 + n
     */
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        lists.add(new ArrayList<Integer>());
        Arrays.sort(S);

        for(int i=0;i<S.length;i++){
            int len = lists.size();
            for(int j=0;j<len;j++){
                List<Integer> olist = lists.get(j);
                List<Integer> list = new ArrayList<Integer>(olist);
                list.add(S[i]);
                lists.add(list);
            }
        }
        return lists;
    }
}