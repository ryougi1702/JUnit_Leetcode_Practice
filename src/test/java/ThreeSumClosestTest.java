import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import leetcode.ThreeSumClosest;

class ThreeSumClosestTest {

    record TestInput(int[] nums, int target) {}

    TestInput input1 = new TestInput(new int[]{-1,2,1,-4}, 1);
    TestInput input2 = new TestInput(new int[]{0, 0, 0}, 0);
    TestInput input3 = new TestInput(new int[]{-4,2,2,3,3,3}, 0);

    @Test
    void dfsSolution() {

        ThreeSumClosest x = new ThreeSumClosest();

        int test1Result = x.dfsSolution(input1.nums, input1.target);
        int test2Result = x.dfsSolution(input2.nums, input2.target);
        int test3Result = x.dfsSolution(input3.nums, input3.target);

        assertEquals(2, test1Result);
        assertEquals(0, test2Result);
        assertEquals(0, test3Result);
    }

    @Test
    void twoPointerSolution() {

        ThreeSumClosest x = new ThreeSumClosest();

        int test1Result = x.twoPointerSolution(input1.nums, input1.target);
        int test2Result = x.twoPointerSolution(input2.nums, input2.target);
        int test3Result = x.twoPointerSolution(input3.nums, input3.target);
        //[-4,2,2,3,3,3]

        assertEquals(2, test1Result);
        assertEquals(0, test2Result);
        assertEquals(0, test3Result);
    }


}