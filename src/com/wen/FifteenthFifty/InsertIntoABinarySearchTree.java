package com.wen.FifteenthFifty;

public class InsertIntoABinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Iterative with similar idea to recursive2
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        } else{
            TreeNode cur=root;
            while(true){
                if(cur.val>val){
                    if(cur.left!=null){
                        cur=cur.left;
                    } else{
                        cur.left=new TreeNode(val);
                        break;
                    }
                } else{
                    if(cur.right!=null){
                        cur=cur.right;
                    } else{
                        cur.right=new TreeNode(val);
                        break;
                    }
                }
            }
            return root;
        }
    }

//    // Recursive2
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root==null){
//            return new TreeNode(val);
//        } else if(root.val>val){
//            root.left=insertIntoBST(root.left, val);
//            return root;
//        } else{
//            root.right=insertIntoBST(root.right, val);
//            return root;
//        }
//    }

//    // Recursive1
//    public TreeNode insertIntoBST(TreeNode root, int val) {
//        if(root==null){
//            return new TreeNode(val);
//        } else{
//            if(root.val>val){
//                root.left=insertIntoBST(root.left, val);
//                return root;
//            } else{
//                if(root.right==null){
//                    root.right=new TreeNode(val);
//                    return root;
//                } else{
//                    TreeNode newRoot=root.right, tmp=root.right;
//                    while(tmp.left!=null){
//                        tmp=tmp.left;
//                    }
//                    tmp.left=root;
//                    root.right=null;
//                    return insertIntoBST(newRoot, val);
//                }
//            }
//        }
//    }
}
