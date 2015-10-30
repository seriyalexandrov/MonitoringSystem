package com.kalashnikov.monitoring.configurator.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "options")
class Options {

    List<Option> options;

    public  Options() {

        options = new ArrayList<Option>();

    }

    @XmlElement(name = "option")
    public void setOptions(List<Option> options) {

        this.options = options;

    }

    public List<Option> getOptions() {

        return options;

    }

    public void addOption(Option option) {

        this.options.add(option);

    }

}