import org.junit.Test;
import com.kalashnikov.monitoring.config.apache.xml.Configurator;

public class ConfiguratorApacheTest {

    @Test
    public void performTest() {
        System.out.println(Configurator.xmlSimpleReader());
    }

}