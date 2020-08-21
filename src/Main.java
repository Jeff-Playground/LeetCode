import com.wen.EighteenthFifty.MinimumNumberOfRefuelingStops;
import com.wen.EighteenthFifty.ReachableNodesInSubdividedGraph;
import com.wen.EighteenthFifty.ShortestPathToGetAllKeys;
import com.wen.EighthFifty.*;
import com.wen.EleventhFifty.FindModeInBinarySearchTree;
import com.wen.EleventhFifty.LongestPalindromicSubsequence;
import com.wen.FifteenthFifty.*;
import com.wen.FifthFifty.MinimumSizeSubarraySum;
import com.wen.FifthFifty.SearchA2DMatrixII;
import com.wen.FifthFifty.WordSearchII;
import com.wen.FirstFifty.*;
import com.wen.FourteenthFifty.CutOffTreesForGolfEvent;
import com.wen.FourteenthFifty.FallingSquares;
import com.wen.FourteenthFifty.FindKClosestElements;
import com.wen.FourteenthFifty.SplitArrayIntoConsecutiveSubsequences;
import com.wen.FourthFifty.MaximumGap;
import com.wen.NinthFifty.*;
import com.wen.SecondFifty.TextJustification;
import com.wen.SeventeenthFifty.*;
import com.wen.SeventhFifty.*;
import com.wen.SixteenthFifty.*;
import com.wen.SixthFifty.LQVerifyPreorderSequenceInBinarySearchTree;
import com.wen.TenthFifty.*;
import com.wen.ThirdFifty.LRUCache;
import com.wen.ThirdFifty.SumRootToLeafNumbers;
import com.wen.ThirdFifty.SurroundedRegions;
import com.wen.ThirdFifty.WordBreakII;
import com.wen.TwelfthFifty.PermutationInString;
import com.wen.TwentiethFifty.FindTheTownJudge;
import com.wen.TwentiethFifty.LongestTurbulentSubarray;
import com.wen.TwentiethFifty.PrisonCellsAfterNDays;
import com.wen.TwentySecondFifty.CriticalConnectionsInANetwork;
import com.wen.TwentySecondFifty.LQAllPathsFromSourceLeadToDestination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//        ValidParentheses.isValid("{[]}");

//        int[] a = new int[0];
//        int[] b = new int[1]; b[0]=2;
//        MedianOfTwoSortedArrays.findMedianSortedArrays(a,b);

//        ReverseNodesInKGroup.ListNode l1=new ReverseNodesInKGroup.ListNode(1);
//        ReverseNodesInKGroup.ListNode l2=new ReverseNodesInKGroup.ListNode(2);
//        ReverseNodesInKGroup.ListNode l3=new ReverseNodesInKGroup.ListNode(3);
//        ReverseNodesInKGroup.ListNode l4=new ReverseNodesInKGroup.ListNode(4);
//        ReverseNodesInKGroup.ListNode l5=new ReverseNodesInKGroup.ListNode(5);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        ReverseNodesInKGroup test=new ReverseNodesInKGroup();
//        test.reverseKGroup(l1,2);

//        String[] words={"word","good","best","good"};
//        SubstringWithConcatenationOfAllWords.findSubstring("wordgoodgoodgoodbestword", words);

//        int[] nums={1,2,3,4};
//        NextPermutation.nextPermutation(nums);

//        CountAndSay.countAndSay(4);

//        int[] candidates={2,3,6,7};
//        CombinationSum.combinationSum(candidates,7);

//        int[] nums={3,4,-1,1};
//        FirstMissingPositive.firstMissingPositive(nums);

//        int[] nums={2,0,2};
//        TrappingRainWater.trap(nums);

//        int[] nums={2,3,1,1,4};
//        JumpGameII.jump(nums);

//        int[] nums={1,2,3};
//        Permutations.permute(nums);

//        int[] nums={1,1,1,2,3};
//        PermutationsII.permuteUnique(nums);

//        int[][] multi = new int[][]{
//                { 1,2,5 },
//                { 3,2,1 }
//        };
//        MinimumPathSum.minPathSum(multi);

//        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
//        TextJustification.fullJustify(words,16);
//        String[] words={"What","must","be","acknowledgment","shall","be"};
//        TextJustification.fullJustify(words,16);

//        EditDistance.minDistance("horse","ros");

//        int[] nums={1,2,3};
//        Subsets.subsets(nums);

//        int[] nums = {0,0,1,1,1,1,2,3,3};
//        RemoveDuplicatesFromSortedArrayII.removeDuplicates(nums);

//        RemoveDuplicatesFromSortedListII.ListNode l1=new RemoveDuplicatesFromSortedListII.ListNode(1);
//        RemoveDuplicatesFromSortedListII.ListNode l2=new RemoveDuplicatesFromSortedListII.ListNode(2);
//        RemoveDuplicatesFromSortedListII.ListNode l3=new RemoveDuplicatesFromSortedListII.ListNode(3);
//        RemoveDuplicatesFromSortedListII.ListNode l4=new RemoveDuplicatesFromSortedListII.ListNode(3);
//        RemoveDuplicatesFromSortedListII.ListNode l5=new RemoveDuplicatesFromSortedListII.ListNode(4);
//        RemoveDuplicatesFromSortedListII.ListNode l6=new RemoveDuplicatesFromSortedListII.ListNode(4);
//        RemoveDuplicatesFromSortedListII.ListNode l7=new RemoveDuplicatesFromSortedListII.ListNode(5);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        l6.next=l7;
//        RemoveDuplicatesFromSortedListII test=new RemoveDuplicatesFromSortedListII();
//        test.deleteDuplicates(l1);

//        int[] heights = {2,1,5,6,2,3};
//        LargestRectangleInHistogram.largestRectangleArea(heights);

//        char[][] matrix=new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
//        MaximalRectangle.maximalRectangle(matrix);

//        PartitionList.ListNode l1=new PartitionList.ListNode(1);
//        PartitionList.ListNode l2=new PartitionList.ListNode(4);
//        PartitionList.ListNode l3=new PartitionList.ListNode(3);
//        PartitionList.ListNode l4=new PartitionList.ListNode(5);
//        PartitionList.ListNode l5=new PartitionList.ListNode(5);
//        PartitionList.ListNode l6=new PartitionList.ListNode(2);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        PartitionList test=new PartitionList();
//        test.partition(l1, 3);

