import java.util.*;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return helper(candidates,0,target);
    }
    
    public List<List<Integer>> helper(int[] c, int i, int t) {
        List<List<Integer>> lists =   new ArrayList<List<Integer>>(); 
        if(i==c.length||t<c[i])return lists;
        if(c[i]==t){
            List<Integer> list = new ArrayList<Integer>();
            list.add(c[i]);
            lists.add(list);
            return lists;
        }

        //without i
        int n = i;
        while(n<c.length&&c[n]==c[i])n++;
        List<List<Integer>> olists =  helper(c,n,t);
        if(olists.size()!=0)lists.addAll(olists);
        
        //with i
        List<List<Integer>> wlists =  helper(c,i+1,t-c[i]);
        
        for(List<Integer> wlist:wlists){
            List<Integer> list = new ArrayList<Integer>();
            list.add(c[i]);
            list.addAll(wlist);
            lists.add(list);
        }
        
        return lists;
    }
}