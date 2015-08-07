import java.util.*;

class CombinationSum{
    
    public static void main(String[] args){
        System.out.println(new CombinationSum().combinationSum(new int[]{1,2,3},8));
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        List<List<Integer>> olists =  helper(c,i+1,t);
        if(olists.size()!=0)lists.addAll(olists);
        
        //with i
        List<List<Integer>> wlists =  helper(c,i,t-c[i]);

        //t==0, which mean c[i]==target
        if(wlists.size()==0){
            return lists;
        }
        
        for(List<Integer> wlist:wlists){
            List<Integer> list = new ArrayList<Integer>();
            list.add(c[i]);
            list.addAll(wlist);
            lists.add(list);
        }
        
        return lists;
    }
}