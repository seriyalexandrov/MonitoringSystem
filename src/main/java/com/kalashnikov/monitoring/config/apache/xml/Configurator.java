package com.kalashnikov.monitoring.config.apache.xml;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;

import java.util.Map;
import java.util.TreeMap;

public class Configurator {

    private static final Logger log = Logger.getLogger(Configurator.class);
    public static final String ERROR_OCURRED_WHILE_CONFIG_WAS_CREATED = "Error ocurred while config was created";
    public static final String FILE_NAME = "config.xml";


    public Map<String, String> xmlConfiguratorReader() {

        Map<String, String> options = new TreeMap<String, String>();

        XMLConfiguration config = null;
        try {
            config = new XMLConfiguration(FILE_NAME);
        } catch (ConfigurationException e) {
            log.error(ERROR_OCURRED_WHILE_CONFIG_WAS_CREATED);
        }

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