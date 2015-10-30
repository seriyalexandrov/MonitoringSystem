package com.kalashnikov.monitoring.configurator.jaxb;

import com.kalashnikov.monitoring.exceptions.NoSuchOptionException;

import org.apache.log4j.Logger;

import java.util.Iterator;

public final class ConfigurationManager {

    private Options options;
    private Logger log = Logger.getLogger(ConfigurationManager.class);

    private ConfigurationManager() {

        options = Configurator.unMarshaller();

    }

    private static class InstanceHolder {

        private static final ConfigurationManager instance = new ConfigurationManager();

    }

    public static ConfigurationManager getInstance() {

        return InstanceHolder.instance;

    }

    public void addOption(String optionName, String optionValue) {

        Iterator<Option> it = options.getOptions().iterator();
        Boolean result = true;

        while (it.hasNext()) {
            if (it.next().getName().equals(optionName)) {
                result = false;
                break;
            }
        }

        if (result) {
            Option option = new Option();
            option.setName(optionName);
            option.setValue(optionValue);
            options.addOption(option);
            Flush();
        }

    }

    public void deleteOption(String optionName) {

        Iterator<Option> it = options.getOptions().iterator();
        Option option;
        Boolean result = false;

        while (it.hasNext()) {
            option = it.next();
            if (option.getName().equals(optionName)) {
                options.getOptions().remove(option);
                result = true;
                break;
            }
        }

        if (result) {
            Flush();
        }

    }

    public void updateOptionValue(String optionName, String newOptionValue) {

        Iterator<Option> it = options.getOptions().iterator();
        Option option;
        Boolean result = false;

        while (it.hasNext()) {
            option = it.next();
            if (option.getName().equals(optionName)) {
                options.getOptions().get(options.getOptions().indexOf(option)).setValue(newOptionValue);
                result = true;
                break;
            }
        }

        if (result) {
            Flush();
        }

    }

    public String getOptionValue(String optionName) {

        Iterator<Option> it = options.getOptions().iterator();
        Option option = new Option();
        Boolean result = false;

        while (it.hasNext()) {
            option = it.next();
            if (option.getName().equals(optionName)) {
                result = true;
                break;
            }
        }

        if (!result) {
            try {
                throw new NoSuchOptionException();
            } catch (NoSuchOptionException e) {
                log.error("Option \"" + optionName + "\" not found", e);
            }
            System.out.println("Option \"" + optionName + "\" not found");
            System.exit(-1);
        }

        return option.getValue();

    }

    private void Flush() {

        Configurator.marshaller(options);

    }

}