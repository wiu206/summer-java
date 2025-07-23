import java.util.*;

public class TreeReconstruction {
    static class TreeNode {
        int data;
        TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static TreeNode buildFromPreIn(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPreIn(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public static TreeNode buildPreIn(int[] pre, int preL, int preR, int[] in, int inL, int inR, Map<Integer, Integer> inMap) {
        if (preL > preR || inL > inR) return null;
        int rootVal = pre[preL];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        int leftSize = inIndex - inL;

        root.left = buildPreIn(pre, preL + 1, preL + leftSize, in, inL, inIndex - 1, inMap);
        root.right = buildPreIn(pre, preL + leftSize + 1, preR, in, inIndex + 1, inR, inMap);
        return root;
    }

    public static TreeNode buildFromPostIn(int[] postorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) inMap.put(inorder[i], i);
        return buildPostIn(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    public static TreeNode buildPostIn(int[] post, int postL, int postR, int[] in, int inL, int inR, Map<Integer, Integer> inMap) {
        if (postL > postR || inL > inR) return null;
        int rootVal = post[postR];
        TreeNode root = new TreeNode(rootVal);
        int inIndex = inMap.get(rootVal);
        int leftSize = inIndex - inL;

        root.left = buildPostIn(post, postL, postL + leftSize - 1, in, inL, inIndex - 1, inMap);
        root.right = buildPostIn(post, postL + leftSize, postR - 1, in, inIndex + 1, inR, inMap);
        return root;
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.data);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder  = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode rootFromPreIn = buildFromPreIn(preorder, inorder);
        TreeNode rootFromPostIn = buildFromPostIn(postorder, inorder);

        System.out.println("驗證前序+中序重建結果: " + preorderTraversal(rootFromPreIn));
        System.out.println("驗證後序+中序重建結果: " + preorderTraversal(rootFromPostIn));
    }
}
