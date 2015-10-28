import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JustATestExample {

    public static final int OPERATION_VALUE = 2;
    private int a;
    private int b;

    @Before
    public void initTest() {
        a = 1;
        b = 1;
    }

    @Test
    public void performTest() {
        int c = a + b;
        assertEquals(c, OPERATION_VALUE);
    }

    @Test
    public void aaaa() {
        int c = a + b;
        assertEquals(c, OPERATION_VALUE);
    }

    @After
    public void finishTest() {
        a = 0;
        b = 0;
    }

}