//        ScrambleString.isScramble("great", "rgeat");

//        int[] nums1={1,2,3,0,0,0};
//        int[] nums2={4,5,6};
//        MergeSortedArray.merge(nums1,3, nums2,3);

//        DecodeWays.numDecodings("100");

//        ReverseLinkedListII.ListNode l1=new ReverseLinkedListII.ListNode(1);
//        ReverseLinkedListII.ListNode l2=new ReverseLinkedListII.ListNode(2);
//        ReverseLinkedListII.ListNode l3=new ReverseLinkedListII.ListNode(3);
//        ReverseLinkedListII.ListNode l4=new ReverseLinkedListII.ListNode(4);
//        ReverseLinkedListII.ListNode l5=new ReverseLinkedListII.ListNode(5);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        ReverseLinkedListII test=new ReverseLinkedListII();
//        test.reverseBetween(l1, 2,4);

//        RestoreIPAddresses.restoreIpAddresses("25525511135");

//        UniqueBinarySearchTreesII test=new UniqueBinarySearchTreesII();
//        test.generateTrees(3);

//        InterleavingString.isInterleave("aabcc", "dbbca", "aadbbcbcac");

//        BinaryTreeInorderTraversal.TreeNode root=new BinaryTreeInorderTraversal.TreeNode(10);
//        BinaryTreeInorderTraversal.TreeNode n1=new BinaryTreeInorderTraversal.TreeNode(5);
//        BinaryTreeInorderTraversal.TreeNode n2=new BinaryTreeInorderTraversal.TreeNode(15);
//        BinaryTreeInorderTraversal.TreeNode n3=new BinaryTreeInorderTraversal.TreeNode(6);
//        BinaryTreeInorderTraversal.TreeNode n4=new BinaryTreeInorderTraversal.TreeNode(20);
//        root.left=n1;
//        root.right=n2;
//        n2.left=n3;
//        n2.right=n4;
//        BinaryTreeInorderTraversal test=new BinaryTreeInorderTraversal();
//        test.inorderTraversal(root);

//        ValidateBinarySearchTree.TreeNode root=new ValidateBinarySearchTree.TreeNode(10);
//        ValidateBinarySearchTree.TreeNode n1=new ValidateBinarySearchTree.TreeNode(5);
//        ValidateBinarySearchTree.TreeNode n2=new ValidateBinarySearchTree.TreeNode(15);
//        ValidateBinarySearchTree.TreeNode n3=new ValidateBinarySearchTree.TreeNode(6);
//        ValidateBinarySearchTree.TreeNode n4=new ValidateBinarySearchTree.TreeNode(20);
//        root.left=n1;
//        root.right=n2;
//        n2.left=n3;
//        n2.right=n4;
//        ValidateBinarySearchTree test=new ValidateBinarySearchTree();
//        test.isValidBST(root);

//        RecoverBinarySearchTree.TreeNode root=new RecoverBinarySearchTree.TreeNode(1);
//        RecoverBinarySearchTree.TreeNode n1=new RecoverBinarySearchTree.TreeNode(3);
//        RecoverBinarySearchTree.TreeNode n2=new RecoverBinarySearchTree.TreeNode(2);
//        root.left=n1;
//        n1.right=n2;
//        RecoverBinarySearchTree test=new RecoverBinarySearchTree();
//        test.recoverTree(root);

//        SameTree.TreeNode n1=new SameTree.TreeNode(3);
//        SameTree.TreeNode n2=new SameTree.TreeNode(3);
//        SameTree.TreeNode n3=new SameTree.TreeNode(4);
//        SameTree.TreeNode n4=new SameTree.TreeNode(5);
//        SameTree.TreeNode n6=new SameTree.TreeNode(4);
//        n1.left=n3;
//        n1.right=n4;
//        n2.left=n6;
//        SameTree test=new SameTree();
//        System.out.println(test.isSameTree(n1, n2));

//        SymmetricTree.TreeNode root=new SymmetricTree.TreeNode(2);
//        SymmetricTree.TreeNode n1=new SymmetricTree.TreeNode(3);
//        SymmetricTree.TreeNode n2=new SymmetricTree.TreeNode(3);
//        SymmetricTree.TreeNode n3=new SymmetricTree.TreeNode(4);
//        SymmetricTree.TreeNode n4=new SymmetricTree.TreeNode(5);
//        SymmetricTree.TreeNode n6=new SymmetricTree.TreeNode(4);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        n2.right=n6;
//        SymmetricTree test=new SymmetricTree();
//        test.isSymmetric(root);

//        BinaryTreeLevelOrderTraversal.TreeNode root=new BinaryTreeLevelOrderTraversal.TreeNode(3);
//        BinaryTreeLevelOrderTraversal.TreeNode n1=new BinaryTreeLevelOrderTraversal.TreeNode(9);
//        BinaryTreeLevelOrderTraversal.TreeNode n2=new BinaryTreeLevelOrderTraversal.TreeNode(20);
//        BinaryTreeLevelOrderTraversal.TreeNode n3=new BinaryTreeLevelOrderTraversal.TreeNode(15);
//        BinaryTreeLevelOrderTraversal.TreeNode n4=new BinaryTreeLevelOrderTraversal.TreeNode(7);
//        root.left=n1;
//        root.right=n2;
//        n2.left=n3;
//        n2.right=n4;
//        BinaryTreeLevelOrderTraversal test=new BinaryTreeLevelOrderTraversal();
//        test.levelOrder(root);


//        int[] preorder={3,9,20,15,7};
//        int[] inorder={9,3,15,20,7};
//        ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder);


//        int[] nums={-10,-3,0,5,9};
//        ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);

