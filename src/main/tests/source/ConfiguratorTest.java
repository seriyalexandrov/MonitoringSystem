import com.kalashnikov.monitoring.configurator.jaxb.ConfigurationManager;

import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConfiguratorTest {

    private static final String CONFIG_FOLDER = "src//main//resources//Config.xml";
    File config = new File(CONFIG_FOLDER);
    String configFileContent = null;
    private Logger log = Logger.getLogger(ConfiguratorTest.class);

    @Before
    public void initTest() {

        try {
            configFileContent = new String(Files.readAllBytes(Paths.get(CONFIG_FOLDER)),
                    StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("Could not read file " + config.getName(), e);
        }


        try {
            if (config.delete()) {
                if (!config.createNewFile()) {
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            log.error("Could not rewrite file " + config.getName(), e);
        }

    }

    @Test
    public void performTest() throws NoSuchOptionException {

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

    @Test
    public void performTestException() {

        boolean thrown = false;

        ConfigurationManager configurationManager = ConfigurationManager.getInstance();

        configurationManager.deleteOption("Option3");

        try {
            configurationManager.getOptionValue("Option3");
        } catch (NoSuchOptionException e) {
            thrown = true;
        }

        if (!thrown) {

            try {
                FileOutputStream fos = new FileOutputStream(config);
                fos.write(configFileContent.getBytes());
                fos.close();
            } catch (IOException e) {
                log.error("Could not write file " + config.getName(), e);
            }
            assertTrue(!thrown);

        }

    }

    @After
    public void finishTest() {

        try {
            FileOutputStream fos = new FileOutputStream(config);
            fos.write(configFileContent.getBytes());
            fos.close();
        } catch (IOException e) {
            log.error("Could not write file " + config.getName(), e);
        }


    }

}