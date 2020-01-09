package algorithm.sort;

/**
 * @author qidi
 * @date 2020-01-08 21:08
 */
public class ValidBST {


    public boolean isValidBST(TreeNode root) {
        //递归，左子树>根>右子树
        //节点下的所有左子树小于节点
        //节点所有的右子树小于节点
        return check(root, null, null);
    }

    public boolean check(TreeNode node, Integer left, Integer right) {
        //空树
        if (null == node) {
            return true;
        }

        //小于左节点
        if (null != left && node.val <= left) {
            return false;
        }
        //大于右节点
        if (null != right && node.val >= right) {
            return false;
        }
        //左子树小于该节点
        if (!check(node.left, left, node.val)) {
            return false;
        }
        //右子树大于该节点
        if (!check(node.right, node.val, right)) {
            return false;
        }

        return true;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



