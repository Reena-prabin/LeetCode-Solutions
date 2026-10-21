/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this. val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode headNode;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode curr = head;
        // Step 1: Count the number of nodes in the linked list
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        this.headNode = head;
        return buildBST(0, n - 1);
    }

    private TreeNode buildBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        // Step 2: Recursively build the left subtree
        TreeNode leftChild = buildBST(left, mid - 1);

        // Step 3: Allocate the current node using the current head of the linked list
        TreeNode root = new TreeNode(headNode.val);
        root.left = leftChild;

        // Move the linked list pointer forward
        headNode = headNode.next;

        // Step 4: Recursively build the right subtree
        root.right = buildBST(mid + 1, right);

        return root;
    }
}