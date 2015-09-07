class UniqueBinarySearchTreesII{
    public List<TreeNode> generateTrees(int n) {
        return gen(1,n);
    }
    
    private List<TreeNode> gen(int s, int e){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(s>e){
            list.add(null);
            return list;
        }
        
        for(int i = s; i<=e;i++){
            for(TreeNode l : gen(s,i-1)){
                for(TreeNode r: gen(i+1,e)){
                    TreeNode t = new TreeNode(i);
                    t.left=l;
                    t.right=r;
                    list.add(t);
                }
            }
        }
        return list;
    }
}