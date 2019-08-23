import com.wen.EleventhFifty.LongestPalindromicSubsequence;
import com.wen.FifteenthFifty.*;
import com.wen.FirstFifty.*;
import com.wen.FourteenthFifty.SplitArrayIntoConsecutiveSubsequences;
import com.wen.NinthFifty.LQSequenceReconstruction;
import com.wen.SeventeenthFifty.BricksFallingWhenHit;
import com.wen.SeventeenthFifty.ExpressiveWords;
import com.wen.SeventeenthFifty.FindEventualSafeStates;
import com.wen.SeventeenthFifty.SplitArrayWithSameAverage;
import com.wen.SixteenthFifty.*;

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
//        test.reverseKGroup(l1,3);

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

//        int[] nums={1,1,2};
//        PermutationsII.permuteUnique(nums);

//        int[][] multi = new int[][]{
//                { 1,2,5 },
//                { 3,2,1 }
//        };
//        MinimumPathSum.minPathSum(multi);

//        String[] words={"This", "is", "an", "example", "of", "text", "justification."};
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

//        WordBreakII.wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog"));

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

//        WildcardMatching.isMatch("adceb", "*a*b");

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

//        WordSearchII.findWords(new char[][]{{'a','a'}}, new String[]{"aaa"});

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

//        LQOptimalAccountBalancing.balanceGraph(new int[][]{{0,1,10},{1,0,1},{1,2,5},{2,0,5}});

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
//        accounts.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
//        accounts.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
//        accounts.add(Arrays.asList("Mary","mary@mail.com"));
//        accounts.add(Arrays.asList("John","johnnybravo@mail.com"));
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

//        LQSequenceReconstruction.sequenceReconstruction(new int[]{1,2,3}, new int[][]{{1,2}, {1,3}, {2,3}});

//        CheapestFlightsWithinKStops.findCheapestPrice(3, new int[][]{{0,1,100}, {1,2,100}, {0,2,500}}, 0, 2, 1);

//        SwapAdjacentInLRString.canTransform("XXXLXXXXXX","XXXLXXXXXX");

//        LQMinimizeMaxDistanceToGasStation.minmaxGasDist(new int[]{1,2,3,4,5,6,7,8,9,10}, 9);

//        IsGraphBipartite.isBipartite(new int[][]{{3},{2,4},{1},{0,4},{1,3}});

//        FindEventualSafeStates.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}});

//        AirbnbTest.evaluateActions(Arrays.asList("A Munich Hold", "B Bohemia Move Munich", "C Warsaw Support B"));

//        BricksFallingWhenHit.hitBricks(new int[][]{{1},{1},{1},{1},{1}},
//                new int[][]{{3,0},{4,0},{1,0},{2,0},{0,0}});

//        SplitArrayWithSameAverage.splitArraySameAverage(new int[]{2,12,18,16,19,3});

//        ExpressiveWords.expressiveWords("yyrrrrrjaappoooyybbbebbbbriiiiiyyynnnvvwtwwwwwooeeexxxxxkkkkkaaaaauuuu", new String[]{"yrrjjappooybbebriiyynvvwtwwoeexkauu"});
    }
}
