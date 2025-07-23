import java.util.*;

public class TreeLevelTraversal {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (leftToRight) {
                    level.addLast(curr.data);
                } else {
                    level.addFirst(curr.data);
                }

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }

            result.add(level);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static void printLastNodesPerLevel(List<List<Integer>> levels) {
        for (List<Integer> level : levels) {
            System.out.println(level.get(level.size() - 1));
        }
    }

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> levels = levelOrder(root);

        System.out.println("每層的節點（分層儲存）:");
        for (List<Integer> level : levels) {
            System.out.println(level);
        }

        System.out.println("每層最後一個節點:");
        printLastNodesPerLevel(levels);
    }
}
