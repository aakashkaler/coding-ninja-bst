import java.util.*;
/*
 * Binary Tree Node class
 * 
 * class BinaryTreeNode<T> { 
 * 		T data; 
 * 		BinaryTreeNode<T> left; 
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data) 
 * 		{ 
 * 			this.data = data; 
 * 		}
 * }
 */

 /* 
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree {
    private BinaryTreeNode<Integer> root;
	public void insert(int data) 
    {
		root=insert1(data,root);
	}
    private BinaryTreeNode<Integer> insert1(int data,BinaryTreeNode<Integer> root)
    {
		if(root==null)
        {
           BinaryTreeNode<Integer> nod=new BinaryTreeNode<Integer>(data);
            return nod;
        }
        if(data<=root.data)
        {
            root.left=insert1(data,root.left);
        }
        else
        {
            root.right=insert1(data,root.right);
        }
        return root;
	}
    private BinaryTreeNode<Integer> remove(int data,BinaryTreeNode<Integer> root) 
    {
        if(root==null)
        {
            return null;
        }
        if(data<root.data)
        {
            root.left=remove(data,root.left);
        }
        else if(data>root.data)
        {
            root.right=remove(data,root.right);
        }
        else
        {
            if(root.left==null&&root.right==null)
            {
                return null;
            }
            else if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }
            else
            {
               BinaryTreeNode<Integer> min=root.right;
                while(min.left!=null)
                {
                    min=min.left;
                }
                root.data=min.data;
                root.right=remove(min.data,root.right);
                return root;
            }
            
        }
        return null;
	}
	
	public void remove(int data) {
        
		root=remove(data,root);
	}
	
    private void printTree(BinaryTreeNode<Integer> root) 
    {
		if(root==null)
        {
            return ;
        }
        String s=root.data+":";
        if(root.left!=null)
        {
            s+="L:"+root.left.data+",";
        }
        if(root.right!=null)
        {
            s+="R:"+root.right.data;
        }
        System.out.println(s);
        printTree(root.left);
        printTree(root.right);
        
	}
	public void printTree() 
    {
		printTree(root);
	}
    private boolean search(int data,BinaryTreeNode<Integer> root)
    {
        if(root==null)
        {
            return false;
        }
        if(root.data==data)
        {
            return true;
        }
        return search(data,root.left)||search(data,root.right);
	}
	
	public boolean search(int data) 
    {
		return search(data,root);
	}
	

}
