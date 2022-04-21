package com.wen.EleventhFifty;

import java.util.Stack;

public class LQConstructBinaryTreeFromString {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Preorder traversal
//    public TreeNode str2tree(String s) {
//        if(s==null || s.isEmpty()){
//            return null;
//        } else{
//            Stack<TreeNode> stack=new Stack<>();
//            for(int i=0; i<s.length(); i++){
//                if(s.charAt(i)=='('){
//                    continue;
//                } else if(s.charAt(i)==')'){
//                    stack.pop();
//                } else{
//                    int start=i, end=i;
//                    while(end<s.length() && s.charAt(end)!='(' && s.charAt(end)!=')'){
//                        end++;
//                    }
//                    TreeNode cur=new TreeNode(Integer.valueOf(s.substring(start, end--)));
//                    if(stack.isEmpty()){
//                        stack.push(cur);
//                    } else{
//                        TreeNode parent=stack.peek();
//                        if(parent.left==null){
//                            parent.left=cur;
//                        } else{
//                            parent.right=cur;
//                        }
//                        stack.push(cur);
//                    }
//                    i=end;
//                }
//            }
//            return stack.peek();
//        }
//    }

    // Preorder traversal
    public TreeNode str2tree(String s) {
        if(s==null || s.isEmpty()){
            return null;
        } else{
            if(s.startsWith("(")){
                s=s.substring(1, s.length()-1);
            }
            TreeNode cur=null;
            if(s.indexOf('(')!=-1){
                int start=s.indexOf('('), end=start+1, count=1;
                cur=new TreeNode(Integer.valueOf(s.substring(0, start)));
                for(end=start+1; end<s.length(); end++){
                    if(s.charAt(end)=='('){
                        count++;
                    } else if(s.charAt(end)==')'){
                        count--;
                        if(count==0){
                            break;
                        }
                    }
                }
                TreeNode left=str2tree(s.substring(start, end+1)), right=str2tree(s.substring(end+1));
                cur.left=left;
                cur.right=right;
            } else{
                cur=new TreeNode(Integer.valueOf(s));
            }
            return cur;
        }
    }
}
