public class BSTBalance {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public static int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        int right = checkHeight(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }

    public static int getBalanceFactor(TreeNode node) {
        return height(node.left) - height(node.right);
    }

    public static int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    static TreeNode mostUnbalancedNode = null;
    static int maxDiff = -1;

    public static TreeNode findMostUnbalanced(TreeNode root) {
        mostUnbalancedNode = null;
        maxDiff = -1;
        findUnbalanced(root);
        return mostUnbalancedNode;
    }

    public static void findUnbalanced(TreeNode node) {
        if (node == null) return;

        int leftH = height(node.left);
        int rightH = height(node.right);
        int diff = Math.abs(leftH - rightH);

        if (diff > maxDiff) {
            maxDiff = diff;
            mostUnbalancedNode = node;
        }

        findUnbalanced(node.left);
        findUnbalanced(node.right);
    }

    public static void main(String[] args) {
        /*
               10
              /
             5
            /
           2
          /
         1
        */
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);

        System.out.println("是否為平衡樹: " + isBalanced(root));
        System.out.println("根節點平衡因子: " + getBalanceFactor(root));

        TreeNode worst = findMostUnbalanced(root);
        System.out.println("最不平衡的節點值: " + (worst != null ? worst.data : "null"));
        System.out.println("其平衡因子: " + getBalanceFactor(worst));
    }
}
