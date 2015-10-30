import org.junit.Test;
import com.kalashnikov.monitoring.config.apache.xml.Configurator;

public class ApacheTest {

    @Test
    public void performTest() {
        Configurator configurator = new Configurator();
        System.out.println(configurator.xmlSimpleReader());
    }

}