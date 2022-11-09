package com.wen.FifthFifty;

import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicateIII {
//    // Brute force, note convert int to long to avoid overflow
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//        int l=nums.length;
//        for(int i=0; i<l; i++){
//            for(int j=i+1; j<l && j<=i+indexDiff; j++){
//                if(Math.abs((long)nums[i]-(long)nums[j])<=valueDiff){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

//    // Use a TreeSet to maintain a window which contains previous indexDiff-1 numbers, and check each number against the
//    // window with its closest lower and upper bound
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//        int l=nums.length;
//        TreeSet<Integer> window=new TreeSet<>();
//        for(int i=0; i<l; i++){
//            int num=nums[i];
//            Integer low=window.floor(num), high=window.ceiling(num);
//            if((low!=null && Math.abs((long)num-(long)low)<=valueDiff) || (high!=null && Math.abs((long)num-(long)high)<=valueDiff)){
//                return true;
//            }
//            window.add(num);
//            if(i>=indexDiff){
//                window.remove(nums[i-indexDiff]);
//            }
//        }
//        return false;
//    }

    // Use a BST
    private class TreeNode{
        public TreeNode left, right;
        public int val;

        public TreeNode(int val){
            this.val=val;
        }
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeNode root=new TreeNode(nums[0]);
        int treeSize=1;
        for(int i=1; i<nums.length; i++){
            int num=nums[i];
            TreeNode[] searchResult=new TreeNode[2];
            findLowerAndUpperBoundInBST(root, num, searchResult);
            if(searchResult[0]!=null && (long)num-(long)searchResult[0].val<=valueDiff){
                return true;
            } else if(searchResult[1]!=null && (long)searchResult[1].val-(long)num<=valueDiff){
                return true;
            } else{
                addToBST(root, new TreeNode(num));
                if(++treeSize==indexDiff+1){
                    root=removeFromBST(root, nums[i-indexDiff]);
                    treeSize--;
                }
            }
        }
        return false;
    }

    private TreeNode removeFromBST(TreeNode cur, int num){
        if(cur.val==num){
            if(cur.left==null){
                return cur.right;
            } else if(cur.right==null){
                return cur.left;
            } else{
                TreeNode tmp=cur.left;
                while(tmp.right!=null){
                    tmp=tmp.right;
                }
                tmp.right=cur.right;
                return cur.left;
            }
        } else if(cur.val<num){
            cur.right=removeFromBST(cur.right, num);
            return cur;
        } else{
            cur.left=removeFromBST(cur.left, num);
            return cur;
        }
    }

    private void addToBST(TreeNode cur, TreeNode node){
        if(node.val<cur.val){
            if(cur.left==null){
                cur.left=node;
            } else{
                addToBST(cur.left, node);
            }
        } else{
            if(cur.right==null){
                cur.right=node;
            } else{
                addToBST(cur.right, node);
            }
        }
    }

    private void findLowerAndUpperBoundInBST(TreeNode cur, int num, TreeNode[] cache){
        if(cur!=null){
            if(num<cur.val){
                if(cache[1]==null || cache[1].val>cur.val){
                    cache[1]=cur;
                }
                findLowerAndUpperBoundInBST(cur.left, num, cache);
            } else{
                if(cache[0]==null || cache[0].val<cur.val){
                    cache[0]=cur;
                }
                findLowerAndUpperBoundInBST(cur.right, num, cache);
            }
        }
    }
}
