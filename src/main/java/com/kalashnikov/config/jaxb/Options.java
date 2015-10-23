package com.kalashnikov.config.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "OPTIONS")
public class Options {

    List<Option> options;

    @XmlElement(name = "OPTION")
    public void setOptions(List<Option> options) {
        this.options = options;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void addOption(Option option) {
        if (this.options == null) {
            this.options = new ArrayList<Option>();
        }
        this.options.add(option);
    }

}