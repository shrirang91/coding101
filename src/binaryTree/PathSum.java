/**
 * 
 */
package binaryTree;

/**
 * @author shrirang
 *
 */

public class PathSum {

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
	     int val;
	     TreeNode left = null;
	     TreeNode right = null;
	     TreeNode(int x) { val = x;}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode tree = new TreeNode(10);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(2);
        int sum = 21;
        if (pathSumCheck(tree, sum))
            System.out.println("There is a root to leaf path with sum " + sum);
        else
            System.out.println("There is no root to leaf path with sum " + sum);
	}
	
	public static boolean pathSumCheck(TreeNode root, int sum) {
		boolean result = false;
		if (root == null) {
			return sum == 0;
		} else {
			int tempSum = sum - root.val;
			if (tempSum == 0 && root.left == null && root.right == null) {
				return true;
			}
			if (root.left != null) {
				result = result || pathSumCheck(root.left, tempSum);
			}
			if (root.right != null) {
				result = result || pathSumCheck(root.right, tempSum);
			}
			return result;
		}
	}

}
