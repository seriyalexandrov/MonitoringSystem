package com.kalashnikov.monitoring;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Configurator {

    public void  marshaller(Config myConfig) {

        try {
            JAXBContext context = JAXBContext.newInstance(Config.class);
            Marshaller marshaller = context.createMarshaller();
            File inputConfig = new File("resources//Config.xml");
            OutputStream outStream = null;

            try {
                outStream = new FileOutputStream(inputConfig);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            marshaller.marshal(myConfig, outStream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public Config  unMarshaller() {

        Config myConfig = new Config();

        try {
            JAXBContext context = JAXBContext.newInstance(Config.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            File xmlFile = new File("resources//Config.xml");
            myConfig = (Config) unmarshaller.unmarshal(xmlFile);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return myConfig;

    }

}