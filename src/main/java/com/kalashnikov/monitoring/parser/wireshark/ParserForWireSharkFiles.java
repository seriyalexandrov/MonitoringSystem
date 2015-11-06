package com.kalashnikov.monitoring.parser.wireshark;


import com.kalashnikov.monitoring.SystemExecutor;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserForWireSharkFiles {
    private static final Logger log = Logger.getLogger(SystemExecutor.class);
    private static final String PATH_TO_FILE = "src\\main\\resources\\traffic.cap";

    public List<PackageFromWireShark> getPackageListFromFile() {
        List<String> stingsWithRightInformation = getListFromFile(PATH_TO_FILE);
        PackageFromWireShark pack;
        String[] dividedString;
        List<PackageFromWireShark> packageList = new ArrayList<PackageFromWireShark>(stingsWithRightInformation.size());
        for (String stringWithInform : stingsWithRightInformation) {
            dividedString = stringWithInform.split(" +");
            pack = new PackageFromWireShark(Integer.parseInt(dividedString[1]));
            setPackage(pack, dividedString);
            packageList.add(pack);
        }
        return packageList;
    }

    private void setPackage(PackageFromWireShark pack, String[] dividedString) {
        pack.setTime(Double.parseDouble(dividedString[2]));
        pack.setSource(dividedString[3]);
        pack.setDestination(dividedString[4]);
        pack.setProtocol(dividedString[5]);
    }

    private List<String> getListFromFile(String pathToFile) {
        String regex = "^No\\. +Time +Source +Destination +Protocol +$";
        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {

            String line;
            List<String> lines = new ArrayList<String>();
            int flag = 0;
            while ((line = reader.readLine()) != null) {
                if (flag != 0) {
                    lines.add(line);
                    flag = 0;
                }
                if (line.matches(regex)) {
                    flag++;
                }
            }
            return lines;
        } catch (FileNotFoundException fn) {
            log.error("File not find");
            return new ArrayList<String>();
        } catch (IOException ioe) {
            log.error("Error reading");
            return new ArrayList<String>();
        }
    }


}
