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

    }

}