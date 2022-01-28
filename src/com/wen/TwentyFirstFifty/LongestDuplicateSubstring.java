package com.wen.TwentyFirstFifty;

import java.util.Arrays;

public class LongestDuplicateSubstring {
    // Suffix array
    private class SuffixArrayHelper{
        int[] sa, lcp;

        public SuffixArrayHelper(String s){
            sa=buildSuffixArray(s);
            lcp=buildLCPArray(s, sa);
        }

        private int[] buildLCPArray(String s, int[] sa){
            int l=sa.length;
            int[] pos=new int[l], lcp=new int[l];
            for(int i=0; i<l; i++){
                pos[sa[i]]=i;
            }
            int knownLength=0;
            for(int i=0; i<l; i++){
                if(pos[i]>0){
                    int cur=i, last=sa[pos[i]-1];
                    while(cur+knownLength<l && last+knownLength<l && s.charAt(cur+knownLength)==s.charAt(last+knownLength)){
                        knownLength++;
                    }
                    lcp[pos[i]]=knownLength;
                    if(knownLength>0){
                        knownLength--;
                    }
                }
            }
            return lcp;
        }

        private int[] buildSuffixArray(String s){
            String ns=s+"$";
            int l=ns.length();
            int[] count=new int[256], sa=new int[l], rank=new int[l];
            for(int i=0; i<l; i++){
                count[ns.charAt(i)]++;
            }
            for(int i=1; i<count.length; i++){
                count[i]+=count[i-1];
            }
            for(int i=l-1; i>=0; i--){
                sa[--count[ns.charAt(i)]]=i;
            }
            int r=0;
            for(int i=1; i<l; i++){
                if(ns.charAt(sa[i])!=ns.charAt(sa[i-1])){
                    r++;
                }
                rank[sa[i]]=r;
            }
            for(int k=0; 1<<k<l; k++){
                bsaHelper(ns, sa, rank, k);
            }
            return Arrays.copyOfRange(sa, 1, sa.length);
        }

        private void bsaHelper(String s, int[] sa, int[] rank, int k){
            int l=rank.length;
            int[] count=new int[l], nsa=new int[l];
            for(int i=0; i<l; i++){
                nsa[i]=(sa[i]-(1<<k)+l)%l;
                count[rank[nsa[i]]]++;
            }
            for(int i=1; i<l; i++){
                count[i]+=count[i-1];
            }
            for(int i=l-1; i>=0; i--){
                sa[--count[rank[nsa[i]]]]=nsa[i];
            }
            int r=0;
            int[] nrank=new int[l];
            for(int i=1; i<l; i++){
                if(rank[sa[i]]!=rank[sa[i-1]] || rank[(sa[i]+(1<<k))%l]!=rank[(sa[i-1]+(1<<k))%l]){
                    r++;
                }
                nrank[sa[i]]=r;
            }
            for(int i=0; i<l; i++){
                rank[i]=nrank[i];
            }
        }
    }

    public String longestDupSubstring(String s) {
        if(s.isEmpty()){
            return "";
        } else{
            SuffixArrayHelper saHelper=new SuffixArrayHelper(s);
            int[] lcp=saHelper.lcp, sa=saHelper.sa;
            int maxLength=0, startIdx=-1;
            for(int i=1; i<lcp.length; i++){
                if(lcp[i]>maxLength){
                    maxLength=lcp[i];
                    startIdx=sa[i];
                }
            }
            return maxLength>0?s.substring(startIdx, startIdx+maxLength):"";
        }
    }
}
