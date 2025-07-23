import java.util.*;

public class BSTValidation {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.data <= min || node.data >= max) return false;
        return validate(node.left, min, node.data) && validate(node.right, node.data, max);
    }

    public static List<TreeNode> findViolations(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        inorderFind(root, new TreeNode[]{null}, result);
        return result;
    }

    public static void inorderFind(TreeNode node, TreeNode[] prev, List<TreeNode> violations) {
        if (node == null) return;

        inorderFind(node.left, prev, violations);

        if (prev[0] != null && node.data <= prev[0].data) {
            violations.add(node);
        }
        prev[0] = node;

        inorderFind(node.right, prev, violations);
    }
    public static int minRemovalsToBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return inorder.size() - lengthOfLIS(inorder);
    }

    public static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.data);
        inorderTraversal(node.right, list);
    }

    public static int lengthOfLIS(List<Integer> nums) {
        List<Integer> dp = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(dp, num);
            if (i < 0) i = -(i + 1);
            if (i == dp.size()) dp.add(num);
            else dp.set(i, num);
        }
        return dp.size();
    }

    public static void main(String[] args) {
        /*
                 10
                /  \
               5   20
              / \
            12   3   // 12 與 3 違反 BST 規則
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(12); // invalid
        root.left.right = new TreeNode(3); // invalid

        System.out.println("是否為合法 BST: " + isValidBST(root));

        List<TreeNode> violations = findViolations(root);
        System.out.print("違規節點值: ");
        for (TreeNode node : violations) {
            System.out.print(node.data + " ");
        }
        System.out.println();

        int removals = minRemovalsToBST(root);
        System.out.println("最少需移除節點數: " + removals);
    }
}
