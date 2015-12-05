import com.kalashnikov.monitoring.algorithms.SingleExponentialSmoothing;
import com.kalashnikov.monitoring.algorithms.TimeSeriesManager;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SingleExponentialSmoothingTest {

    public static final double PREDICTED_VALUE_1 = 1;
    public static final double PREDICTED_VALUE_2 = 1.5440;

    @Test
    public void performTest1() {

        TimeSeriesManager timeSeriesManager = new TimeSeriesManager();
        timeSeriesManager.setPeriod(10);
        timeSeriesManager.add(1);
        timeSeriesManager.add(1);
        timeSeriesManager.add(1);
        timeSeriesManager.add(1);
        timeSeriesManager.add(1);

        SingleExponentialSmoothing singleExponentialSmoothing = new SingleExponentialSmoothing();
        singleExponentialSmoothing.setTimeSeriesManager(timeSeriesManager);

        assertTrue(singleExponentialSmoothing.predictNextValue() - PREDICTED_VALUE_1 < 0.0001);

    }

    @Test
    public void performTest2() {

        TimeSeriesManager timeSeriesManager = new TimeSeriesManager();
        timeSeriesManager.setPeriod(1000);
        timeSeriesManager.add(1);
        timeSeriesManager.add(2);
        timeSeriesManager.add(1);
        timeSeriesManager.add(2);

        SingleExponentialSmoothing singleExponentialSmoothing = new SingleExponentialSmoothing();
        singleExponentialSmoothing.setTimeSeriesManager(timeSeriesManager);

        assertTrue(singleExponentialSmoothing.predictNextValue() - PREDICTED_VALUE_2 < 0.0001);

    }

}