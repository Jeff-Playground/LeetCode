package com.wen.EleventhFifty;

public class LQConstructBinaryTreeFromString {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode str2tree(String s) {
        if(s==null || s.isEmpty()){
            return null;
        } else{
            if(s.startsWith("(")){
                s=s.substring(1, s.length()-1);
            }
            TreeNode node=null;
            int firstLeft=s.indexOf('(');
            if(firstLeft!=-1){
                int val=Integer.parseInt(s.substring(0, firstLeft));
                int leftCount=1, rightCount=0, i=firstLeft+1;
                for(i=firstLeft+1; i<s.length(); i++){
                    if(s.charAt(i)=='('){
                        leftCount++;
                    } else if(s.charAt(i)==')'){
                        rightCount++;
                    }
                    if(leftCount==rightCount){
                        break;
                    }
                }
                int firstRight=i+1;
                node=new TreeNode(val);
                node.left=str2tree(s.substring(firstLeft, firstRight));
                node.right=str2tree(s.substring(firstRight));
            } else{
                node=new TreeNode(Integer.parseInt(s));
            }
            return node;
        }
    }
}
