import org.junit.Test;
import com.kalashnikov.monitoring.config.apache.xml.Configurator;

import java.util.Map;

public class ApacheXmlTest {

    @Test
    public void performTest() {
        Configurator configurator = new Configurator();
        Map map = configurator.xmlConfiguratorReader();
        System.out.println(map.entrySet());
    }

}