//        PathSumII.TreeNode root=new PathSumII.TreeNode(5);
//        PathSumII.TreeNode n1=new PathSumII.TreeNode(4);
//        PathSumII.TreeNode n2=new PathSumII.TreeNode(8);
//        PathSumII.TreeNode n3=new PathSumII.TreeNode(11);
//        PathSumII.TreeNode n4=new PathSumII.TreeNode(13);
//        PathSumII.TreeNode n5=new PathSumII.TreeNode(14);
//        PathSumII.TreeNode n6=new PathSumII.TreeNode(7);
//        PathSumII.TreeNode n7=new PathSumII.TreeNode(2);
//        PathSumII.TreeNode n8=new PathSumII.TreeNode(5);
//        PathSumII.TreeNode n9=new PathSumII.TreeNode(1);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n2.left=n4;
//        n2.right=n5;
//        n3.left=n6;
//        n3.right=n7;
//        n5.left=n8;
//        n5.right=n9;
//        PathSumII test=new PathSumII();
//        test.pathSum(root, 22);

//        NQueens.solveNQueens(4);

//        ValidNumber.isNumber(".0");

//        Combinations.combine(6, 3);

//        int[] prices={3,3,5,0,0,3,1,4};
//        BestTimeToBuyAndSellStockIII.maxProfit(prices);

//        ValidPalindrome.isPalindrome("0P");

//        WordLadderII.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));

//        WordLadder.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));

//        char[][] matrix=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] matrix=new char[][]{{'O','O'},{'O','O'}};
//        char[][] matrix=new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        char[][] matrix=new char[][]{{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','X','O','O','O','O','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','X','O','X','O','O','O','O','X','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','X','O'},{'O','X','X','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','X','O','O','O','O','O','X','X','O'},{'O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','X','O'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','O','O'},{'X','O','O','O','O','O','O','O','O','X','X','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','O','O','O','X','O','O','O','O','O','O','O','O'},{'O','O','O','O','X','O','O','O','O','O','O','O','O','X','O','O','O','O','O','X'},{'O','O','O','O','O','X','O','O','O','O','O','O','O','O','O','X','O','X','O','O'},{'O','X','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'},{'O','O','O','O','O','O','O','O','X','X','O','O','O','X','O','O','X','O','O','X'},{'O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O','O'}};
//        SurroundedRegions.solve(matrix);

//        PalindromePartitioning.partition("aab");

//        ReverseBits.reverseBits(43261596);

//        PalindromePartitioningII.minCut("aab");

//        CloneGraph.UndirectedGraphNode node=new CloneGraph.UndirectedGraphNode(0);
//        node.neighbors.add(node);
//        node.neighbors.add(node);
//        CloneGraph.cloneGraph(node);

//        int[] ratings={1,3,2,2,1};
//        Candy.candy(ratings);

//        WordBreakII.wordBreak("catsandog", Arrays.asList("cat","cats","and","sand","dog"));

//        LRUCache cache=new LRUCache(2);
//        cache.put(1,1);
//        cache.put(2,2);
//        cache.get(1);
//        cache.put(3,3);
//        cache.get(2);
//        cache.put(4,4);
//        cache.get(1);
//        cache.get(3);
//        cache.get(4);

//        LRUCache cache=new LRUCache(1);
//        cache.put(2,1);
//        cache.get(2);
//        cache.put(3,2);
//        cache.get(2);
//        cache.get(3);

////        MaxPointsOnALine.Point[] points={new MaxPointsOnALine.Point(1,1), new MaxPointsOnALine.Point(3,2),
////                new MaxPointsOnALine.Point(5,3), new MaxPointsOnALine.Point(4,1), new MaxPointsOnALine.Point(2,3),
////                new MaxPointsOnALine.Point(1,4)};
//        MaxPointsOnALine.Point[] points={new MaxPointsOnALine.Point(2,3), new MaxPointsOnALine.Point(3,3),
//                new MaxPointsOnALine.Point(-5, 3)};
//        MaxPointsOnALine.maxPoints(points);

//        String[] tokens={"4","13","5","/","+"};
//        EvaluateReversePolishNotation.evalRPN(tokens);

//        ReverseWordsInAString.reverseWords("   the    sky is blue   ");

//        int[] nums={1,2,3,4,5};
//        FindMinimumInRotatedSortedArray.findMin(nums);

//        int[] nums={2,2,2,0,1};
//        FindMinimumInRotatedSortedArrayII.findMin(nums);

//        MinStack minStack=new MinStack();
//        minStack.push(-2);
//        minStack.push(0);
//        minStack.push(-3);
//        int min1=minStack.getMin();
//        minStack.pop();
//        int top=minStack.top();
//        int min2=minStack.getMin();

//        LQBinaryTreeUpsideDown.TreeNode root=new LQBinaryTreeUpsideDown.TreeNode(1);
//        LQBinaryTreeUpsideDown.TreeNode n1=new LQBinaryTreeUpsideDown.TreeNode(2);
//        LQBinaryTreeUpsideDown.TreeNode n2=new LQBinaryTreeUpsideDown.TreeNode(3);
//        LQBinaryTreeUpsideDown.TreeNode n3=new LQBinaryTreeUpsideDown.TreeNode(4);
//        LQBinaryTreeUpsideDown.TreeNode n4=new LQBinaryTreeUpsideDown.TreeNode(5);
//        LQBinaryTreeUpsideDown.TreeNode n5=new LQBinaryTreeUpsideDown.TreeNode(6);
//        LQBinaryTreeUpsideDown.TreeNode n6=new LQBinaryTreeUpsideDown.TreeNode(7);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        n2.left=n5;
//        n2.right=n6;
//        LQBinaryTreeUpsideDown.upsideDownBinaryTree(root);

//        LQLongestSubstringWithAtMostTwoDistinctCharacters.lengthOfLongestSubstringTwoDistinct("eceba",3);

