import java.util.*;

public class TreeDistance {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static int distance(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root, a, b);
        int d1 = depthFromNode(lca, a, 0);
        int d2 = depthFromNode(lca, b, 0);
        return d1 + d2;
    }

    public static TreeNode findLCA(TreeNode node, int a, int b) {
        if (node == null) return null;
        if (node.data == a || node.data == b) return node;

        TreeNode left = findLCA(node.left, a, b);
        TreeNode right = findLCA(node.right, a, b);

        if (left != null && right != null) return node;
        return left != null ? left : right;
    }

    public static int depthFromNode(TreeNode node, int target, int depth) {
        if (node == null) return -1;
        if (node.data == target) return depth;

        int left = depthFromNode(node.left, target, depth + 1);
        if (left != -1) return left;

        return depthFromNode(node.right, target, depth + 1);
    }

    static int maxDiameter = 0;

    public static int treeDiameter(TreeNode root) {
        maxDiameter = 0;
        heightForDiameter(root);
        return maxDiameter;
    }

    public static int heightForDiameter(TreeNode node) {
        if (node == null) return 0;

        int left = heightForDiameter(node.left);
        int right = heightForDiameter(node.right);

        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    public static List<Integer> nodesAtDistance(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        collectNodesAtDistance(root, k, result);
        return result;
    }

    public static void collectNodesAtDistance(TreeNode node, int k, List<Integer> result) {
        if (node == null) return;
        if (k == 0) {
            result.add(node.data);
        } else {
            collectNodesAtDistance(node.left, k - 1, result);
            collectNodesAtDistance(node.right, k - 1, result);
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \     \
            4   5     6
                       \
                        7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println("節點 4 到 5 的距離: " + distance(root, 4, 5)); // 2
        System.out.println("節點 4 到 7 的距離: " + distance(root, 4, 7)); // 5

        System.out.println("樹的直徑: " + treeDiameter(root)); // 5

        System.out.println("距離根節點距離為 2 的節點: " + nodesAtDistance(root, 2)); // [4, 5, 6]
    }
}
