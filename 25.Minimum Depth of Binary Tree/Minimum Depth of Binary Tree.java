/*这道题是树的题目，其实跟Maximum Depth of Binary Tree非常类似，

只是这道题因为是判断最小深度，所以必须增加一个叶子的判断（
因为如果一个节点如果只有左子树或者右子树，我们不能取它左右子树中小的作为深度，因为那样会是0，我们只有在叶子节点才能判断深度，而在求最大深度的时候，因为一定会取大的那个，所以不会有这个问题。
这道题同样是递归和非递归的解法，递归解法比较常规的思路，比Maximum Depth of Binary Tree多加一个左右子树的判断*/


public int minDepth(TreeNode root) {

	//空树，返回0
    if(root == null)
        return 0;


    //左节点为空
    if(root.left == null)
    	//返回右节点长度
        return minDepth(root.right)+1;

    //反之
    if(root.right == null)
        return minDepth(root.left)+1;
    //用来判断一棵树只有左支或者右支


    //找到最小
    return Math.min(minDepth(root.left),minDepth(root.right))+1;
}