//        IntersectionOfTwoLinkedLists.ListNode n1=new IntersectionOfTwoLinkedLists.ListNode(4);
//        IntersectionOfTwoLinkedLists.ListNode n2=new IntersectionOfTwoLinkedLists.ListNode(1);
//        IntersectionOfTwoLinkedLists.ListNode n3=new IntersectionOfTwoLinkedLists.ListNode(8);
//        IntersectionOfTwoLinkedLists.ListNode n4=new IntersectionOfTwoLinkedLists.ListNode(4);
//        IntersectionOfTwoLinkedLists.ListNode n5=new IntersectionOfTwoLinkedLists.ListNode(5);
//        n1.next=n2;
//        n2.next=n3;
//        n3.next=n4;
//        n4.next=n5;
//
//        IntersectionOfTwoLinkedLists.ListNode n6=new IntersectionOfTwoLinkedLists.ListNode(5);
//        IntersectionOfTwoLinkedLists.ListNode n7=new IntersectionOfTwoLinkedLists.ListNode(0);
//        IntersectionOfTwoLinkedLists.ListNode n8=new IntersectionOfTwoLinkedLists.ListNode(1);
//        n6.next=n7;
//        n7.next=n8;
////        n8.next=n3;
//        IntersectionOfTwoLinkedLists.getIntersectionNode(n1,n6);

//        int[] nums={Integer.MIN_VALUE,Integer.MIN_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE};
//        MissingRanges.findMissingRanges(nums, Integer.MIN_VALUE,Integer.MAX_VALUE);

//        FractionToRecurringDecimal.fractionToDecimal(-1,Integer.MIN_VALUE);

//        ExcelSheetColumnTitle.convertToTitle(701);

//        int[] nums={226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124};
//        HouseRobber.rob(nums);

//        WildcardMatching.isMatch("aa", "a");
//        WildcardMatching.isMatch("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
//        "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*");

//        int[] nums={4,3,2,6};
//        RotateFunction.maxRotateFunction(nums);

//        RepeatedSubstringPattern.repeatedSubstringPattern("abab");

//        DesignTwitter.Twitter twitter=new DesignTwitter.Twitter();
//        twitter.postTweet(1,5);
//        twitter.postTweet(1,3);
//        twitter.postTweet(1,101);
//        twitter.postTweet(1,13);
//        twitter.postTweet(1,10);
//        twitter.postTweet(1,2);
//        twitter.postTweet(1,94);
//        twitter.postTweet(1,505);
//        twitter.postTweet(1,333);
//        twitter.postTweet(1,22);
//        twitter.postTweet(1,11);
//        twitter.getNewsFeed(1);

//        int[] nums={2,3,2};
//        SetMismatch.findErrorNums(nums);

//        int[] nums={0,0,1,1};
//        MinCostClimbingStairs.minCostClimbingStairs(nums);

//        SplitLinkedListInParts.ListNode l1=new SplitLinkedListInParts.ListNode(1);
//        SplitLinkedListInParts.ListNode l2=new SplitLinkedListInParts.ListNode(2);
//        SplitLinkedListInParts.ListNode l3=new SplitLinkedListInParts.ListNode(3);
//        SplitLinkedListInParts.ListNode l4=new SplitLinkedListInParts.ListNode(4);
//        SplitLinkedListInParts.ListNode l5=new SplitLinkedListInParts.ListNode(5);
//        SplitLinkedListInParts.ListNode l6=new SplitLinkedListInParts.ListNode(6);
//        SplitLinkedListInParts.ListNode l7=new SplitLinkedListInParts.ListNode(7);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
//        l5.next=l6;
//        l6.next=l7;
//        SplitLinkedListInParts test=new SplitLinkedListInParts();
//        test.splitListToParts(l1,3);

//        LQClosestLeafInABinaryTree.TreeNode root=new LQClosestLeafInABinaryTree.TreeNode(1);
//        LQClosestLeafInABinaryTree.TreeNode n1=new LQClosestLeafInABinaryTree.TreeNode(3);
//        LQClosestLeafInABinaryTree.TreeNode n2=new LQClosestLeafInABinaryTree.TreeNode(4);
//        LQClosestLeafInABinaryTree.TreeNode n3=new LQClosestLeafInABinaryTree.TreeNode(9);
//        LQClosestLeafInABinaryTree.TreeNode n4=new LQClosestLeafInABinaryTree.TreeNode(10);
//        root.left=n1;
//        root.right=n2;
//        n2.right=n3;
//        n3.right=n4;
//        LQClosestLeafInABinaryTree.findClosestLeaf(root,4);

//        SequenceReconstruction.sequenceReconstruction(new int[]{5,3,2,4,1}, new int[][]{{5,3,2,4},{4,1},{1},{3},{2,4},{1,1000000000}});

//        MissingNumber.missingNumber(new int[]{3,0,1});

//        SortColors.sortColors(new int[]{2,1,0,2,1,0});

//        FindCommonCharacters.commonChars(new String[]{"bella","label","roller"});

//        MajorityElementII.majorityElement(new int[]{1,2,2,3,2,1,1,3});

//        WordSearchII.findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}}, new String[]{"oath","pea","eat","rain"});

//        TheSkylineProblem.getSkyline(new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}});

//        LQGroupShiftedStrings.groupStrings(new String[]{"abc","bcd","acef","xyz","cb","az","x","z"});

//        LQAlienDictionary.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"});

//        int[][] rooms=new int[][]{{Integer.MAX_VALUE,Integer.MAX_VALUE,0,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},{Integer.MAX_VALUE,0,Integer.MAX_VALUE,Integer.MAX_VALUE}};
//        LQWallsAndGates.wallsAndGates(rooms);

//        RangeSumQueryImmutable.NumArray numArray=new RangeSumQueryImmutable.NumArray(new int[]{-2,0,3,-5,2,-1});
//        numArray.sumRange(2,5);

//        IsSubsequence.isSubsequence2("leeeeetcode", "yyyyylyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyytyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyycyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyoyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyydyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyeyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");

//        int[][] matrix=new int[][]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
//        LQRangeSumQuery2DMutable.NumMatrix nm=new LQRangeSumQuery2DMutable.NumMatrix(matrix);
//        nm.sumRegion(2,1,4,3);
//        nm.update(3,2,2);
//        nm.sumRegion(2,1,4,3);
//
//        int[][] matrix=new int[][]{{2,4},{-3,5}};
//        LQRangeSumQuery2DMutable.NumMatrix nm=new LQRangeSumQuery2DMutable.NumMatrix(matrix);
//        nm.update(0,1,3);
//        nm.update(1,1,-3);
//        nm.update(0,1,1);
//        nm.sumRegion(0,0,1,1);

