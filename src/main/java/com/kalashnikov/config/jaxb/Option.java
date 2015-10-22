package com.kalashnikov.config.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "OPTION")
public class Option {

    String name;
    Object value;

    @XmlElement(name = "OPTION_NAME")
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "OPTION_VALUE")
    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}