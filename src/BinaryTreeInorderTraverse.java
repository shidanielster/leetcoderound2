import java.util.*;



  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class BinaryTreeInorderTraverse{

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)return list;
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
    
    /*
     * None recursive
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode x = root;
        
        while(!stack.isEmpty()||x!=null){
            if(x==null){
                x=stack.pop();
            }else{
                while(x.left!=null){
                    stack.push(x);
                    x=x.left;
                }
            }
            list.add(x.val);
            x=x.right;
        }
        
        return list;
    }
}