package com.wen.NinthFifty;

public class DeleteNodeInABST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) {
            return null;
        } else{
            if(root.val==key){
                if(root.right==null){
                    return root.left;
                } else{
                    TreeNode cur=root.right;
                    while(cur.left!=null){
                        cur=cur.left;
                    }
                    root.val=cur.val;
                    cur.val=key;
                }
            }
            root.left=deleteNode(root.left, key);
            root.right=deleteNode(root.right, key);
            return root;
        }
    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root==null){
//            return root;
//        } else{
//            TreeNode cur=root, pre=null;
//            while(cur!=null){
//                if(cur.val==key){
//                    break;
//                } else{
//                    pre=cur;
//                    if(cur.val>key){
//                        cur=cur.left;
//                    } else{
//                        cur=cur.right;
//                    }
//                }
//            }
//            if(pre==null){
//                return delete(cur);
//            } else{
//                if(pre.left!=null && pre.left.val==key){
//                    pre.left=delete(cur);
//                } else{
//                    pre.right=delete(cur);
//                }
//                return root;
//            }
//        }
//    }
//
//    private TreeNode delete(TreeNode cur) {
//        if(cur==null){
//            return null;
//        }
//        if(cur.right==null){
//            return cur.left;
//        } else{
//            TreeNode temp=cur.right;
//            while(temp.left!=null){
//                temp=temp.left;
//            }
//            temp.left=cur.left;
//            return cur.right;
//        }
//    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        if(root==null){
//            return root;
//        } else if(root.val>key){
//            root.left=deleteNode(root.left, key);
//        } else if(root.val<key){
//            root.right=deleteNode(root.right, key);
//        } else{
//            if(root.left==null || root.right==null){
//                root=root.left!=null?root.left:root.right;
//            } else{
//                TreeNode cur=root.right;
//                while(cur.left!=null){
//                    cur=cur.left;
//                }
//                cur.left=root.left;
//                return root.right;
//            }
//        }
//        return root;
//    }
}
