import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class LoggerExample {

    private Logger log;

    @Before
    public void createLogger() {
        log = Logger.getLogger(LoggerExample.class);
    }

    @Test
    public void test() {
        log.fatal("Fatal error!!!!");
    }
}
