package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private List<List<Integer>> result;
    private int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.result = new ArrayList<>();
        this.candidates = candidates;
        List<Integer> path = new ArrayList<>();
        dfs(path, 0, target);

        return result;
    }

    public void dfs(List<Integer> path, int i, int target) {
        int currSum = path.stream().mapToInt(Integer::intValue).sum();
        if (currSum == target) {
            this.result.add(new ArrayList<>(path));
            return;
        }


        for (int j = i;  j < candidates.length; j++) {
            // if adding the current candidate exceeds target, no point adding the ones after
            if (currSum + candidates[j] > target) {
                return;
            }
            path.add(candidates[j]);
            dfs(path, j, target);
            path.removeLast();
        }
    }
}
