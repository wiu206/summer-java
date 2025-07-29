import java.util.*;

public class F12_TreeDiameter {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxDiameter = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);

        computeHeight(root);
        System.out.println("Diameter: " + maxDiameter);
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

    static int computeHeight(TreeNode node) {
        if (node == null) return 0;

        int leftH = computeHeight(node.left);
        int rightH = computeHeight(node.right);

        maxDiameter = Math.max(maxDiameter, leftH + rightH);

        return Math.max(leftH, rightH) + 1;
    }
}
