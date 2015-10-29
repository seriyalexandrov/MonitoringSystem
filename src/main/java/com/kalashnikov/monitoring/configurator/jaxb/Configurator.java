package com.kalashnikov.monitoring.configurator.jaxb;

import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

class Configurator {

    private static final String CONFIG_FOLDER = "src//main//resources//Config.xml";
    private static Logger log = Logger.getLogger(Configurator.class);

    public static void  marshaller(Options myOptions) {

        try {
            JAXBContext context = JAXBContext.newInstance(Options.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(myOptions, new File(CONFIG_FOLDER));
        } catch (JAXBException e) {
            log.error(e);
        }

    }

    public static Options  unMarshaller() {

        Options myOptions = new Options();

        try {
            JAXBContext context = JAXBContext.newInstance(Options.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xmlFile = new File(CONFIG_FOLDER);
            myOptions = (Options) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            log.error(e);
        }

        return myOptions;

    }

}