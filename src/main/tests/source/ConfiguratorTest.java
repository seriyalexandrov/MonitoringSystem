import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;

import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class ConfiguratorTest {

    File config = new File("src//main//resources//Config.xml");
    byte[] byteRepresentationOfConfig = new byte[(int) config.length()];
    private Logger log = Logger.getLogger(ConfiguratorTest.class);

    @Before
    public void initTest() {

        try {

            InputStream is = new FileInputStream(config);
            int offset = 0;
            int numRead;
            while (offset < byteRepresentationOfConfig.length &&
                    (numRead = is.read(byteRepresentationOfConfig, offset, byteRepresentationOfConfig.length - offset))
                            >= 0) {
                offset += numRead;
            }
            if (offset < byteRepresentationOfConfig.length) {
                throw new IOException();
            }
            is.close();

        } catch (FileNotFoundException e) {
            log.error("Could not find file " + config.getName(), e);
        } catch (IOException e) {
            log.error("Could not completely read file " + config.getName(), e);
        }

        try {
            if (config.delete()) {
                config.createNewFile();
            }
        } catch (IOException e) {
            log.error("Could not rewrite file " + config.getName(), e);
        }

    }

    @Test
    public void performTest() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();

        configurationManager.addOption("Option1", "false");
        configurationManager.addOption("Option2", "read only");
        configurationManager.addOption("Option3", "0");

        assertEquals(configurationManager.getOptionValue("Option1"), "false");
        assertEquals(configurationManager.getOptionValue("Option2"), "read only");
        assertEquals(configurationManager.getOptionValue("Option3"), "0");

        configurationManager.updateOptionValue("Option3", "1");

        assertEquals(configurationManager.getOptionValue("Option3"), "1");

    }

    @Rule public ExpectedException thrown = ExpectedException.none();
    @Test
    public void performTestException() {

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();

        configurationManager.deleteOption("Option3");

        thrown.expect(NoSuchOptionException.class);
        configurationManager.getOptionValue("Option3");

    }

    @After
    public void finishTest() {

        try {

            FileOutputStream fos = new FileOutputStream(config);
            fos.write(byteRepresentationOfConfig);
            fos.close();

        } catch (FileNotFoundException e) {
            log.error("Could not find file " + config.getName(), e);
        } catch (IOException e) {
            log.error("Could not completely write file " + config.getName(), e);
        }

    }

}