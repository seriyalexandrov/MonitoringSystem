package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.config.jaxb.Option;
import com.kalashnikov.monitoring.config.jaxb.Options;
import com.kalashnikov.monitoring.config.jaxb.configurator.Configurator;

public class SystemExecutor {

    private static OrderLogic logic;

    public static void main(String[] args) {

        System.out.println("Executed!");
        System.out.println("Hello ");

        Option option1 = new Option();
        option1.setName("Option1");
        option1.setValue("true");

        Option option2 = new Option();
        option2.setName("Option2");
        option2.setValue("read only");

        Option option3 = new Option();
        option3.setName("Option3");
        option3.setValue("1");

        Options listOfOptions = new Options();
        listOfOptions.addOption(option1);
        listOfOptions.addOption(option2);
        listOfOptions.addOption(option3);

        Configurator configurator = new Configurator();
        configurator.marshaller(listOfOptions);

        for (int i = 0; i < configurator.unMarshaller().getOptions().size(); i++) {
            System.out.println(configurator.unMarshaller().getOptions().get(i).getName()
                    + ": " + configurator.unMarshaller().getOptions().get(i).getValue());
        }

        //Here is how we do logging :
        System.out.println("\nLet's try to check some logging :\n");
        logic = new OrderLogic();
        logic.doOrder();

    }

}