//        InsertionSortList.ListNode l1=new InsertionSortList.ListNode(4);
//        InsertionSortList.ListNode l2=new InsertionSortList.ListNode(2);
//        InsertionSortList.ListNode l3=new InsertionSortList.ListNode(1);
//        InsertionSortList.ListNode l4=new InsertionSortList.ListNode(3);
//        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        InsertionSortList.insertionSortList(l1);

//        RepeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

//        ShortestUnsortedContinuousSubarray.findUnsortedSubarray(new int[]{5,4,3,2,1});

//        ShortestPalindrome.shortestPalindrome("32345");

//        MaximalSquare.maximalSquare(new char[][]{{'1','1'},{'1','1'}});

//        CountCompleteTreeNodes.TreeNode root=new CountCompleteTreeNodes.TreeNode(1);
//        CountCompleteTreeNodes.TreeNode n1=new CountCompleteTreeNodes.TreeNode(2);
//        CountCompleteTreeNodes.TreeNode n2=new CountCompleteTreeNodes.TreeNode(3);
//        CountCompleteTreeNodes.TreeNode n3=new CountCompleteTreeNodes.TreeNode(4);
//        CountCompleteTreeNodes.TreeNode n4=new CountCompleteTreeNodes.TreeNode(5);
//        CountCompleteTreeNodes.TreeNode n5=new CountCompleteTreeNodes.TreeNode(6);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        n2.left=n5;
//        CountCompleteTreeNodes.countNodes(root);

//        BasicCalculator.calculate("1+1");

//        DifferentWaysToAddParentheses.diffWaysToCompute("2*3-4*5");

//        LQVerifyPreorderSequenceInBinarySearchTree.verifyPreorder(new int[]{4,2,1,3,6,5,7});

//        LQ3SumSmaller.threeSumSmaller(new int[]{0,-2,-2,-4,4,3,1,-2,-5,1,0,-5,-4,4,0,-4}, -4);

//        LQGraphValidTree.validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}});
//        LQGraphValidTree.validTree(5, new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}});
//        LQGraphValidTree.validTree(1, new int[][]{});

//        CountOfSmallerNumbersAfterSelf.countSmaller(new int[]{5,2,6,1});

//        PerfectSquares.numSquares(12);

//        EvaluateDivision.calcEquation(Arrays.asList(Arrays.asList("x1","x2"),Arrays.asList("x2","x3"),Arrays.asList("x3","x4"),Arrays.asList("x4","x5")),
//                new double[]{3.0,4.0,5.0,6.0},
//                Arrays.asList(Arrays.asList("x1","x5"),Arrays.asList("x5","x2"),Arrays.asList("x2","x4"),Arrays.asList("x2","x2"),Arrays.asList("x2","x9"),Arrays.asList("x9","x9")));

//        CircularArrayLoop.circularArrayLoop(new int[]{-2,1,-1,-2,-2});

//        LQOptimalAccountBalancing.balanceGraph(new int[][]{{0,1,10}, {2,0,5}});

//        PredictTheWinner.PredictTheWinner(new int[]{1,5,2});

//        int[][] maze=new int[][]{{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
//        LQTheMazeIII.findShortestWay(maze, new int[]{4,3}, new int[]{0,1});

//        PartitionEqualSubsetSum.canPartition(new int[]{1,2,5});

//        CoinChange2.change(5, new int[]{1,2,5});

//        SlidingWindowMedian.medianSlidingWindow(new int[]{Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MAX_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE},3);

//        NextGreaterElementIII.nextGreaterElement(12443322);

//        LQWordAbbreviation.wordsAbbreviation(new String[]{"like","god","internal","me","internet","interval","intension","face","intrusion"});

//        StudentAttendanceRecordII.checkRecord(99996);

//        LQMaximumVacationDays.maxVacationDays(new int[][]{{0,0,0},{0,0,0},{0,0,0}}, new int[][]{{1,1,1},{7,7,7},{7,7,7}});

//        SplitArrayIntoConsecutiveSubsequences.isPossible(new int[]{1,2,3,4,4,5});

//        LQNextClosestTime.nextClosestTime("23:59");

//        LQKEmptySlots.kEmptySlots(new int[]{6,5,8,9,7,1,10,2,3,4}, 2);
//        LQKEmptySlots.kEmptySlots(new int[]{1,2,3,4}, 1);

//        PathSumIII.TreeNode root=new PathSumIII.TreeNode(10);
//        PathSumIII.TreeNode n1=new PathSumIII.TreeNode(5);
//        PathSumIII.TreeNode n2=new PathSumIII.TreeNode(-3);
//        PathSumIII.TreeNode n3=new PathSumIII.TreeNode(3);
//        PathSumIII.TreeNode n4=new PathSumIII.TreeNode(2);
//        PathSumIII.TreeNode n5=new PathSumIII.TreeNode(11);
//        PathSumIII.TreeNode n6=new PathSumIII.TreeNode(3);
//        PathSumIII.TreeNode n7=new PathSumIII.TreeNode(-2);
//        PathSumIII.TreeNode n8=new PathSumIII.TreeNode(1);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        n2.right=n5;
//        n3.left=n6;
//        n3.right=n7;
//        n4.right=n8;
//        PathSumIII.pathSum(root, 8);

//        RedundantConnection.findRedundantConnection(new int[][]{{1,2},{1,3},{2,3}});

//        LongestWordInDictionary.longestWord(new String[]{"w","wo","wor","worl", "world"});

//        List<List<String>> accounts=new ArrayList<>();
//        accounts.add(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"));
//        accounts.add(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"));
//        accounts.add(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"));
//        accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
//        accounts.add(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
//        AccountsMerge.accountsMerge(accounts);

//        RemoveComments.removeComments(new String[]{"a/*comment", "line", "more_comment*/b"});

//        FindPivotIndex.pivotIndex(new int[]{-1,-1,-1,-1,-1,0});

//        MyCalendarI.MyCalendar t=new MyCalendarI.MyCalendar();
//        t.book(20,32);
//        t.book(1,19);
//        t.book(34, 47);
//        t.book(30,48);
//        t.book(26,44);

