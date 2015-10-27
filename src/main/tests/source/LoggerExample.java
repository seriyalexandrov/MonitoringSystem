import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LoggerExample {

    private Logger log = Logger.getLogger(LoggerExample.class);

    @Before
    public void createLogger() {

    }

    @Test
    public void test() {

        try {
            throw new Exception("error!");
        } catch (Exception e) {
            log.fatal("Fatal error occurred in test", e);
        }


    }
}
