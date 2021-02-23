public class Solution {

	/*
	 * Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> { T data; BinaryTreeNode<T> left; BinaryTreeNode<T> right;
	 * 
	 * public BinaryTreeNode(T data) { this.data = data; } }
	 */


	
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b)
    {
		if(root==null)
        {
            return -1;
        }
        if(root.data==a||root.data==b)
        {
            return root.data;
        }
        int ans1=-1,ans2=-1;
       
           ans1=getLCA(root.left,a,b);
           ans2=getLCA(root.right,a,b);
        
        if(ans1==-1&&ans2==-1)
        {
            return -1;
        }
        else if(ans1!=-1&&ans2==-1)
        {
            return ans1;
        }
        else if(ans1==-1&&ans2!=-1)
        {
            return ans2;
        }
        else
        {
            return root.data;
        }
	}
}
