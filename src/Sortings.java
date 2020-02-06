import java.util.Arrays;
import java.util.Stack;

public class Sortings {

    public static void main(String[] args){
        Integer[] nums=new Integer[]{10,9,8,7,6,5,4,3,2,1,0};

//        // Best time O(n) - Original array in order
//        // Worst time O(n^2) - Original array in reverse order
//        // Space O(1) - In-place
//        // Stable
//        insertionSort(nums);

//        // Best time O(nlogn)
//        // Worst time less than O(n^2)
//        // Space O(1) - In-place
//        // Un-stable
//        shellSort(nums);

//        // Best time O(n^2)
//        // Worst time O(n^2)
//        // Space O(1) - In-place
//        // Un-stable
//        selectionSort(nums);

//        // Best time O(n+n*3*logn)=O(nlogn)
//        // Worst time O(n+n*3*logn)=O(nlogn) - Doing swap for putting the max to end n times takes O(n), then heapify
//        //                                    takes O(n*3*logn) because doing around n/2 rounds as there are n/2
//        //                                    parents and for each round doing 2 compares and 1 swap
//        // Space O(1) - In-place
//        // Un-stable
//        // Note for forming a heap, it only works with starting index as 0
//        heapSort(nums);

//        // Best time O(n) - Only do the first time iteration and no exchange happens(Original array in order)
//        // Worst time O(n^2) - Original array in reverse order
//        // Space O(1) - In-place
//        // Stable
//        bubbleSort(nums);

//        // Best time O(nlogn) - When each time the partition divide the original array into two equal length parts,
//        //                      T(n)=2*T(n/2)+O(n)，and result can be deduced by using the Master Theorem
//        // Worst time O(n^2) - When each time the partition divide the original array into 0 and (n-1) two parts,
//        //                     T(n)=T(0)+T(n-1)+O(n)
//        // Best space O(logn) - The depth of the recursion tree
//        // Worst space O(n) - The depth of the recursion tree
//        // Un-stable
//        recursionQuickSort(nums, 0, nums.length-1);
//        iterationQuickSort(nums);

//        // Best time O(nlogn) - Because there're logn levels in the recursion tree, and each level takes n to solve
//        // Worst time O(nlogn)
//        // Space O(n) - Needs extra space for execution stack and extra array: O(logn+n)=O(n)
//        // Stable
//        mergingSort(nums);

//        // Best time O(k*n) - k is the maximum digits of nums
//        // Worst time O(k*n) - k is the maximum digits of nums
//        // Space O(base*n+base) - Extra space for buckets and bucketCount
//        // Stable
//        radixSort(nums);

        Arrays.asList(nums).stream().forEach(num->{
            System.out.println(num);
        });
    }

    private static void radixSort(Integer[] nums) {
        int max=Integer.MIN_VALUE, base=10, exp=1, digits=1;
        for(int i=0; i<nums.length; i++){
            max=Math.max(max, nums[i]);
        }

        while(max/base>0){
            max=max/base;
            digits++;
        }

        for(int i=1; i<=digits; i++){
            int[][] buckets=new int[base][nums.length];
            int[] bucketCount=new int[base];
            for(int j=0; j<nums.length; j++){
                int index=nums[j]/exp%base;
                buckets[index][bucketCount[index]++]=nums[j];
            }
            int k=0;
            for(int l=0; l<base; l++){
                for(int m=0; m<bucketCount[l]; m++){
                    nums[k++]=buckets[l][m];
                }
            }
            exp*=10;
        }
    }

    private static Integer[] mergingSort(Integer[] nums) {
        if(nums.length<2){
            return nums;
        }
        int rightStartIndex=nums.length/2;
        Integer[] left=Arrays.copyOfRange(nums, 0, rightStartIndex);
        Integer[] right=Arrays.copyOfRange(nums, rightStartIndex, nums.length);
        return mergeTwoArrays(nums, mergingSort(left), mergingSort(right));
    }

