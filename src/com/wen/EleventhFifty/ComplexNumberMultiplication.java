package com.wen.EleventhFifty;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String av=a.split("\\+")[0].trim();
        String ai=a.split("\\+")[1].trim();
        String bv=b.split("\\+")[0].trim();
        String bi=b.split("\\+")[1].trim();
        int avNum=Integer.parseInt(av), aiNum=Integer.parseInt(ai.substring(0,ai.length()-1));
        int bvNum=Integer.parseInt(bv), biNum=Integer.parseInt(bi.substring(0,bi.length()-1));
        StringBuilder result=new StringBuilder();
        result.append(avNum*bvNum-aiNum*biNum);
        result.append("+").append(avNum*biNum+bvNum*aiNum).append("i");
        return result.toString();
    }
}
