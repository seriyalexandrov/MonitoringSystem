package com.kalashnikov.monitoring.configurator.jaxb;

import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
            if (it.next().getName() == optionName) {
                result = false;
                break;
            }
        }

        if (!result) {
            try {
                throw new UnsupportedOperationException();
            } catch (UnsupportedOperationException e) {
                log.error("Option \"" + optionName + "\" is already exist", e);
            }
            throw new UnsupportedOperationException();
        }

        Option option = new Option();
        option.setName(optionName);
        option.setValue(optionValue);
        options.addOption(option);
        Flush();

    }

    public void deleteOption(String optionName) {

        Iterator<Option> it = options.getOptions().iterator();
        Option option;
        Boolean result = false;

        while (it.hasNext()) {
            option = it.next();
            if (option.getName() == optionName) {
                options.getOptions().remove(option);
                result = true;
                break;
            }
        }

        if (!result) {
            try {
                throw new NoSuchElementException();
            } catch (NoSuchElementException e) {
                log.error("Option \"" + optionName + "\" not found", e);
            }
            throw new NoSuchElementException();
        }

        Flush();

    }

    public void updateOptionValue(String optionName, String newOptionValue) {

        Iterator<Option> it = options.getOptions().iterator();
        Option option;
        Boolean result = false;

        while (it.hasNext()) {
            option = it.next();
            if (option.getName() == optionName) {
                options.getOptions().get(options.getOptions().indexOf(option)).setValue(newOptionValue);
                result = true;
                break;
            }
        }

        if (!result) {
            try {
                throw new NoSuchElementException();
            } catch (NoSuchElementException e) {
                log.error("Option \"" + optionName + "\" not found", e);
            }
            throw new NoSuchElementException();
        }

        Flush();

    }

    public String getOptionValue(String optionName) {

        Iterator<Option> it = options.getOptions().iterator();
        Option option = new Option();
        Boolean result = false;

        while (it.hasNext()) {
            option = it.next();
            if (option.getName() == optionName) {
                result = true;
                break;
            }
        }

        if (!result) {
            try {
                throw new NoSuchElementException();
            } catch (NoSuchElementException e) {
                log.error("Option \"" + optionName + "\" not found", e);
            }
            throw new NoSuchElementException();
        }

        return option.getValue();

    }

    private void Flush() {

        Configurator.marshaller(options);

    }

}