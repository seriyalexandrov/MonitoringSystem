import org.junit.Before;
import org.junit.Test;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class ConfiguratorTest {

    @Before
    public void initTest() {

        List<String> namesOfOptions = new ArrayList<String>();
        nameOfOptions.add("Option1");
        nameOfOptions.add("Option2");
        nameOfOptions.add("Option3");

        List<String> valuesOfOptions = new ArrayList<String>();
        nameOfOptions.add("true");
        nameOfOptions.add("read only");
        nameOfOptions.add("1");

        Option option1 = new Option();
        option1.setName(nameOfOptions.get(0));
        option1.setValue(valueOfOptions.get(0));

        Option option2 = new Option();
        option2.setName(nameOfOptions.get(1));
        option2.setValue(valueOfOptions.get(1));

        Option option3 = new Option();
        option3.setName(nameOfOptions.get(2));
        option3.setValue(valueOfOptions.get(2));

        Options listOfOptions = new Options();
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