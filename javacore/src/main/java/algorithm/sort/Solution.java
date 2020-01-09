package algorithm.sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author qidi
 * @date 2019-12-19 14:33
 */
public class Solution {


    /**
     * 将树按照层次放入队列，每一层的左右节点
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {

            //每层创建集合
            levels.add(new ArrayList<Integer>());

            // 计算当前层级
            int levelHight = queue.size();

            for (int i = 0; i < levelHight; ++i) {
                TreeNode node = queue.remove();

                // 拿到所有当前的父节点
                levels.get(level).add(node.val);

                //放入左节点
                if (node.left != null) {
                    queue.add(node.left);
                }

                //放入有节点
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            level++;
        }
        return levels;
    }
}

