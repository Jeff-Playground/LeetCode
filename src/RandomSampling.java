import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomSampling {
    // Note random.nextInt(n) will return a number in 0 to n-1
    public static void main(String[] args) {
        List<Integer> nums=new ArrayList<>();
        for(int i=0; i<10000; i++) {
            nums.add(i);
        }
        // Sampling m items from a total of n items
//		List<Integer> result=randomSampling(10, 10000, nums);
//		List<Integer> result=resovoirRandomSampling(10, 10000, nums);
//      List<Integer> result=selectionRandomSampling(10, 10000, nums);
        List<Integer> result=randomSamplingBasedOnKnuthShuffling(10, 10000, nums);
        result.stream().forEach(System.out::println);
    }

    // Naive way:
    // Pick m rounds randomly from the given list and re-pick if picked a sampled value, this is more and more time-consuming
    // as more and more numbers sampled(probability of conflicts increases)
    private static List<Integer> randomSampling(int m, int n, List<Integer> nums) {
        List<Integer> result=new ArrayList<>();
        Set<Integer> sampled=new HashSet<>();
        Random r=new Random();
        while(result.size()<m) {
            int index=r.nextInt(n);
            while(sampled.contains(index)) {
                index=r.nextInt(n);
            }
            result.add(nums.get(index));
            sampled.add(index);
        }
        return result;
    }

    // Reservoir sampling:
    // Pick the first m elements from the given list, then for the coming elements, swap it into the sampled m elements with a
    // probability of m/(i+1), where i is the index of the element.
    // To prove this:
    // 		For the kth element after the first m elements, the probability of it being in the final result is:
    // 			m/k		*		(1-m/(k+1)+m/(k+1)*(m-1)/m)		*...*	(1-m/n+m/n*(m-1)/m)		=	m/n
    // 			k chosen	*	k+1 (not chosen)+(chosen but replace non k item)		*...*	n (not chosen)+(chosen but replace non k item)
    // 		For any one of the first m elements, the probability of it being in the final result(not replaced) is:
    // 			(1-m/(m+1)+m/(m+1)*(m-1)/m)		*...*	(1-m/n+m/n*(m-1)/m)		=	m/n
    // 			m+1 (not chosen)+(chosen but replace another item)		*...*	n (not chosen)+(chosen but replace another item)
    // 		So the probability for choosing every element is all m/n
    // This works well for large list or infinite list, and is more efficient than the naive way
    private static List<Integer> reservoirRandomSampling(int m, int n, List<Integer> nums) {
        List<Integer> result=new ArrayList<>();
        Random r=new Random();
        for(int i=0; i<m; i++) {
            result.add(nums.get(i));
        }
        for(int i=m; i<n; i++) {
            int value=r.nextInt(i+1);
            if(value<m) {
                result.set(value, nums.get(i));
            }
        }
        return result;
    }

    // Selection sampling:
    // Pick each element based on a variable probability of (m-sampled)/remaining
    // To prove this:
    // 		The 1st element: m/n
    // 		The 2nd element: m/n*(m-1)/(n-1)+(1-m/n)*m/(n-1)=m/n
    // 		...
    // 		So the probability for choosing every element is all m/n
    // This works well when the result need to appear in the original order of the input list, and is more efficient than the
    // naive way
    private static List<Integer> selectionRandomSampling(int m, int n, List<Integer> nums) {
        List<Integer> result=new ArrayList<>();
        Random r=new Random();
        int sampled=0;
        for(int i=0; i<n; i++) {
            if(r.nextInt(n-i)<m-sampled) {
                result.add(nums.get(i));
                sampled++;
            }
        }
        return result;
    }

    // Knuth shuffling:
    private static List<Integer> randomSamplingBasedOnKnuthShuffling(int m, int n, List<Integer> nums){
        List<Integer> result=new ArrayList<>();
        Random r=new Random();
        int l=nums.size();
        for(int i=0; i<l; i++){
            int index=r.nextInt(l-i)+i;
            if(index!=i) {
                int temp = nums.get(i);
                nums.set(i, nums.get(index));
                nums.set(index, temp);
            }
        }
        for(int i=0; i<m; i++){
            result.add(nums.get(i));
        }
        return result;
    }
}