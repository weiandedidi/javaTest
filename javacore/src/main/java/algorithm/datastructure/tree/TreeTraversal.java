package algorithm.datastructure.tree;

import java.util.Stack;

/**
 * 树的遍历
 *
 * @author qidi
 * @date 2020-01-09 10:54
 */
public class TreeTraversal {

    //递归方式写法 Recursion递归

    /**
     * 先序遍历 根->左->右
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * @param root
     */
    public void preOrderRecursion(TreeNode root) {
        //根节点  Do Something with root
        if (root.left != null) preOrderRecursion(root.left);
        if (root.right != null) preOrderRecursion(root.right);
    }

    /**
     * 中序遍历 左->中->右
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     *
     * @param root
     */
    public void inOrderRecursion(TreeNode root) {
        if (root.left != null) inOrderRecursion(root.left);
        //根节点  Do Something with root
        if (root.right != null) inOrderRecursion(root.right);
    }

    /**
     * 后序遍历 左->中->右
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
     *
     * @param root
     */
    public void postOrderRecursion(TreeNode root) {
        if (root.left != null) postOrderRecursion(root.left);
        //根节点  Do Something with root
        if (root.right != null) postOrderRecursion(root.right);
    }

    /**
     * 先序遍历, 反着访问顺序压栈
     * <p>
     * 根->左子树->右子树
     * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
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

    /**
     * 中序遍历，想像自己沿着树走，由于是先访问左子树，在访问中，然后右子树，所以需要保存中间的节点才能找到右节点
     * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode/
     * <p>
     * 两层while循环处理
     * 内层压栈，外层出站
     * <p>
     * 1. 先左子树，左节点不为null则左节点压栈，
     * 2. 为null，pop弹栈，游标切成右节点。
     * 3. 右节点不为null时，压栈，为null弹栈。
     *
     * @param root
     */
    public void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //游标
        TreeNode node = root;
        while (!stack.isEmpty() || null != node) {
            //存入历史走过的节点，一直找左边的
            while (node.left != null) {
                stack.push(node);
                node = node.left;
            }
            //当前左节点为null，需要弹出栈顶的左节点
            node = stack.pop();
            //do some thing node, 使用栈顶元素做些东西
            //处理右侧节点的节点
            node = node.right;
        }
    }

    /**
     * 后续遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {

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
