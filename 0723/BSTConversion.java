public class BSTConversion {
    static class TreeNode {
        int data;
        TreeNode left, right;
        public TreeNode(int data) {
            this.data = data;
        }
    }

    static TreeNode prev = null;
    public static TreeNode bstToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode dummy = new TreeNode(0);
        prev = dummy;
        convertToList(root);
        TreeNode head = dummy.right;
        if (head != null) head.left = null;
        return head;
    }

    public static void convertToList(TreeNode node) {
        if (node == null) return;
        convertToList(node.left);
        prev.right = node;
        node.left = prev;
        prev = node;
        convertToList(node.right);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public static TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, left, mid - 1);
        node.right = buildBST(nums, mid + 1, right);
        return node;
    }

    static int total = 0;
    public static void convertToGreaterTree(TreeNode node) {
        if (node == null) return;
        convertToGreaterTree(node.right);
        total += node.data;
        node.data = total;
        convertToGreaterTree(node.left);
    }

    public static void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    public static void printDoublyList(TreeNode head) {
        TreeNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        TreeNode dllHead = bstToDoublyList(root1);
        System.out.print("雙向鏈表: ");
        printDoublyList(dllHead);

        int[] sorted = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root2 = sortedArrayToBST(sorted);
        System.out.print("平衡 BST 中序: ");
        printInOrder(root2);
        System.out.println();

        // 測試功能3：節點值改為大於等於自身的總和
        convertToGreaterTree(root2);
        System.out.print("轉換後 BST 中序: ");
        printInOrder(root2);
        System.out.println();
    }
}
