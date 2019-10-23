package com.wen.SeventhFifty;

public class AdditiveNumber {
//    // Iterative
//    public boolean isAdditiveNumber(String num) {
//        if(num==null || num.isEmpty()){
//            return true;
//        } else if(num.length()<3){
//            return false;
//        } else{
//            int l=num.length();
//            for(int i=1; i<(l+1)/2; i++) {
//                String first=num.substring(0, i);
//                if(i>1 && first.startsWith("0")){
//                    break;
//                }
//                for(int j=1; j<=l-i-Math.max(i, j); j++) {
//                    String second=num.substring(i, i+j);
//                    if(j>1 && second.startsWith("0")) {
//                        break;
//                    }
//                    String sum=getSum(first, second);
//                    if(num.substring(i+j).equals(sum)){
//                        return true;
//                    } else if(num.substring(i+j).startsWith(sum)) {
//                        StringBuilder cur=new StringBuilder(first);
//                        cur.append(second);
//                        cur.append(sum);
//                        String a=second, b=sum, c=sum;
//                        while(cur.length()<l && num.startsWith(cur.toString())) {
//                            c=getSum(a, b);
//                            cur.append(c);
//                            a=b;
//                            b=c;
//                        }
//                        if(cur.toString().equals(num)) {
//                            return true;
//                        }
//                    }
//                }
//            }
//            return false;
//        }
//    }

    // Recursive, optimized with break statements
    public boolean isAdditiveNumber(String num) {
        if(num==null || num.isEmpty()){
            return true;
        } else if(num.length()<3){
            return false;
        } else{
            int l=num.length();
            for(int i=1; i<(l+1)/2; i++) {
                String a=num.substring(0, i);
                if(i>1 && a.startsWith("0")){
                    break;
                }
                for(int j=1; j<=l-i-Math.max(i, j); j++) {
                    String b=num.substring(i, i+j);
                    if(j>1 && b.startsWith("0")) {
                        break;
                    }
                    String sum=getSum(a, b);
                    if(num.substring(i+j).equals(sum)){
                        return true;
                    } else if(num.substring(i+j).startsWith(sum)) {
                        if(isAdditiveNumber(num.substring(i))) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

//    // Recursive
//    public boolean isAdditiveNumber(String num) {
//        if(num==null || num.isEmpty()){
//            return true;
//        } else if(num.length()<3){
//            return false;
//        } else{
//            int l=num.length();
//            if(num.charAt(0)=='0') {
//                if(num.charAt(1)=='0') {
//                    for(char c: num.toCharArray()) {
//                        if(c!='0') {
//                            return false;
//                        }
//                    }
//                    return true;
//                } else {
//                    for(int j=1; j<=(l-1)/2; j++) {
//                        String sum=num.substring(1, 1+j);
//                        if(num.substring(1+j).equals(sum)){
//                            return true;
//                        } else if(num.substring(1+j).startsWith(sum)) {
//                            if(isAdditiveNumber(num.substring(1))) {
//                                return true;
//                            }
//                        }
//                    }
//                    return false;
//                }
//            } else {
//                for(int i=1; i<(l+1)/2; i++) {
//                    String a=num.substring(0, i);
//                    if(num.charAt(i)=='0') {
//                        String sum=a;
//                        if(num.substring(i+1).equals(sum)){
//                            return true;
//                        } else if(num.substring(i+1).startsWith(sum)) {
//                            if(isAdditiveNumber(num.substring(i))) {
//                                return true;
//                            }
//                        }
//                    } else {
//                        for(int j=1; j<=l-i-Math.max(i, j); j++) {
//                            String b=num.substring(i, i+j);
//                            String sum=getSum(a, b);
//                            if(num.substring(i+j).equals(sum)){
//                                return true;
//                            } else if(num.substring(i+j).startsWith(sum)) {
//                                if(isAdditiveNumber(num.substring(i))) {
//                                    return true;
//                                }
//                            }
//                        }
//                    }
//                }
//                return false;
//            }
//        }
//    }

    private String getSum(String a, String b) {
        StringBuilder as=new StringBuilder(a), bs=new StringBuilder(b), result=new StringBuilder();
        as.reverse();
        bs.reverse();
        int l1=as.length(), l2=bs.length();
        int carry=0;
        for(int i=0; i<Math.max(l1, l2); i++) {
            int m=i<l1?as.charAt(i)-'0':0, n=i<l2?bs.charAt(i)-'0':0;
            int sum=m+n+carry;
            carry=sum>9?1:0;
            result.append((char)((sum%10)+'0'));
        }
        if(carry>0) {
            result.append('1');
        }
        return result.reverse().toString();
    }
}
