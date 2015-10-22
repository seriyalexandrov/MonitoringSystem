package com.kalashnikov.config.jaxb;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Properties")
@XmlAccessorType(XmlAccessType.NONE)
public class Config {

    private Boolean property1;
    private String property2;
    private int property3;

    public void setProperty1(Boolean property1) {
        this.property1 = property1;
    }

    @XmlElement(name = "Property1")
    public Boolean getProperty1() {
        return property1;
    }

    public void setProperty2(String property2) {
        this.property2 = property2;
    }

    @XmlElement(name = "Property2")
    public String getProperty2() {
        return property2;
    }

    public void setProperty3(int property3) {
        this.property3 = property3;
    }

    @XmlElement(name = "Property3")
    public int getProperty3() {
        return property3;
    }

}