//        MyCalendarII.MyCalendarTwo t=new MyCalendarII.MyCalendarTwo();
//        t.book(24,40);
//        t.book(43,50);
//        t.book(27,43);
//        t.book(5,21);
//        t.book(30,40);
//        t.book(14,29);
//        t.book(3,19);
//        t.book(3,14);
//        t.book(25,39);
//        t.book(6,19);

//        LQMinimumWindowSubsequence.minWindow("cnhczmccqouqadqtmjjzl","mm");

//        LongestPalindromicSubsequence.longestPalindromeSubseq("aabaaba");

//        LongestPalindromicSubstring.longestPalindrome("bba");

//        LQSequenceReconstruction.sequenceReconstruction(new int[]{1,2,3}, new int[][]{{1,2}, {1,3}, {2,3}});

//        CheapestFlightsWithinKStops.findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1);

//        SwapAdjacentInLRString.canTransform("XXXLXXXXXX","XXXLXXXXXX");

//        LQMinimizeMaxDistanceToGasStation.minmaxGasDist(new int[]{1,2,3,4,5,6,7,8,9,10}, 9);

//        IsGraphBipartite.isBipartite(new int[][]{{3},{2,4},{1},{0,4},{1,3}});

//        FindEventualSafeStates.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});

//        AirbnbTest.evaluateActions(Arrays.asList("A Munich Hold", "B Bohemia Move Munich", "C Warsaw Support B"));

//        BricksFallingWhenHit.hitBricks(new int[][]{{1},{1},{1},{1},{1}},
//                new int[][]{{3,0},{4,0},{1,0},{2,0},{0,0}});

//        SplitArrayWithSameAverage.splitArraySameAverage(new int[]{23,98,92,20,29,79,21,71,95,46,45,0,95,1});
//        SplitArrayWithSameAverage.splitArraySameAverage(new int[]{10,29,13,53,33,48,76,70,5,5});

//        ExpressiveWords.expressiveWords("yyrrrrrjaappoooyybbbebbbbriiiiiyyynnnvvwtwwwwwooeeexxxxxkkkkkaaaaauuuu", new String[]{"yrrjjappooybbebriiyynvvwtwwoeexkauu"});

//        RectangleAreaII.rectangleArea(new int[][]{{0,0,1000000000,1000000000}});
//        RectangleAreaII.rectangleArea(new int[][]{{0,0,2,2},{1,0,2,3},{1,0,3,1}});

//        FallingSquares.fallingSquares(new int[][]{{9,7},{1,9},{3,1}});

//        PalindromePairs.palindromePairs(new String[] {"abcd","dcba","lls","s","sssll", ""});
//
//        LQIPToCIDR.ipToCIDR("255.0.0.7", 10);

//        // Input: schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//        // Output: [[3,4]]
//		Interval i1=new Interval(1,2),
//				i2=new Interval(5,6),
//						i3=new Interval(1,3),
//								i4=new Interval(4,10);
//		List<List<Interval>> schedule=new ArrayList<>();
//		schedule.add(Arrays.asList(i1,i2));
//		schedule.add(Arrays.asList(i3));
//		schedule.add(Arrays.asList(i4));
//		LQEmployeeFreeTime.employeeFreeTime(schedule);
//
//        // Input: schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//        // Output: [[5,6],[7,9]]
//		Interval i1=new Interval(1,3),
//				i2=new Interval(6,7),
//						i3=new Interval(2,4),
//								i4=new Interval(2,5),
//										i5=new Interval(9,12);
//		List<List<Interval>> schedule=new ArrayList<>();
//		schedule.add(Arrays.asList(i1,i2));
//		schedule.add(Arrays.asList(i3));
//		schedule.add(Arrays.asList(i4,i5));
//		LQEmployeeFreeTime.employeeFreeTime(schedule);

//        PyramidTransitionMatrix.pyramidTransition("BCD", Arrays.asList("BCG", "CDE", "GEA", "FFF"));

//		RegularExpressionMatching.isMatch("aaa","a*a");

//        BestTimeToBuyAndSellStockWithCooldown.maxProfit(new int[]{1,2,4});

//        FindKClosestElements.findClosestElements(new int[]{1,2,3,4,5}, 4, 3);

//        RemoveInvalidParentheses.removeInvalidParentheses("()())");

//        CutOffTreesForGolfEvent.cutOffTree(Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(0,0,4),Arrays.asList(7,6,5)));


//        SumRootToLeafNumbers.TreeNode root=new SumRootToLeafNumbers.TreeNode(1);
//        SumRootToLeafNumbers.TreeNode n1=new SumRootToLeafNumbers.TreeNode(0);
//        root.left=n1;
//        SumRootToLeafNumbers.sumNumbers(root);

//        MinimumSizeSubarraySum.minSubArrayLen(7, new int[]{2,3,1,2,4,3});

//        SearchA2DMatrixII.searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5);

//        LQVerifyPreorderSequenceInBinarySearchTree.verifyPreorder(new int[]{10,7,4,8,6,40,23});

//        CombinationSumIV.combinationSum4(new int[]{2,1,3}, 35);

//        CouplesHoldingHands.minSwapsCouples(new int[]{0, 5, 1, 3, 2, 4});

//        MonotoneIncreasingDigits.monotoneIncreasingDigits(332);

//        LQNumberOfCornerRectangles.countCornerRectangles(new int[][]{{1,0,0,1,0},{0,0,1,0,1},{0,0,0,1,0},{1,0,1,0,1}});

//        PrisonCellsAfterNDays.prisonAfterNDays(new int[]{0,0,0,1,1,0,1,0}, 574);

//        ShortestPathToGetAllKeys.shortestPathAllKeys(new String[]{"@...a",".###A","b.BCc"});

//        ReachableNodesInSubdividedGraph.reachableNodes(new int[][]{{1,2,5},{0,3,3},{1,3,2},{2,3,4},{0,4,1}},7,5);

//        MinimumNumberOfRefuelingStops.minRefuelStops(1000000,70768,new int[][]{{12575,171159},{81909,101253},{163732,164401},{190025,65493},{442889,31147},{481202,166081},{586028,206379},{591952,52748},{595013,9163},{611883,217156}});

