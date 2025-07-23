public class BSTKthElement {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    static class Counter {
        int count = 0;
        int result = -1;
    }

    public static int kthSmallest(TreeNode root, int k) {
        Counter c = new Counter();
        inorderKth(root, k, c);
        return c.result;
    }

    public static void inorderKth(TreeNode node, int k, Counter c) {
        if (node == null) return;

        inorderKth(node.left, k, c);

        c.count++;
        if (c.count == k) {
            c.result = node.data;
            return;
        }

        inorderKth(node.right, k, c);
    }

    public static TreeNode insert(TreeNode root, int value) {
        if (root == null) return new TreeNode(value);
        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] values = {20, 10, 30, 5, 15, 25, 35};
        TreeNode root = null;
        for (int val : values) {
            root = insert(root, val);
        }

        for (int k = 1; k <= 7; k++) {
            System.out.println("第 " + k + " 小的元素是: " + kthSmallest(root, k));
        }
    }
}
