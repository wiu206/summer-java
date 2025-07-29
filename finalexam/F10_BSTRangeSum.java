import java.util.*;

public class F10_BSTRangeSum {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(" ");
        TreeNode root = buildTree(input);

        int L = sc.nextInt();
        int R = sc.nextInt();

        int sum = rangeSumBST(root, L, R);
        System.out.println("Sum: " + sum);
    }

    static TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("-1")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < nodes.length) {
            TreeNode curr = queue.poll();

            if (i < nodes.length && !nodes[i].equals("-1")) {
                curr.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.left);
            }
            i++;

            if (i < nodes.length && !nodes[i].equals("-1")) {
                curr.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.offer(curr.right);
            }
            i++;
        }
        return root;
    }

    static int rangeSumBST(TreeNode node, int L, int R) {
        if (node == null) return 0;

        if (node.val < L) {
            return rangeSumBST(node.right, L, R); 
        } else if (node.val > R) {
            return rangeSumBST(node.left, L, R);  
        } else {

            return node.val +
                   rangeSumBST(node.left, L, R) +
                   rangeSumBST(node.right, L, R);
        }
    }

}