//        LQNumberOfConnectedComponentsInAnUndirectedGraph.countComponents(5, new int[][]{{0,1},{1,2},{3,4}});
//        LQNumberOfConnectedComponentsInAnUndirectedGraph.countComponents(5, new int[][]{{0,1},{1,2},{2,3},{3,4}});

//        System.out.println(LQAllPathsFromSourceLeadToDestination.leadsToDestination(3, new int[][]{{0,1},{0,2}}, 0, 2));
//        System.out.println(LQAllPathsFromSourceLeadToDestination.leadsToDestination(4, new int[][]{{0,1},{0,3},{1,2},{2,1}}, 0, 3));
//        System.out.println(LQAllPathsFromSourceLeadToDestination.leadsToDestination(4, new int[][]{{0,1},{0,2},{1,3},{2,3}}, 0, 3));
//        System.out.println(LQAllPathsFromSourceLeadToDestination.leadsToDestination(3, new int[][]{{0,1},{1,1},{1,2}}, 0, 2));
//        System.out.println(LQAllPathsFromSourceLeadToDestination.leadsToDestination(2, new int[][]{{0,1},{1,1}}, 0, 1));

//        FindTheTownJudge.findJudge(4,new int[][]{{1,2},{1,3},{2,1},{2,3},{1,4},{4,3},{4,1}});

//        WiggleSortII.wiggleSort(new int[]{0,1,2,3,4,5,6,7,8,9,10});

//        LongestTurbulentSubarray.maxTurbulenceSize(new int[]{0,8,45,88,48,68,28,55,17,24});

//        LQLargestBSTSubtree.TreeNode root=new LQLargestBSTSubtree.TreeNode(10);
//        LQLargestBSTSubtree.TreeNode n1=new LQLargestBSTSubtree.TreeNode(5);
//        LQLargestBSTSubtree.TreeNode n2=new LQLargestBSTSubtree.TreeNode(15);
//        LQLargestBSTSubtree.TreeNode n3=new LQLargestBSTSubtree.TreeNode(1);
//        LQLargestBSTSubtree.TreeNode n4=new LQLargestBSTSubtree.TreeNode(8);
//        LQLargestBSTSubtree.TreeNode n5=new LQLargestBSTSubtree.TreeNode(7);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        n2.right=n5;
//        LQLargestBSTSubtree.largestBSTSubtree(root);

//        LQFindLeavesOfBinaryTree.TreeNode root=new LQFindLeavesOfBinaryTree.TreeNode(1);
//        LQFindLeavesOfBinaryTree.TreeNode n1=new LQFindLeavesOfBinaryTree.TreeNode(2);
//        LQFindLeavesOfBinaryTree.TreeNode n2=new LQFindLeavesOfBinaryTree.TreeNode(3);
//        LQFindLeavesOfBinaryTree.TreeNode n3=new LQFindLeavesOfBinaryTree.TreeNode(4);
//        LQFindLeavesOfBinaryTree.TreeNode n4=new LQFindLeavesOfBinaryTree.TreeNode(5);
//        root.left=n1;
//        root.right=n2;
//        n1.left=n3;
//        n1.right=n4;
//        LQFindLeavesOfBinaryTree.findLeaves(root);

//        FindModeInBinarySearchTree.TreeNode root=new FindModeInBinarySearchTree.TreeNode(1);
//        FindModeInBinarySearchTree.TreeNode n1=new FindModeInBinarySearchTree.TreeNode(2);
//        root.right=n1;
//        FindModeInBinarySearchTree.findMode(root);

//        LQLongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("KB",10);

//        LQRearrangeStringKDistanceApart.rearrangeString("aabbcc",3);
//        LQRearrangeStringKDistanceApart.rearrangeString("aaabc", 3);
//        LQRearrangeStringKDistanceApart.rearrangeString("aaadbbcc", 2);

//        LongestRepeatingCharacterReplacement.characterReplacement("AABABBA", 1);

//        PermutationInString.checkInclusion("hello", "ooolleoooleh");

//        LQMaxConsecutiveOnesII.findMaxConsecutiveOnes(new int[]{0,0,1,1,1,0,0,1,1,1,0});

//        CoinChange.coinChange(new int[]{1,2}, 2);

//        LQSmallestRectangleEnclosingBlackPixels.minArea(new char[][]{"0010".toCharArray(),"0110".toCharArray(),"0100".toCharArray()}, 0, 2);

//        LQShortestDistanceFromAllBuildings.shortestDistance(new int[][]{{1,1,1,1,1,0},{0,0,0,0,0,1},{0,1,1,0,0,1},{1,0,0,1,0,1},{1,0,1,0,0,1},{1,0,0,0,0,1},{0,1,1,1,1,0}});

//        LQGeneralizedAbbreviation.generateAbbreviations("word");

//        CreateMaximumNumber.maxNumber(new int[]{3,4,6,5},
//                new int[]{9,1,2,5,8,3},
//                5);

//        CountOfRangeSum.countRangeSum(new int[]{2147483647,-2147483648,-1,0},
//        -1,
//        0);

//        ReversePairs.reversePairs(new int[]{2147483647,2147483647,-2147483647,-2147483647,-2147483647,2147483647});

//        LQAndroidUnlockPatterns.numberOfPatterns(1,3);

//        DataStreamAsDisjointIntervals.SummaryRanges obj = new DataStreamAsDisjointIntervals.SummaryRanges();
//        obj.addNum(1);
//        obj.addNum(3);
//        obj.addNum(7);
//        obj.addNum(2);
//        obj.addNum(6);

//        RussianDollEnvelopes.maxEnvelopes(new int[][]{{46,89},{50,53},{52,68},{72,45},{77,81}});

//        LQLineReflection.isReflected(new int[][]{{1,1}, {-1,1}});

//        ValidPerfectSquare.isPerfectSquare(2147483647);

//        MaxSumOfRectangleNoLargerThanK.maxSumSubmatrix(new int[][]{{2,2,-1}}, 3);

//        GuessNumberHigherOrLowerII.getMoneyAmount(20);

//        WiggleSubsequence.wiggleMaxLength(new int[]{1,7,4,9,2,5});

//        LongestAbsoluteFilePath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");

//        UTFEightValidation.validUtf8(new int[]{197,130,1});

