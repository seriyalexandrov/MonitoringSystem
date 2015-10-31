package com.kalashnikov.monitoring.config.apache.xml;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;

import java.util.LinkedHashMap;
import java.util.Map;

public class Configurator {

    private static final Logger log = Logger.getLogger(Configurator.class);


    public Map<String, String> xmlConfiguratorReader() {

        //creating an object to contain content of XML-file
        Map<String, String> options = new LinkedHashMap<String, String>();

        //creating base for our XML file
        XMLConfiguration config = null;
        try {
            config = new XMLConfiguration("config.xml");
        } catch (ConfigurationException e) {
            log.error("Error ocurred while config was created");
        }

        /**
         * Then, first, check the condition of STOPPING :
         *  If there is more key in file, we continue
         *  and get string
         *  int i  - counter
         */
        int i = 0;

        while(config.containsKey("option(" + i + ").option_name")) {
            String option_name = config.getString("option(" + i + ").option_name");
            String option_value = config.getString("option(" + i + ").option_value");
            options.put(option_name, option_value);
            i++;
        }

        return options;
    }

}