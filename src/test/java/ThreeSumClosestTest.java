import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import leetcode.ThreeSumClosest;

class ThreeSumClosestTest {

    @Test
    void threeSumClosest() {

        ThreeSumClosest x = new ThreeSumClosest();

        int test1Result = x.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        int test2Result = x.threeSumClosest(new int[]{0,0,0}, 0);

        assertEquals(2, test1Result);
        assertEquals(0, test2Result);
    }

}