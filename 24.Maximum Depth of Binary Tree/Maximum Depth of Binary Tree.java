/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {

    	//递归终结条件，走到最末点无法再继续走下去时
    	//此时长度为零
        if(root==null)
            return 0;


        //分别记录左右分支经过了多少个node，走到最末端设置为0
        int leftmax = maxDepth(root.left);
        int rightmax = maxDepth(root.right);

        //当路走到最后，往回重复做同一件事：+1
        //然后找到最大值
        return Math.max(leftmax, rightmax)+1;
    }
}