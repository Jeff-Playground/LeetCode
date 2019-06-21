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
        int i=-1, j=0;
        while(j<p.length()-1){
            if(i==-1 || p.charAt(i)==p.charAt(j)){
                i++;
                j++;
                if(p.charAt(i)!=p.charAt(j)){
                    next[j]=i;
                } else{
                    next[j]=next[i];
                }
            } else{
                i=next[i];
            }
        }

        List<Integer> result=new ArrayList<>();
        int sl=s.length();
        i=0;
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
