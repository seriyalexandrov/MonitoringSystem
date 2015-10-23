package com.kalashnikov.config.jaxb.configurator;

import com.kalashnikov.config.jaxb.Options;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Configurator {

    public void  marshaller(Options myOptions) {

        try {
            JAXBContext context = JAXBContext.newInstance(Options.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(myOptions, new File("resources//Config.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public Options  unMarshaller() {

        Options myOptions = new Options();

        try {
            JAXBContext context = JAXBContext.newInstance(Options.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xmlFile = new File("resources//Config.xml");
            myOptions = (Options) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return myOptions;

    }

}