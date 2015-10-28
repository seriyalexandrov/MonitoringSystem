import com.kalashnikov.monitoring.config.jaxb.Option;
import com.kalashnikov.monitoring.config.jaxb.Options;
import com.kalashnikov.monitoring.config.jaxb.configurator.Configurator;
import org.junit.Before;
import org.junit.Test;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ConfiguratorTest {

    Options listOfOptions = new Options();
    private List<String> namesOfOptions = new ArrayList<String>();
    private List<String> valuesOfOptions = new ArrayList<String>();

    @Before
    public void initTest() {

        namesOfOptions.add("Option1");
        namesOfOptions.add("Option2");
        namesOfOptions.add("Option3");

        valuesOfOptions.add("true");
        valuesOfOptions.add("read only");
        valuesOfOptions.add("1");

        Option option1 = new Option();
        option1.setName(namesOfOptions.get(0));
        option1.setValue(valuesOfOptions.get(0));

        Option option2 = new Option();
        option2.setName(namesOfOptions.get(1));
        option2.setValue(valuesOfOptions.get(1));

        Option option3 = new Option();
        option3.setName(namesOfOptions.get(2));
        option3.setValue(valuesOfOptions.get(2));

        listOfOptions.addOption(option1);
        listOfOptions.addOption(option2);
        listOfOptions.addOption(option3);

    }

    @Test
    public void performTest() {

        Configurator configurator = new Configurator();
        configurator.marshaller(listOfOptions);

        for (int i = 0; i < configurator.unMarshaller().getOptions().size(); i++) {
            assertEquals(configurator.unMarshaller().getOptions().get(i).getName(), namesOfOptions.get(i));
            assertEquals(configurator.unMarshaller().getOptions().get(i).getValue(), valuesOfOptions.get(i));
        }

    }

}