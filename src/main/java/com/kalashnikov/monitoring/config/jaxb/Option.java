package com.kalashnikov.monitoring.config.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "option")
public class Option {

    String name;
    String value;

    @XmlElement(name = "option_name")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "option_value")
    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}