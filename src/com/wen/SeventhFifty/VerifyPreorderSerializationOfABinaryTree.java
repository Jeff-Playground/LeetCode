package com.wen.SeventhFifty;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {
    public boolean isValidSerialization(String preorder) {
        int diff = 0, idx = 0;
        String[] po = preorder.split(",");
        while(idx < po.length){
            diff = po[idx++].equals("#") ? diff + 1 : diff - 1;
            if (diff >= 2) return false;
            if (diff == 1) break;
        }
        return diff == 1 && idx == po.length;
    }

//    // Preorder traversal
//    public boolean isValidSerialization(String preorder) {
//        String[] po=preorder.split(",");
//        int[] idx=new int[]{0};
//        return ivsHelper(po, idx) && idx[0]==po.length;
//    }
//
//    private boolean ivsHelper(String[] po, int[] idx){
//        if(idx[0]==po.length){
//            return false;
//        }
//        String cur=po[idx[0]++];
//        if(cur.equals("#")){
//            return true;
//        }
//        if(!ivsHelper(po, idx)){
//            return false;
//        }
//        if(!ivsHelper(po, idx)){
//            return false;
//        }
//        return true;
//    }

//    public boolean isValidSerialization(String preorder) {
//        String[] po=preorder.split(",");
//        int l=po.length;
//        Stack<String> stack=new Stack<>();
//        for(int i=0; i<l; i++){
//            String cur=po[i].trim();
//            if(i==0){
//                if(cur.equals("#")){
//                    stack.push("root#");
//                } else{
//                    stack.push("root");
//                }
//            } else{
//                if(stack.isEmpty()){
//                    return false;
//                }
//                String last=stack.peek();
//                if(last.equals("root") || last.equals("left") || last.equals("right")){
//                    if(cur.equals("#")){
//                        stack.push("left#");
//                    } else{
//                        stack.push("left");
//                    }
//                } else if(last.equals("root#")){
//                    return false;
//                } else if(last.equals("left#")){
//                    if(cur.equals("#")){
//                        stack.pop();
//                        stack.push(stack.pop()+"#");
//                        while(stack.peek().equals("right#")){
//                            stack.pop();
//                            stack.pop();
//                            stack.push(stack.pop()+"#");
//                        }
//                    } else{
//                        stack.push("right");
//                    }
//                }
//            }
//        }
//        return stack.peek().equals("root#") && stack.size()==1;
//    }
}
