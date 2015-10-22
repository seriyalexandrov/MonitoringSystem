package com.kalashnikov.monitoring;

import com.kalashnikov.config.jaxb.Config;
import com.kalashnikov.config.jaxb.configurator.Configurator;

public class SystemExecutor {

    public static void main(String[] args) {
        System.out.println("Executed!");
        System.out.println("Hello ");
        Config myConfig = new Config();
        myConfig.setProperty1(true);
        myConfig.setProperty2("read only");
        myConfig.setProperty3(1);
        Configurator configurator = new Configurator();
        configurator.marshaller(myConfig);
        myConfig = configurator.unMarshaller();
        System.out.println(myConfig.getProperty1());
        System.out.println(myConfig.getProperty2());
        System.out.println(myConfig.getProperty3());
    }
}