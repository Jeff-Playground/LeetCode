import java.util.ArrayList;
import java.util.List;

public class KMP {

    public static void main(String[] args){
        String s="BBC ABCDABDABCDABCDABDE";
        String p="ABCDABD";
        List<Integer> loc=kmpSearch(s, p);
        System.out.println(loc);
    }

    private static List<Integer> kmpSearch(String s, String p) {
        int pl=p.length();
        int[] next=new int[pl];
        next[0]=-1;
        int k=-1, j=0;
        while(j<pl-1){
            if(k==-1 || p.charAt(k)==p.charAt(j)){
                k++;
                j++;
                // This is optimized
                if(p.charAt(k)!=p.charAt(j)){
                    next[j]=k;
                } else{
                    next[j]=next[k];
                }
            } else{
                k=next[k];
            }
        }

        List<Integer> result=new ArrayList<>();
        int sl=s.length();
        int i=0;
        j=0;
        while(i<sl && j<pl){
            if(j==-1 || s.charAt(i)==p.charAt(j)){
                i++;
                j++;
                if(j==pl){
                    result.add(i-pl);
                    j=0;
                }
            } else{
                j=next[j];
            }
        }
        return result;
    }
}
