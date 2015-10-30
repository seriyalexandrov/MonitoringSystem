import com.kalashnikov.monitoring.algorithm.ExponentialSmoothing;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExponentialSmoothingTest {
    public static final double OPERATION_VALUE = 1.98;

    @Test
    public void performTest() {
        ExponentialSmoothing mySeries = new ExponentialSmoothing();
        assertEquals(Math.round(mySeries.predictNextValue(mySeries.createSeries(2.99, 2.66, 2.63, 2.56, 2.40, 2.22, 1.97, 1.72, 1.56, 1.42))), 1.95, 0.1);
    }
}