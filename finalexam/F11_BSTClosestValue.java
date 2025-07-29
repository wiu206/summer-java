import java.util.*;

public class F11_BSTClosestValue {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);

        int T = sc.nextInt();

        int result = closestValue(root, T);
        System.out.println("Closest: " + result);
    }

    static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode cur = q.poll();

            if (i < nodes.length && !nodes[i].equals("-1")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("-1")) {
                cur.right = new TreeNode(Integer.parseInt(nodes[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    static int closestValue(TreeNode root, int target) {
        int closest = root.val;

        while (root != null) {
            int diff = Math.abs(root.val - target);
            int closestDiff = Math.abs(closest - target);

            if (diff < closestDiff || (diff == closestDiff && root.val < closest)) {
                closest = root.val;
            }

            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                break; 
            }
        }
        return closest;
    }

}