    private static Integer[] mergeTwoArrays(Integer[] nums, Integer[] first, Integer[] second) {
        int i=0, j=0, k=0;
        while(i<first.length && j<second.length){
            if(first[i]<=second[j]){
                nums[k++]=first[i++];
            }else{
                nums[k++]=second[j++];
            }
        }
        while(i<first.length){
            nums[k++]=first[i++];
        }
        while(j<second.length){
            nums[k++]=second[j++];
        }
        return nums;
    }

    private static void iterationQuickSort(Integer[] nums) {
        if(nums.length<2){
            return;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(nums.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int low=stack.pop();
            int high=stack.pop();
            if(low>=high){
                continue;
            }
            int left=low, right=high;
            int temp=nums[left];
            while(right>left){
                while(right>left && nums[right]>=temp){
                    right--;
                }
                nums[left]=nums[right];
                while(right>left && nums[left]<=temp){
                    left++;
                }
                nums[right]=nums[left];
            }
            nums[left]=temp;
            stack.push(high);
            stack.push(left+1);
            stack.push(left-1);
            stack.push(low);
        }
    }

    private static void recursionQuickSort(Integer[] nums, int low, int high) {
        if(nums.length<2 || low>=high){
            return;
        }
        int left=low, right=high;
        int temp=nums[left];
        while(right>left){
            while(right>left && nums[right]>=temp){
                right--;
            }
            nums[left]=nums[right];
            while(right>left && nums[left]<=temp){
                left++;
            }
            nums[right]=nums[left];
        }
        nums[left]=temp;
        recursionQuickSort(nums, low, left-1);
        recursionQuickSort(nums, left+1, high);
    }

    private static void bubbleSort(Integer[] nums) {
        for(int i=nums.length-1; i>0; i--){
            boolean exchange=false;
            for(int j=0; j<i; j++){
                if(nums[j]>nums[j+1]){
                    exchange=true;
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
            if(!exchange){
                break;
            }
        }
    }

    private static void heapSort(Integer[] nums) {
        for(int i=nums.length-1; i>0; i--){
            maxHeapify(nums, i);

            int temp=nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
        }
    }

    private static void maxHeapify(Integer[] nums, int last) {
        if(nums.length<=0 || last==0 || last>nums.length-1){
            return;
        }
        for(int parent=(last-1)/2; parent>=0; parent--){
            int left=parent*2+1;
            int right=parent*2+2;

            int childMaxIndex=right>last?left:(nums[left]>nums[right]?left:right);
            if(nums[childMaxIndex]>nums[parent]){
                int temp=nums[childMaxIndex];
                nums[childMaxIndex]=nums[parent];
                nums[parent]=temp;
            }
        }
    }

    private static void selectionSort(Integer[] nums) {
        for(int i=0; i<nums.length; i++){
            int min=nums[i], index=i;
            for(int j=i+1; j<nums.length; j++){
                if(nums[j]<min){
                    min=nums[j];
                    index=j;
                }
            }
            nums[index]=nums[i];
            nums[i]=min;
        }
    }

    private static void shellSort(Integer[] nums) {
//        Better gap choice by experiment
//        Worst time less than O(n^3/2)
//        int gap=1;
//        while(gap<nums.length/3){
//            gap=gap*3+1;
//        }
//        gap/=3;
        for(int gap=nums.length/2; gap>0; gap/=2){
            for(int i=gap; i<nums.length; i++){
                int temp=nums[i];
                for(int j=i; j>=0; j-=gap){
                    if(j-gap>=0 && nums[j-gap]>temp){
                        nums[j]=nums[j-gap];
                    } else{
                        nums[j]=temp;
                        break;
                    }
                }
            }
        }
    }

    private static void insertionSort(Integer[] nums) {
        for(int i=1; i<nums.length; i++){
            int temp=nums[i];
            for(int j=i; j>=0; j--){
                if(j-1>=0 && nums[j-1]>temp){
                    nums[j]=nums[j-1];
                } else{
                    nums[j]=temp;
                    break;
                }
            }
        }
    }
}
