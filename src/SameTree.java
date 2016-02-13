public class SameTree{
    /*
    https://leetcode.com/problems/same-tree/
    */
    
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null){
            return q==null;
        }else if(q!=null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }else{
                return false;
            }
        }else{
            return false;
        }
        
    }
    
    /*
    base on fail fast
    */
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if(p==q)return true;
        if(p==null||q==null)return false;
        else if(p.val!=q.val)return false;
        else return isSameTree2(p.left,q.left) && isSameTree2(p.right,q.right);
    }   
    
    
}