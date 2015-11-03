import com.kalashnikov.monitoring.algorithm.linear.trend.LinearTrend;
import com.kalashnikov.monitoring.algorithm.linear.trend.TimeSeriesManager;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LinearTrendTest {

    private static final double PREDICTED_VALUE_1 = 6;
    private static final double PREDICTED_VALUE_2 = 1;
    private static final double PREDICTED_VALUE_3 = 7;

    @Test
    public void performTest1() {

        TimeSeriesManager timeSeriesManager = new TimeSeriesManager();
        timeSeriesManager.setPeriod(10);
        timeSeriesManager.add(1);
        timeSeriesManager.add(2);
        timeSeriesManager.add(3);
        timeSeriesManager.add(4);
        timeSeriesManager.add(5);

        LinearTrend linearTrend = new LinearTrend(timeSeriesManager);

        assertTrue(linearTrend.predictNextValue() - PREDICTED_VALUE_1 < 0.00001);

    }

    @Test
    public void performTest2() {

        TimeSeriesManager timeSeriesManager = new TimeSeriesManager();
        timeSeriesManager.setPeriod(100);
        timeSeriesManager.add(6);
        timeSeriesManager.add(5);
        timeSeriesManager.add(4);
        timeSeriesManager.add(3);
        timeSeriesManager.add(2);

        LinearTrend linearTrend = new LinearTrend(timeSeriesManager);

        assertTrue(linearTrend.predictNextValue() - PREDICTED_VALUE_2 < 0.00001);

    }

    @Test
    public void performTest3() {

        TimeSeriesManager timeSeriesManager = new TimeSeriesManager();
        timeSeriesManager.setPeriod(1000);
        timeSeriesManager.add(7);
        timeSeriesManager.add(7);
        timeSeriesManager.add(7);
        timeSeriesManager.add(7);
        timeSeriesManager.add(7);

        LinearTrend linearTrend = new LinearTrend(timeSeriesManager);

        assertTrue(linearTrend.predictNextValue() - PREDICTED_VALUE_3 < 0.00001);

    }

}