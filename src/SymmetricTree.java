class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return mirror(root.left, root.right);
        
    }
    
    public boolean mirror(TreeNode l, TreeNode r) {
        if(l==null && r==null) return true;
        else if(l ==null || r==null ) return false;
        else return l.val== r.val &&
            mirror(l.left, r.right) && 
            mirror(l.right,r.left);
    }

}