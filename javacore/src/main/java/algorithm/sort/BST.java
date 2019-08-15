package algorithm.sort;

/**
 * @author qidi
 * @date 2019-08-15 14:25
 */
public class BST {
    int sum;

    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        find(root, L, R);
        return sum;
    }

    public void find(TreeNode treeNode, int L, int R) {
        if (null == treeNode) {
            return;
        }
        if (treeNode.val >= L && treeNode.val <= R) {
            sum += treeNode.val;
        }
        if (treeNode.val > L) {
            find(treeNode.left, L, R);
        }
        if (treeNode.val < R) {
            find(treeNode.right, L, R);
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

}
