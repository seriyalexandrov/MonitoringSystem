import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConfiguratorTest {

    @Test
    public void performTest() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();

        configurationManager.addOption("Option1", "true");
        configurationManager.addOption("Option2", "read only");
        configurationManager.addOption("Option3", "0");

        assertEquals(configurationManager.getOptionValue("Option1"), "true");
        assertEquals(configurationManager.getOptionValue("Option2"), "read only");
        assertEquals(configurationManager.getOptionValue("Option3"), "0");

        configurationManager.updateOptionValue("Option3", "1");

        assertEquals(configurationManager.getOptionValue("Option3"), "1");

        /*configurationManager.deleteOption("Option1");
        configurationManager.deleteOption("Option1");

        configurationManager.addOption("Option2", "read and write");

        configurationManager.updateOptionValue("Option4", "15 sec");

        configurationManager.getOptionValue("Option4");*/

    }

}