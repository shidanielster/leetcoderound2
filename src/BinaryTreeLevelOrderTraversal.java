public class BinaryTreeLevelOrderTraversal{
    /*
    https://leetcode.com/problems/binary-tree-level-order-traversal/
    102. Binary Tree Level Order Traversal My Submissions Question

    */
    
    /*
    * simple solution.
    * use a list to cache all the middle output.
    * List<N> contains all nodes in list n
    * then
    * loop condition is :
    * lists will add [ node.val for node in list<N> ]
    * and next list will be [ node.left , node.right for node in List<N> ]
    * start condition is: level 1 <root>
    * end condition is list is empty
    */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>() ;
        
        if(root==null)return lists;
        List<TreeNode> curList = new ArrayList<TreeNode>();
        curList.add(root);
        
        while(curList.size()!=0){
            List<Integer> valList = new ArrayList<Integer>();

            List<TreeNode> newList = new ArrayList<TreeNode>();
            for(TreeNode x: curList) {
                valList.add(x.val);
                if(x.left!=null)newList.add(x.left);
                if(x.right!=null)newList.add(x.right);
            }
            lists.add(valList);
            curList = newList;
        }
        return lists;
    }
    
    
    public List<List<Integer>> occursive(TreeNode root){
        List<List<Integer>> lists = new ArrayList<List<Integer>>() ;
        List<TreeNode> listn = new ArrayList<TreeNode>();
        listn.add(root);
        loop(lists,listn);
        return lists;
    }
    
    private void loop(List<List<Integer>> lists, List<TreeNode> listn){
        if(listn.isEmpty())return;
        List<Integer> valList = new ArrayList<Integer>();
        List<TreeNode> newList = new ArrayList<TreeNode>();
        
        for(TreeNode x : listn){
            valList.add(x.val);
            if(x.left!=null)newList.add(x.left);
            if(x.right!=null)newList.add(x.right);            
        }
        loop(lists,newList);
    }
    

}