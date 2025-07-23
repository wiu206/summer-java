public class SimpleBST {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    // 搜尋值
    public static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        if (target < root.data) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    // 插入新節點（自動維持 BST 性質）
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
        // 建立初始 BST
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        // 插入額外 8 個值
        insert(root, 10);
        insert(root, 25);
        insert(root, 35);
        insert(root, 45);
        insert(root, 60);
        insert(root, 80);
        insert(root, 55);
        insert(root, 75);

        // 測試搜尋
        System.out.println("搜尋 30: " + search(root, 30));
        System.out.println("搜尋 40: " + search(root, 40));
        System.out.println("搜尋 60: " + search(root, 60));
        System.out.println("搜尋 25: " + search(root, 25));
        System.out.println("搜尋 75: " + search(root, 75));
        System.out.println("搜尋 90: " + search(root, 90)); // 不存在
    }
}
