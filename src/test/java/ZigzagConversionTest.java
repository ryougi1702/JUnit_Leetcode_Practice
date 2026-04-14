import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Test;
import leetcode.ZigzagConversion;

import java.time.Duration;
import java.time.Instant;

public class ZigzagConversionTest {

    // helper function to measure execution time
    void assertTimeoutAndPrint(Duration timeout, Runnable executable) {
        Instant start = Instant.now();
        try {
            assertTimeout(timeout, executable::run);
        } finally {
            Instant end = Instant.now();
            System.out.println("Execution time: " + Duration.between(start, end).toMillis() + "ms");
        }
    }


    ZigzagConversion zigzag = new ZigzagConversion();
    @Test
    public void testZigzagConversion() {
        String output1 = zigzag.convert("PAYPALISHIRING", 3);

        assertEquals("PAHNAPLSIIGYIR", output1);
    }
    @Test
    public void testZigzagConversionSingleRow() {
        String output1 = zigzag.convert("PAYPALISHIRING", 1);

        assertEquals("PAYPALISHIRING", output1);
    }

    @Test
    public void testZigzagConversionTime() {
        assertTimeoutAndPrint(Duration.ofSeconds(1), () -> zigzag.convert("PAYPALISHIRING", 3));
    }
}
