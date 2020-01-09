package algorithm.sort;

import java.util.Stack;

/**
 * 树的遍历
 *
 * @author qidi
 * @date 2020-01-09 10:54
 */
public class TreeTraversal {


    /**
     * 先序遍历, 反着访问顺序压栈
     * <p>
     * 根->左子树->右子树
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            //先访问节点，并从栈顶移除
            TreeNode top = stack.pop();
            System.out.println(top.val);
            //右压栈
            if (null != top.right) stack.push(top.right);
            //左压栈
            if (null != top.left) stack.push(top.left);
        }
    }

    // 中序遍历的非递归的写法，
    // 1.左节点不为null则压入左节点
    // 2.左节点为null时，pop并打印，左节点
    // 3.在往右，右节点为null时，pop并打印
    // 4.右节点不为null时，压入右节点
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (!stack.isEmpty() || null != node) {
        }

    }

    /**
     * 树的节点
     */
    class TreeNode {
        int val;
        TreeTraversal.TreeNode left;
        TreeTraversal.TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
