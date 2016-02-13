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
    
    
    
}