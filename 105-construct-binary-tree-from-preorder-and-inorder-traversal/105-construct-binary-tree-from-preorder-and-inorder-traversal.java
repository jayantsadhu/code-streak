/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int k;
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        k = 0;
        map = new HashMap<>();
        for(int i=0 ; i<inorder.length ; i++)
            map.put(inorder[i], i);
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    public TreeNode helper(int[] pre, int[] in, int l, int r){
        if(l>r) return null;
        TreeNode head = new TreeNode(pre[k]);
        int pos = map.get(pre[k++]);
        head.left = helper(pre, in, l, pos-1);
        head.right = helper(pre, in, pos+1, r);
        return head;
    }
}