//        IntegerReplacement.integerReplacement(Integer.MAX_VALUE);

//        NthDigit.findNthDigit(100);

//        CriticalConnectionsInANetwork.criticalConnections(4, Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2), Arrays.asList(2,0), Arrays.asList(1,3)));

//        BinaryWatch.readBinaryWatch(1);

//        RemoveKDigits.removeKdigits("112", 1);

//        MaximumGap.maximumGap(new int[]{1,10000000});

//        FrogJump.canCross(new int[]{0,1,3,5,6,8,12,17});

//        ConvertANumberToHexadecimal.toHex(-1);

//        LongestPalindrome.longestPalindrome("aabbccd");

//        SplitArrayLargestSum.splitArray(new int[]{7,2,5,10,8}, 2);

//        LQMinimumUniqueWordAbbreviation.minAbbreviation("tesjwh", new String[]{"blade"});

//        AddStrings.addStrings("9", "1");

//        StrongPasswordChecker.strongPasswordChecker("1234567890123456Baaaa");

//        LQWordSquares.wordSquares(new String[]{"area","lead","wall","lady","ball"});

//        LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode root=new LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode(4);
//        LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode n1=new LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode(2);
//        LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode n2=new LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode(5);
//        LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode n3=new LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode(1);
//        LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode n4=new LQConvertBinarySearchTreeToSortedDoublyLinkedList.TreeNode(3);
//        n1.left=n3;
//        n1.right=n4;
//        root.left=n1;
//        root.right=n2;
//        LQConvertBinarySearchTreeToSortedDoublyLinkedList.treeToDoublyList(root);

//        SerializeAndDeserializeBST.TreeNode n1=new SerializeAndDeserializeBST.TreeNode(1);
//        SerializeAndDeserializeBST.TreeNode n2=new SerializeAndDeserializeBST.TreeNode(2);
//        SerializeAndDeserializeBST.TreeNode n3=new SerializeAndDeserializeBST.TreeNode(3);
//        SerializeAndDeserializeBST.TreeNode n4=new SerializeAndDeserializeBST.TreeNode(4);
//        SerializeAndDeserializeBST.TreeNode n5=new SerializeAndDeserializeBST.TreeNode(5);
//        SerializeAndDeserializeBST.TreeNode n6=new SerializeAndDeserializeBST.TreeNode(6);
//        SerializeAndDeserializeBST.TreeNode n7=new SerializeAndDeserializeBST.TreeNode(7);
//        n4.left=n2;
//        n4.right=n6;
//        n2.left=n1;
////        n2.right=n3;
////        n6.left=n5;
//        n6.right=n7;
//

//        NaryTreeLevelOrderTraversal.Node n1=new NaryTreeLevelOrderTraversal.Node(1);
//        NaryTreeLevelOrderTraversal.Node n2=new NaryTreeLevelOrderTraversal.Node(2);
//        NaryTreeLevelOrderTraversal.Node n3=new NaryTreeLevelOrderTraversal.Node(3);
//        NaryTreeLevelOrderTraversal.Node n4=new NaryTreeLevelOrderTraversal.Node(4);
//        NaryTreeLevelOrderTraversal.Node n5=new NaryTreeLevelOrderTraversal.Node(5);
//        NaryTreeLevelOrderTraversal.Node n6=new NaryTreeLevelOrderTraversal.Node(6);
//        NaryTreeLevelOrderTraversal.Node n7=new NaryTreeLevelOrderTraversal.Node(7);
//        NaryTreeLevelOrderTraversal.Node n8=new NaryTreeLevelOrderTraversal.Node(8);
//        NaryTreeLevelOrderTraversal.Node n9=new NaryTreeLevelOrderTraversal.Node(9);
//        NaryTreeLevelOrderTraversal.Node n10=new NaryTreeLevelOrderTraversal.Node(10);
//        NaryTreeLevelOrderTraversal.Node n11=new NaryTreeLevelOrderTraversal.Node(11);
//        NaryTreeLevelOrderTraversal.Node n12=new NaryTreeLevelOrderTraversal.Node(12);
//        n1.next=n2;
//        n2.prev=n1;
//        n2.next=n3;
//        n3.prev=n2;
//        n3.next=n4;
//        n4.prev=n3;
//        n4.next=n5;
//        n5.prev=n4;
//        n5.next=n6;
//        n6.prev=n5;
//        n3.child=n7;
//        n7.next=n8;
//        n8.prev=n7;
//        n8.next=n9;
//        n9.prev=n8;
//        n9.next=n10;
//        n10.prev=n9;
//        n8.child=n11;
//        n11.next=n12;
//        n12.prev=n11;
//        NaryTreeLevelOrderTraversal.flatten(n1);

//        MinimumGeneticMutation.minMutation("AAAACCCC","CCCCCCCC",new String[]{"AAAACCCA","AAACCCCA","AACCCCCA","AACCCCCC","ACCCCCCC","CCCCCCCC","AAACCCCC","AACCCCCC"});

//        AllOOneDataStructure.AllOne test=new AllOOneDataStructure.AllOne();
//        test.inc("hello");
//        test.inc("hello");
//        test.getMaxKey();
//        test.getMinKey();
//        test.inc("leet");
//        test.getMaxKey();
//        test.getMinKey();

//        FindRightInterval.findRightInterval(new int[][]{{-100,-92},{-99,-49},{-98,-24},{-97,-38},{-96,-65},{-95,-22},{-94,-49},{-93,-14},{-92,-68},{-91,-81}});

//        KthSmallestInLexicographicalOrder.findKthNumber(100, 99);

//        ArithmeticSlicesIISubsequence.numberOfArithmeticSlices(new int[]{2,2,3,4});

//        MinimumNumberOfArrowsToBurstBalloons.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}});

//        FourSumII.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2});

//        MinimumMovesToEqualArrayElementsII.minMoves2(new int[]{203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143});

//        CanIWin.canIWin(4, 6);

//        ValidateIPAddress validateIPAddress=new ValidateIPAddress();
//        validateIPAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");

//        LQConvexPolygon.isConvex(new int[][]{{0,0},{10,0},{15,10},{10,20},{0,20},{-5,10}});
    }
}
