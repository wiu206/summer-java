import java.util.*;

public class TreePathProblems {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfsPaths(root, new ArrayList<>(), result);
        return result;
    }

    public static void dfsPaths(TreeNode node, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.data);

        if (node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
        } else {
            dfsPaths(node.left, path, result);
            dfsPaths(node.right, path, result);
        }

        path.remove(path.size() - 1);
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return target == root.data;
        }

        return hasPathSum(root.left, target - root.data) ||
               hasPathSum(root.right, target - root.data);
    }

    public static List<Integer> maxSumPath(TreeNode root) {
        List<Integer> maxPath = new ArrayList<>();
        findMaxPath(root, new ArrayList<>(), 0, new int[]{Integer.MIN_VALUE}, maxPath);
        return maxPath;
    }

    public static void findMaxPath(TreeNode node, List<Integer> current, int sum, int[] maxSum, List<Integer> result) {
        if (node == null) return;

        current.add(node.data);
        sum += node.data;

        if (node.left == null && node.right == null) {
            if (sum > maxSum[0]) {
                maxSum[0] = sum;
                result.clear();
                result.addAll(current);
            }
        } else {
            findMaxPath(node.left, current, sum, maxSum, result);
            findMaxPath(node.right, current, sum, maxSum, result);
        }

        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \       \
          7    2       1
        */
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> paths = allPaths(root);
        System.out.println("所有根到葉節點的路徑:");
        for (List<Integer> p : paths) {
            System.out.println(p);
        }

        int target = 22;
        System.out.println("是否存在總和為 " + target + " 的路徑: " + hasPathSum(root, target));

        List<Integer> maxPath = maxSumPath(root);
        System.out.println("最大總和路徑: " + maxPath);
    }
}
