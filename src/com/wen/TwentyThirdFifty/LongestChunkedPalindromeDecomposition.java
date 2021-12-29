package com.wen.TwentyThirdFifty;

public class LongestChunkedPalindromeDecomposition {
    // Use Rabin Karp for comparing prefix and suffix
    public static int longestDecomposition(String text) {
        return ldHelper(text, 0, text.length()-1);
    }

    private static int ldHelper(String s, int start, int end){
        if(start>end){
            return 0;
        } else if(start==end){
            return 1;
        } else{
            int left=start, right=end;
            int base=26, mod=1_000_000_007;
            // Note these need to be long to avoid overflow on int
            long hash1=0, hash2=0, highest=1;
            while(left<right){
                char cs=s.charAt(left), ce=s.charAt(right);
                hash1=((hash1*base)%mod+(cs-'a'))%mod;
                hash2=(hash2+((ce-'a')*highest)%mod)%mod;
                if(hash1==hash2 && s.substring(start, left+1).equals(s.substring(right, end+1))){
                    return 2+ldHelper(s, left+1, right-1);
                }
                highest=(highest*base)%mod;
                left++;
                right--;
            }
            return 1;
        }
    }
}
