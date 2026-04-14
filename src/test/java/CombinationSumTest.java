import leetcode.CombinationSum;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class CombinationSumTest {

    CombinationSum cs = new CombinationSum();
//    Input: candidates = [2,3,6,7], target = 7
//    Output: [[2,2,3],[7]]

    record TestCase(int[] candidates, int target, List<List<Integer>> expected) {}

    TestCase sanityCase = new TestCase(
            new int[]{2, 3, 6, 7},
            7,
            List.of(
                    List.of(2, 2, 3),
                    List.of(7)
            )
    );
    TestCase testCase1 = new TestCase(
            new int[]{1},
            1,
            List.of(
                    List.of(1)
            )
    );

    @Test
    void sanityCheck() {
        List<List<Integer>> output = cs.combinationSum(sanityCase.candidates,  sanityCase.target);
        assertEquals(sanityCase.expected, output);
    }

    @Test
    void test1() {
        List<List<Integer>> output = cs.combinationSum(testCase1.candidates,  testCase1.target);
        assertEquals(testCase1.expected, output);
    }
    // helper function to measure execution time

}