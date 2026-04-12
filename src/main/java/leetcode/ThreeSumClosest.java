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

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currSum =  nums[i] + nums[left] + nums[right];

                if (currSum == target) {
                    return currSum;
                }

                if (Math.abs(currSum - target) < bestDiff) {
                    bestDiff = Math.abs(currSum - target);
                    closestSum = currSum;
                }


                if (currSum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closestSum;

    }


    boolean isClosestSumInit = false;
    int closestSum;
    public int dfsSolution(int[] nums, int target) {

        List<Integer> path = new ArrayList<>();
        dfs(nums, path, target, 0);

        isClosestSumInit = true; // reset class variable (sloppy but oh well)
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
            if (isNewSumCloser) closestSum = newSum;
        }
    }

}