package algorithm.sort;

/**
 * 构造最大数
 *
 * @author qidi
 * @date 2019-08-29 14:31
 */
public class MaximumTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        public TreeNode constructMaximumBinaryTree(int[] nums) {
            if (null == nums || nums.length == 0) {
                return null;
            }
            return construct(nums, 0, nums.length);

        }

        public TreeNode construct(int nums[], int left, int right) {
            if (left == right) {
                return null;
            }
            int maxIndex = findMaxIndex(nums, left, right);
            TreeNode root = new TreeNode(nums[maxIndex]);
            //左边放入左边 次最二大的
            root.left = construct(nums, left, maxIndex);
            //右边放入右边 次最二大的
            root.right = construct(nums, maxIndex + 1, right);
            return root;
        }

        /**
         * 查找指定区间最大的数坐标
         *
         * @param nums
         * @param left
         * @param right
         * @return
         */
        public int findMaxIndex(int[] nums, int left, int right) {
            int maxIndex = left;
            for (int i = left; i < right; i++) {
                if (nums[maxIndex] < nums[i]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
    }
}
