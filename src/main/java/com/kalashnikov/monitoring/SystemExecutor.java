package com.kalashnikov.monitoring;

import com.kalashnikov.monitoring.config.jaxb.Option;
import com.kalashnikov.monitoring.config.jaxb.Options;
import com.kalashnikov.monitoring.config.jaxb.configurator.Configurator;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SystemExecutor {

    // »нициализаци€ логера : аргумент может быть любым названием которое
    //ћы захотим выбрать. ¬ данном случае передаетс€ название класса
    //Ёто удобно : так мы легко можем пон€ть где произошла ошибка
    private static final Logger log = Logger.getLogger(SystemExecutor.class);
    //private static final Logger log = Logger.getLogger("bacon"); --возможный вариант


    public static void main(String[] args) {

        //Here is how we do logging :
        //BasicConfigurator.configure();
        //debug message
        //log.debug("This is a debug message");
        log.info("This is informative message!");
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            log.error("This is an exception", e);
        }

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

    }

}