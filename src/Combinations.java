class Combinations{
    /*
     * solution
     * f(n,k)= f(n-1,k) + {f(n,k-1)| n}
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(k==0)return lists;
        else if(n==k){
            List<Integer> list = new ArrayList<Integer>();
            for(int i=1;i<=n;i++){
                list.add(i);
            }
            lists.add(list);
            return lists;
        }
        
        List<List<Integer>> n1kLists = combine(n-1,k);
        lists.addAll(n1kLists);
        
        List<List<Integer>> n1k1Lists = combine(n-1,k);
        if(n1k1Lists.size()==0){
            List<Integer> list = new ArrayList<Integer>();
            list.add(n);
            lists.add(list);
        }else{
            for(List<Integer> list: n1k1Lists){ 
                list.add(n);
                lists.add(list);
            }
        }
        
        return lists;
    }
}