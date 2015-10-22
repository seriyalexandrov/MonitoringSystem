package com.kalashnikov.monitoring;

import com.kalashnikov.config.jaxb.Option;
import com.kalashnikov.config.jaxb.Options;
import com.kalashnikov.config.jaxb.configurator.Configurator;

public class SystemExecutor {

    public static void main(String[] args) {
        System.out.println("Executed!");
        System.out.println("Hello ");

        Option option1 = new Option();
        option1.setName("option1");
        option1.setValue(true);

        Option option2 = new Option();
        option2.setName("option2");
        option2.setValue("read only");

        Option option3 = new Option();
        option3.setName("option3");
        option3.setValue(1);

        Options listOfOptions = new Options();
        listOfOptions.add(option1);
        listOfOptions.add(option2);
        listOfOptions.add(option3);

        Configurator configurator = new Configurator();
        configurator.marshaller(listOfOptions);
        //System.out.println(configurator.unMarshaller());
    }
}