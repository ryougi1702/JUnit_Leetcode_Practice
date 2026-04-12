package leetcode;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//16. 3Sum Closest
//Solved
//        Medium
//Topics
//premium lock icon
//        Companies
//Given an integer array nums of length n and an integer target, find three integers at distinct indices in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
//
//
//        Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
//
//
//Constraints:
//
//        3 <= nums.length <= 500
//        -1000 <= nums[i] <= 1000
//        -104 <= target <= 104
public class ThreeSumClosest {

    public int twoPointerSolution(int[] nums, int target) {

        Arrays.sort(nums);
        int closestSum = Integer.MAX_VALUE; // this is always the worst outcome
        int bestDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int leftRightSum = nums[left] + nums[right];
            for (int i = left + 1; i < right; i++) {
                int threeSum = leftRightSum + nums[i];
                int absDiff =  Math.abs(target - threeSum);

                if (absDiff == 0) return threeSum;

                if (absDiff < bestDiff) {
                    bestDiff = absDiff;
                    closestSum = threeSum;
                }
            }

            if (leftRightSum > target) {
                right--;
            } else {
                left++;
            }
        }
        return closestSum;
    }


    boolean isClosestSumInit = false;
    int closestSum;
    public int dfsSolution(int[] nums, int target) {

        List<Integer> path = new ArrayList<>();
        dfs(nums, path, target, 0);

        System.out.println("returning closest sum: " + closestSum);
        return closestSum;
    }

    private void dfs(int[] nums, List<Integer> path, int target, int currIndex) {
        if (path.size() == 3) {
            int newSum =  path.get(0) + path.get(1) + path.get(2);
            updateClosestSum(newSum, target);
            return;
        }

        for (int i = currIndex; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(nums, path, target, i+1);
            path.removeLast();
        }

    }
    private void updateClosestSum(int newSum, int target) {
        if (!isClosestSumInit) {
            closestSum = newSum;
            isClosestSumInit = true;
        } else {
            boolean isNewSumCloser = Math.abs(newSum - target) < Math.abs(closestSum - target);
            System.out.printf("is new sum %d closer: " + isNewSumCloser + "\n", newSum);
            if (isNewSumCloser) closestSum = newSum;
            System.out.println("closestSum is now: " + closestSum);
        }
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
    }
}