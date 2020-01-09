package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qidi
 * @date 2020-01-08 21:08
 */
public class ValidBSTInOrder {


    public boolean isValidBST(TreeNode root) {
        //中序遍历，先访问左子树，然后根，然后右子树，中序遍历出来的数组是从小到大有序的
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        if (list.isEmpty()) {
            return true;
        }
        //左边比右边大
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) >= list.get(i)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> inOrder(TreeNode node, List<Integer> list) {
        if (null != node) {
            if (node.left != null) {
                inOrder(node.left, list);
            }
            //加入数值
            list.add(node.val);
            if (node.right != null) {
                inOrder(node.right, list);
            }
        }
        return list;
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



