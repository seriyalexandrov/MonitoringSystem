package com.kalashnikov.monitoring.config.apache.xml;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class Configurator {

    private static final Logger log = Logger.getLogger(Configurator.class);


    public String xmlSimpleReader() {

        //creating base for our XML file
        XMLConfiguration config = null;
        try {
            config = new XMLConfiguration("const.xml");
        } catch (ConfigurationException e) {
            log.error("Error ocurred while config was created");
        }

        /**
         * Then, first, check the condition of STOPPING :
         *  If there is more key in file, we continue
         *  and get string
         *  int i  - counter
         */
        int i = 0;
        while(config.containsKey("databases.database(" + i + ").url")) {
            config.getString("databases.database(" + i + ").url");
            i++;
        }

        //config lets us to get Document by calling its function getDocument
        Document document = config.getDocument();
        String xmlDocument = docToString(document);
        return xmlDocument;
    }

    public String docToString(Document doc) {
        try {
            StringWriter sw = new StringWriter();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.transform(new DOMSource(doc), new StreamResult(sw));
            return sw.toString();
        } catch (Exception ex) {
            throw new RuntimeException("Error converting to String", ex);
        }
    }

}